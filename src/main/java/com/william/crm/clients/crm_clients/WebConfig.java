package com.william.crm.clients.crm_clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//esta es una de las 3 maneras de configurar cors, esta es la opción más usada

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //interceptor
    @Autowired
    @Qualifier("loggerInterceptor")
    private HandlerInterceptor loggerInterceptor;
    //

    @SuppressWarnings("null")
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
            .allowedOrigins("http://127.0.0.1:5501")    //.allowedOrigins("*") // Permite cualquier IP
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }

    @SuppressWarnings("null")
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/clients");
    }
}
