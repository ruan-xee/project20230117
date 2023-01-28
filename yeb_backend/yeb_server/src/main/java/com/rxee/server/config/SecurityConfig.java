package com.rxee.server.config;

import com.rxee.server.handle.MyAuthenticationFailureHandler;
import com.rxee.server.handle.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //当发现是/login时认为是登录，必须和表单提交的地址一样，去执行UserDetailsServiceImpl
                .loginProcessingUrl("/login")
                //自定义登录页面
                .loginPage("/login.html")
                //登录成功后跳转页面，Post请求
                //.successForwardUrl("/toMain")
                //登录成功后处理器，不能和successForwardUrl共存
                .successHandler(new MyAuthenticationSuccessHandler("/main.html"))
                //.failureForwardUrl("/toError");
                //登录失败后处理器，不能和failureForwardUrl共存
                .failureHandler(new MyAuthenticationFailureHandler("/error.html"));
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
                //.antMatchers("/**/*.png").permitAll()
                //.regexMatchers(".+[.]png").permitAll()
                //.regexMatchers(HttpMethod.POST, "/demo").permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }
}
