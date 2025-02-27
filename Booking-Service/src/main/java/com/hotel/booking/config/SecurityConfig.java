//package com.hotel.booking.config;
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//        .csrf().disable().authorizeHttpRequests(authorize->authorize.anyRequest().permitAll());
////            .csrf().disable() // Disable CSRF if not needed
////            .authorizeRequests()
////                .requestMatchers("/public/**").permitAll() // Public endpoints
////                .anyRequest().authenticated() // All other endpoints require authentication
////            .and()
////            .formLogin().disable(); // Disable form-based login if not needed
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
