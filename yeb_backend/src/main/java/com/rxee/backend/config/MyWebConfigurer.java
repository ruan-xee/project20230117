package com.rxee.backend.config;

import com.rxee.backend.filter.CorsInterceptor;
import com.rxee.backend.utils.SnowFlake;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {
    //跨域全局配置
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8080")
//                .allowCredentials(true) //允许跨域使用cookie
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .allowedHeaders("*")
//                .maxAge(1800L); //两个小时
//    }

    @Resource
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //放到最上面
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
    }

    @Bean
    public SnowFlake snowFlake() {
        SnowFlake snowFlake = new SnowFlake(1, 1);
        return snowFlake;
    }
}
