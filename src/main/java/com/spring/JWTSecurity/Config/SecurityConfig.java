package com.spring.JWTSecurity.Config;

import com.spring.JWTSecurity.Security.JwtAuthinticationEntryPoint;
import com.spring.JWTSecurity.Security.JwtAuthinticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthinticationEntryPoint point;

    @Autowired
    private JwtAuthinticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(csrf -> csrf.disable())
                    .cors(cors-> cors.disable() )
                    .authorizeHttpRequests(
                            auth -> auth.requestMatchers("/home/**").authenticated()
                                    .requestMatchers("/auth/login")
                                    .permitAll().anyRequest().authenticated())
                                     .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                                      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }


}
