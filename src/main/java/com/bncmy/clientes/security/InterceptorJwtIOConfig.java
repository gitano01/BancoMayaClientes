package com.bncmy.clientes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorJwtIOConfig implements WebMvcConfigurer {

    @Value("${jms.jwt.security.enabled:false}")
    private boolean securityEnabled;

    @Autowired
    private InterceptorJwtIO interceptorJwtIO;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (securityEnabled) {
            registry.addInterceptor(interceptorJwtIO)
                    .addPathPatterns("/api/**") // Aplica a todas las rutas
                    .excludePathPatterns("/v2/api-docs", "/swagger-ui.html"); // Excluye las rutas de Swagger
        }
    }
}
