package com.company.springapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.company.springapp.service"})
@PropertySource("classpath:application.properties")
public class AppConfig {

}
