package com.company.springapp.server;

import com.company.springapp.config.AppConfig;
import com.company.springapp.config.DatabaseConfig;
import com.company.springapp.config.SecurityConfig;
import com.company.springapp.config.WebConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

public class WebInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        rootContext.register(DatabaseConfig.class);
        rootContext.register(SecurityConfig.class);
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
        container.addListener(contextLoaderListener);

        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.register(WebConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletContext);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);

        FilterRegistration.Dynamic securityFilter = container.addFilter(
                AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME,
                DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }

}