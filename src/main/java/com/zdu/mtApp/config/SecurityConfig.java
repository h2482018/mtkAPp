package com.zdu.mtApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.AbstractJaasAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("*/test/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()//<1>
                .and()
                .logout().permitAll();
    }
    // @formatter:on
    
    // @formatter:off
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
        
        
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");//<2>
    }
    // @formatter:on
}