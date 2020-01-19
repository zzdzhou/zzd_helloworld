package jack.helloworld.activiti.security;

import jack.helloworld.activiti.common.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private static String LOGIN_URL = "/activiti/login";

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(LOGIN_URL).permitAll()
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .addFilter(loginAuthenticationFilter())
//                .addFilter(new TokenAuthenticationFilter())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.MD5_32(String.valueOf(charSequence), "UTF-8");
            }

            @Override
            public boolean matches(CharSequence rowPassword, String encodedPassword) {
                return StringUtils.equals(encode(rowPassword), encodedPassword);
            }
        };
    }

    @Bean
    public LoginAuthenticationFilter loginAuthenticationFilter() throws Exception{
        return new LoginAuthenticationFilter(LOGIN_URL, authenticationManager());
    }


/*
    public AuthenticationEntryPoint authenticationEntryPoint() {
        BasicAuthenticationEntryPoint a = new BasicAuthenticationEntryPoint();
        a.setRealmName("localhost");
        return a;
    }
*/

}
