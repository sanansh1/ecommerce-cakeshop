package org.ecommerce.sandhya.application.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {


    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        security.csrf().disable().cors().disable();
        security.authorizeHttpRequests().anyRequest().permitAll();
        return security.build();

    }
}
