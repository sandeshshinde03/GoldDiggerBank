package com.BWA.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;


import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.BWA.Services.CustomerUserDetailService;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomerUserDetailService cservice;

    // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // Authentication Provider
    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(cservice);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    // Authentication Manager (Correct for Spring Boot 4)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Security Filter Chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/gotologin","/visitRForm","/addUser").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/gotologin")
                    .loginProcessingUrl("/login")
                    .successHandler(authenticationSuccessHandler())
                    .permitAll()
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(logoutSuccessHandler())
                    .permitAll()
            );

        return http.build();
    }

    // Role Based Login Redirect
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {

        return (request, response, authentication) -> {

            String role = authentication.getAuthorities().stream()
                    .map(auth -> auth.getAuthority())
                    .findFirst()
                    .orElse("");

            if ("ROLE_ADMIN".equals(role)) {
                response.sendRedirect("/adminpanel");
            } else {
                response.sendRedirect("/userpanel");
            }
        };
    }

    // Logout Handler
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {

        return (request, response, authentication) -> {
            response.sendRedirect("/gotologin");
        };
    }
}