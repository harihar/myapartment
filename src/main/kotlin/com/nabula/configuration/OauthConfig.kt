package com.nabula.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import javax.sql.DataSource

/**
 * Created by harihar on 21/07/16.
 */
@Configuration
open class OauthConfig {
    @Configuration
    @EnableResourceServer
    open protected class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

        override
        @Throws(Exception::class)
        fun configure(resources: ResourceServerSecurityConfigurer) {
            resources.resourceId("apartment").stateless(false)
        }

        override
        @Throws(Exception::class)
        fun configure(http: HttpSecurity) {
            http
                    .authorizeRequests()
                    .antMatchers("/secure").access("#oauth2.hasScope('trust')")
        }

    }

    @Configuration
    @EnableAuthorizationServer
    open protected class AuthorizationServerConfiguration : AuthorizationServerConfigurerAdapter() {

        @Autowired
        @Qualifier("authenticationManagerBean")
        lateinit var authenticationManager: AuthenticationManager
        @Autowired
        @Qualifier("primaryDataSource")
        lateinit var dataSource: DataSource

        override
        @Throws(Exception::class)
        fun configure(security: AuthorizationServerSecurityConfigurer) {
            security.realm("apartment")
        }

        override
        @Throws(Exception::class)
        fun configure(clients: ClientDetailsServiceConfigurer) {
            clients.jdbc(dataSource)
        }

        override
        @Throws(Exception::class)
        fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
            endpoints.tokenStore(JdbcTokenStore(dataSource)).authenticationManager(authenticationManager)
        }

    }
}