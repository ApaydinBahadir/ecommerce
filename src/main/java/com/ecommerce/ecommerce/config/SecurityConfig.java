package com.ecommerce.ecommerce.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ecommerce.ecommerce.dataAccess.abstracts.UserDao;
import com.ecommerce.ecommerce.security.JwtAuthenticationEntryPoint;
import com.ecommerce.ecommerce.security.JwtAuthenticationFilter;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private UserDao userDao;
	private JwtAuthenticationEntryPoint handler;

	public SecurityConfig(UserDao userDao,JwtAuthenticationEntryPoint  handler) {
		this.userDao = userDao;
		this.handler = handler;
	}

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilterCreate() {
    	return new JwtAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity
    		.cors()
    		.and()
    		.csrf()
    		.and()
    		.exceptionHandling().authenticationEntryPoint(handler).and()
    		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
    		.authorizeHttpRequests()
    		.requestMatchers("/auth/**").permitAll()
    		.requestMatchers("/api/**").hasAnyRole("normalUser","Admin")
    		.anyRequest().authenticated();
    		
    	httpSecurity.addFilterBefore(jwtAuthenticationFilterCreate(), (Class<? extends Filter>) UsernamePasswordAuthenticationFilter.class);
    	return httpSecurity.build();
    }
}
