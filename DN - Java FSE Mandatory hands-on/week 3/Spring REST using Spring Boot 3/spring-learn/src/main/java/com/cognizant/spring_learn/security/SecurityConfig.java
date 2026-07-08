package com.cognizant.spring_learn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Robust structural security configuration manager initializing component rules for Spring Security.
 * Implements modern non-deprecated component bean declarations suited for advanced Spring Boot 3 deployments.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    /**
     * Declares the global encoding algorithm bean used to safely encipher raw context string passwords.
     *
     * @return Encoder component leveraging modern BCrypt hashing mechanics.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("START - Initializing application password encoder component context");
        return new BCryptPasswordEncoder();
    }

    /**
     * Initializes the administrative and standard user credential records in an in-memory manager.
     * Removed the redundant throws clause as the initialization routine handles execution safely.
     *
     * @param encoder Active cryptographic password encoding component.
     * @return Configuration instance containing the seeded user accounts.
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        LOGGER.info("START - Designing in-memory mock testing profile data registries");

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("pwd"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("pwd"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    /**
     * Exposes the AuthenticationManager bean from the global configuration context.
     * The redundant throws clause has been removed to align with static analysis requirements.
     *
     * @param configuration The application's authentication configuration pipeline.
     * @return The initialized AuthenticationManager instance.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }

    /**
     * Configures the SecurityFilterChain routing restrictions and hooks in the custom JWT filter.
     * The redundant throws clause has been removed to ensure compliance with code quality standards.
     *
     * @param http The HttpSecurity configuration builder utility.
     * @param manager The active AuthenticationManager instance.
     * @return The built SecurityFilterChain instance regulating application access.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager manager) {
        LOGGER.info("START - Formulating custom Security Filter Chain configuration rules");

        http.csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilter(new JwtAuthorizationFilter(manager));

        return http.build();
    }
}
