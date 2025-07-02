package com.sandrine.config;

import com.sandrine.domain.application.CheckDistanceBetweenCoordinate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

        @Bean
        public CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate() {
            return new CheckDistanceBetweenCoordinate();
        }
    }
