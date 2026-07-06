package com.dharmik.securex_lite.config;


import com.dharmik.securex_lite.service.CurrentUserResolver;
import com.dharmik.securex_lite.service.SecureInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final SecureInterceptor secureInterceptor;
    private final CurrentUserResolver currentUserResolver;

    public void addInterceptors(
            InterceptorRegistry registry
    ) {

        registry.addInterceptor(secureInterceptor);
    }

    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver>
                    resolvers
    ) {

        resolvers.add(currentUserResolver);
    }
}
