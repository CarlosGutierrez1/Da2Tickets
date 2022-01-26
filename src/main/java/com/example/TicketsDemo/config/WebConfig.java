package com.example.TicketsDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
//import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

public class WebConfig implements WebMvcConfigurer {
//    @Bean
//    public SpringSecurityDialect securityDialect() {
//        return new SpringSecurityDialect();
//    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
