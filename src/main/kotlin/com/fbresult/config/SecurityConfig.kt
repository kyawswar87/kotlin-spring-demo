package org.example.com.fbresult.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
@EnableWebFluxSecurity
class SecurityConfig() {

    @Bean
    fun filterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .authorizeExchange { it.pathMatchers("/public/**").permitAll() }
            .authorizeExchange { it.anyExchange().authenticated() }
            .httpBasic {  }
            .build()
    }

    @Bean
    fun userDetailsService(): MapReactiveUserDetailsService {
        val user = User
            .withUsername("user")
            .password("{noop}password")
            .roles("USER")
            .build()
        return MapReactiveUserDetailsService(user)
    }

}
