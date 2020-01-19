package jack.helloworld.activiti.security;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import jack.helloworld.activiti.common.ReturnCode;
import jack.helloworld.activiti.common.util.MD5Util;
import jack.helloworld.activiti.pojo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(LoginAuthenticationFilter.class);

    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valueOperations;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    private static String TOKEN_PREFIX = "LOGIN_";

    public LoginAuthenticationFilter(String authenticationUrl, AuthenticationManager authenticationManager) {
        super.setFilterProcessesUrl(authenticationUrl);
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 获取 request body 中的 credential
        Employee employee = null;
        try {
            employee = new ObjectMapper().readValue(request.getInputStream(), Employee.class);
        } catch (IOException e) {
            logger.error("", e);
        }

        // 使用 AuthenticationManager 进行验证
        return this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(employee.getUsername(), employee.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // 生成 token
        String token = MD5Util.MD5_32(String.valueOf(authResult.getPrincipal().toString() + System.currentTimeMillis()), "UTF-8");

        // 保存到 redis，2小时过期
        valueOperations.set(TOKEN_PREFIX + token, ((UserDetailsImpl)authResult.getPrincipal()).getUsername());
        redisTemplate.expire(TOKEN_PREFIX + token, 2L, TimeUnit.HOURS);

        // 设置 SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authResult);

        // 终止处理request, 返回 response
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ReturnCode.SUCCESS.getCode());
        jsonObject.put("message", ReturnCode.SUCCESS.getMessage());
        HashMap<String, Object> data = new HashMap<>();
        data.put("token", token);
        jsonObject.put("data", data);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().write(jsonObject.toJSONString());
    }
}
