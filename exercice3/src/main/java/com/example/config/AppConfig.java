package com.example.config;

import com.example.aspects.LogMethodAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by rivie on 11/04/2017.
 */
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public LogMethodAspect logMethodAspect() {
        return new LogMethodAspect();
    }

}
