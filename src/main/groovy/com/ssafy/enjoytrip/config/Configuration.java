package com.ssafy.enjoytrip.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@org.springframework.context.annotation.Configuration
@MapperScan(basePackages = "com.ssafy.enjoytrip.*.model.mapper")
public class Configuration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").maxAge(1800);
    }
}