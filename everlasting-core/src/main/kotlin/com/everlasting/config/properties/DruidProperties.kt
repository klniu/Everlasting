package com.everlasting.config.properties

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

/**
 * druid 配置属性
 *
 */
@Configuration
class DruidProperties {
    @Value("\${spring.datasource.druid.initialSize}")
    private val initialSize: Int = 0

    @Value("\${spring.datasource.druid.minIdle}")
    private val minIdle: Int = 0

    @Value("\${spring.datasource.druid.maxActive}")
    private val maxActive: Int = 0

    @Value("\${spring.datasource.druid.maxWait}")
    private val maxWait: Int = 0

    @Value("\${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private val timeBetweenEvictionRunsMillis: Int = 0

    @Value("\${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private val minEvictableIdleTimeMillis: Int = 0

    @Value("\${spring.datasource.druid.maxEvictableIdleTimeMillis}")
    private val maxEvictableIdleTimeMillis: Int = 0

    @Value("\${spring.datasource.druid.validationQuery}")
    private val validationQuery: String? = null

    @Value("\${spring.datasource.druid.testWhileIdle}")
    private val testWhileIdle: Boolean = false

    @Value("\${spring.datasource.druid.testOnBorrow}")
    private val testOnBorrow: Boolean = false

    @Value("\${spring.datasource.druid.testOnReturn}")
    private val testOnReturn: Boolean = false

    fun dataSource(datasource: DruidDataSource): DruidDataSource {
        /** 配置初始化大小、最小、最大  */
        datasource.initialSize = initialSize
        datasource.maxActive = maxActive
        datasource.minIdle = minIdle

        /** 配置获取连接等待超时的时间  */
        datasource.maxWait = maxWait.toLong()

        /** 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒  */
        datasource.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis.toLong()

        /** 配置一个连接在池中最小、最大生存的时间，单位是毫秒  */
        datasource.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis.toLong()
        datasource.maxEvictableIdleTimeMillis = maxEvictableIdleTimeMillis.toLong()

        /**
         * 用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
         */
        datasource.validationQuery = validationQuery
        /** 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。  */
        datasource.isTestWhileIdle = testWhileIdle
        /** 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。  */
        datasource.isTestOnBorrow = testOnBorrow
        /** 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。  */
        datasource.isTestOnReturn = testOnReturn
        return datasource
    }
}
