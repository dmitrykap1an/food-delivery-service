package com.example.foodservice.domain.config

import com.example.domain.jwt.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher


@Configuration
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain{
        return httpSecurity
            .csrf {
                it.disable()
            }
            .cors {
                it.disable()
            }
            .httpBasic{
                it.disable()
            }
            .authorizeHttpRequests {
                it.requestMatchers(antMatcher(HttpMethod.POST, "/api/v1/cart"))
                it.anyRequest().permitAll()
            }
            .sessionManagement{
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .addFilterAfter(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }
}