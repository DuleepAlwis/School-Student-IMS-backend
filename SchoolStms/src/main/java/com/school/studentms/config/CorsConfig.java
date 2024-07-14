package com.school.studentms.config;

import com.school.studentms.constants.RestEndPoints;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:8080"); // Replace with your frontend URL
        config.addAllowedHeader("*");
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        //source.registerCorsConfiguration(contextPath+RestEndPoints.AUTH_EP+"/**", config);
        //source.registerCorsConfiguration(contextPath+RestEndPoints.ORGANIZATION_EP+RestEndPoints.ORGANIZATION_CREATE, config);
        return new CorsFilter(source);
    }
}
