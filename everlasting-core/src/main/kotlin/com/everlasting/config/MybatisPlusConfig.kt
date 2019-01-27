package com.everlasting.config

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Mybatis plus配置文件
 */
@Configuration
@MapperScan("com.everlasting.mapper*")
class MybatisPlusConfig {
    /**
     * mybatis-plus分页插件<br></br>
     * 文档：http://mp.baomidou.com<br></br>
     */
    @Override
    @Bean
    fun paginationInterceptor(): PaginationInterceptor {
        //        paginationInterceptor.setOptimizeType(Optimize.JSQLPARSER.getOptimize());
        return paginationInterceptor()
    }
}