package com.everlasting.config

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder
import com.everlasting.config.properties.DruidProperties
import com.everlasting.datasource.DynamicDataSource
import com.everlasting.enums.DataSourceType
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

import javax.sql.DataSource
import java.util.HashMap

/**
 * druid 配置多数据源
 *
 * @author ruoyi
 */
@Configuration
class DruidConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    fun masterDataSource(druidProperties: DruidProperties): DataSource {
        val dataSource = DruidDataSourceBuilder.create().build()
        return druidProperties.dataSource(dataSource)
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = ["enabled"], havingValue = "true")
    fun slaveDataSource(druidProperties: DruidProperties): DataSource {
        val dataSource = DruidDataSourceBuilder.create().build()
        return druidProperties.dataSource(dataSource)
    }

    @Bean(name = ["dynamicDataSource"])
    @Primary
    fun dataSource(masterDataSource: DataSource, slaveDataSource: DataSource): DynamicDataSource {
        val targetDataSources = HashMap<Any, Any>()
        targetDataSources[DataSourceType.MASTER.name] = masterDataSource
        targetDataSources[DataSourceType.SLAVE.name] = slaveDataSource
        return DynamicDataSource(masterDataSource, targetDataSources)
    }
}
