package com.company.springapp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.company.springapp")
@PropertySource("classpath:persistence-postgresql.properties")
public class WebApplicationConfig implements WebMvcConfigurer {

    private Environment env;

    public WebApplicationConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        dataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize"));
        dataSource.setMinPoolSize(
                getIntProperty("connection.pool.maxPoolSize"));
        dataSource.setMinPoolSize(
                getIntProperty("connection.pool.maxIdleTime"));

        return dataSource;
    }

    private int getIntProperty(String propertyName) {
        String property = env.getProperty(propertyName);
        return Integer.parseInt(property);
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql",
                env.getProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

}
