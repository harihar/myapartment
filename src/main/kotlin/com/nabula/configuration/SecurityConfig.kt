package com.nabula.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.AuthenticationEntryPoint
import javax.servlet.http.HttpServletResponse

/**
 * Created by harihar on 20/07/16.
 */
@Configuration
open class SecurityConfig : WebSecurityConfigurerAdapter() {

//    @Autowired
//    @Throws(Exception::class)
//    fun globalUserDetails(auth: AuthenticationManagerBuilder) {
//        auth.inMemoryAuthentication()
//                .withUser("hari").password("pass123").roles("USER")
//                .and()
//                .withUser("dhunu").password("puku").roles("USER")
//    }

    override
    @Bean(name = arrayOf("authenticationManagerBean"))
    @Throws(Exception::class)
    fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    override
    @Throws(Exception::class)
    fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/open/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint())
    }

    @Autowired
    lateinit private var userDetailsService: DatabaseUserDetailsService

    @Bean
    open fun unauthorizedEntryPoint(): AuthenticationEntryPoint {
        return AuthenticationEntryPoint { request, response, authException -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED) }
    }

    override
    @Autowired
    @Throws(Exception::class)
    fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)//.passwordEncoder(passwordEncoder)
    }

}
