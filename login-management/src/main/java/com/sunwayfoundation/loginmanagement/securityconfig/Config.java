package com.sunwayfoundation.loginmanagement.securityconfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Config {

    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {

            http
                    .antMatcher("/**").authorizeRequests()
                    .antMatchers(new String[]{"/", "/not-restricted"}).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2Login();
        }
    }

}
