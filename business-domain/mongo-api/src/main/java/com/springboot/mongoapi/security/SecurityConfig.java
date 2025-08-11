package com.springboot.mongoapi.security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                // Permite el acceso a TODOS los endpoints de Actuator sin autenticación
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                // .requestMatchers("/actuator/**").permitAll()
                // .requestMatchers("/actuator/**").authenticated()
                // Para el resto de peticiones, exige que el usuario esté autenticado
                .anyRequest().authenticated())
                // Puedes configurar otras cosas como el formulario de login, etc.
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
