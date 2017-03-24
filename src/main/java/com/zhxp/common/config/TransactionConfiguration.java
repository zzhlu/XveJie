package com.zhxp.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by tanghong on 2017/2/21.
 */
@Configuration
public class TransactionConfiguration implements TransactionManagementConfigurer {

    @Resource(name = "transactionManager")
    PlatformTransactionManager transactionManager;

    @Bean(name ="transactionManager")
    public PlatformTransactionManager getManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager;
    }
}