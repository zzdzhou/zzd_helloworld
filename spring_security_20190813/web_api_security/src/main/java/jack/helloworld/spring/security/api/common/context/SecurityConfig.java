package jack.helloworld.spring.security.api.common.context;

import jack.helloworld.spring.security.api.mybatis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * How to register the springSecurityFilterChain
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // todo
        http
                .authorizeRequests()
                // 相对路径; / 根目录，根目录为 realmname + ${server.servlet.context-path}; ** 匹配多级目录;
                .antMatchers("/admin/**").hasRole(User.Role.ADMIN.name())
                .antMatchers("/**/notfiltered").permitAll()
                .anyRequest().authenticated()// 匹配任何request url
                .and()
                .httpBasic()
                .and()
                .addFilter(basicAuthenticationFilter())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Bean
    public BasicAuthenticationFilter basicAuthenticationFilter() throws Exception {
        return new BasicAuthenticationFilter(authenticationManager(), basicAuthenticationEntryPoint());
    }

    @Bean
    public AuthenticationEntryPoint basicAuthenticationEntryPoint() {
        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint = new BasicAuthenticationEntryPoint();
        basicAuthenticationEntryPoint.setRealmName("localhost");
        return basicAuthenticationEntryPoint;
    }

}




