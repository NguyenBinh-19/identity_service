package com.nguyenbinh.identity_service.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Đường dẫn cho phép
                .allowedOrigins("http://localhost:3000") // Thay đổi thành nguồn mà bạn muốn cho phép
                .allowedMethods("*") // Các phương thức cho phép
                .allowedHeaders("*") // Các header cho phép
                .allowCredentials(true); // Cho phép gửi cookie
    }
}

