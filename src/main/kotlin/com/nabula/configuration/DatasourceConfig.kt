package com.nabula.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
open class DatasourceConfig {
    var username: String = ""
    var password: String = ""
    var url: String = ""
    var driverClassName: String = ""

    @Bean
    open fun primaryDataSource(): DataSource {
        val hc = HikariConfig()
        hc.jdbcUrl = url
        hc.username = username
        hc.password = password
        hc.setDriverClassName(driverClassName)

        val ds = HikariDataSource(hc)
        return ds
    }

}