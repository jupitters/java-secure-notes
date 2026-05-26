package com.jupitters.secure_notes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests ->
                requests.anyRequest().permitAll());
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        if (!manager.userExists("user1")){
            manager.createUser(
                    User.withUsername("user1")
                            .password("{noop}password")
                            .roles("USER")
                            .build()
            );
        }
        if (!manager.userExists("admin")){
            manager.createUser(
                    User.withUsername("admin")
                            .password("{noop}password")
                            .roles("ADMIN")
                            .build()
            );
        }
        return manager;
    }
}
