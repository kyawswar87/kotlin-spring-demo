package org.example.com.fbresult.config

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.naming.AuthenticationException


@Configuration
@EnableWebSecurity
class SecurityConfig(private val authenticationEntryPoint: MyBasicAuthenticationEntryPoint
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csr -> csr.disable() }
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/public/**").permitAll()  // permit all access to /public
                    .anyRequest().authenticated()
            }
            .httpBasic {
                it.authenticationEntryPoint(authenticationEntryPoint)
            }
        return http.build()
    }

    @Bean
    fun users(): UserDetailsService {
        val user = User.builder()
            .username("user")
            .password("{noop}user")
            .roles("USER")
            .build()
        val admin = User.builder()
            .username("admin")
            .password("{noop}admin")
            .roles("USER", "ADMIN")
            .build()
        return InMemoryUserDetailsManager(user, admin)
    }

}

@Component
class MyBasicAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
) : BasicAuthenticationEntryPoint() {
    fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authEx: AuthenticationException
    ) {
        response.addHeader("WWW-Authenticate", "Basic realm=$realmName")
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        response.contentType = "application/json;charset=UTF-8"
        val errorDetails: Map<String, String> = mapOf(
            "error" to "Authentication Failed",
            "message" to (authEx.message ?: "Unauthorized")
        )
        response.writer.println(objectMapper.writeValueAsString(errorDetails))
    }

    override fun afterPropertiesSet() {
        realmName = "Hyperskill"
        super.afterPropertiesSet()
    }
}