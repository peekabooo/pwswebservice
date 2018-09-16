package com.pws.pwswebservice.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.pws.pwswebservice.mapper")
@EnableTransactionManagement
public class PersistenceConfig {

}