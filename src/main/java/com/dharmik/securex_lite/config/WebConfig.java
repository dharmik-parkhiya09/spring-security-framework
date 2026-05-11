package com.dharmik.securex_lite.config;


import com.dharmik.securex_lite.service.SecureInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final SecureInterceptor secureInterceptor;

    public void addInterceptors(
            InterceptorRegistry registry
    ) {

        registry.addInterceptor(secureInterceptor);
    }
}
