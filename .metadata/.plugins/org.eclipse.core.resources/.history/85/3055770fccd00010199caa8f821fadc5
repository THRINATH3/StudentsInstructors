package com.example.studentCourses.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.studentCourses.security.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // PUBLIC ENDPOINTS (NO JWT REQUIRED)
                .requestMatchers(
                    "/students/loginStudent",
                    "/students/registerStudent",
                    "/instructors/loginInstructor",
                    "/instructors/registerInstructor",
                    "/courses/public/**"
                ).permitAll()

                // PROTECTED ENDPOINTS (JWT REQUIRED)
                .requestMatchers("/students/**").authenticated()
                .requestMatchers("/instructors/**").authenticated()
                .requestMatchers("/courses/**").authenticated()

                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
