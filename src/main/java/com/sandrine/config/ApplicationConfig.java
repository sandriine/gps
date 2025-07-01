package com.sandrine.config;

import com.sandrine.domain.application.CheckDistanceBetweenCoordinate;
import com.sandrine.domain.application.CreateCoordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

        @Bean
        public CreateCoordinate createCoordinate(CoordinateRepository repo) {
            return new CreateCoordinate(repo);
        }

        @Bean
        public CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate() {
            return new CheckDistanceBetweenCoordinate();
        }
    }
