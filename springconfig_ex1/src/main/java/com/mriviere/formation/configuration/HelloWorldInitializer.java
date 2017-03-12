package com.mriviere.formation.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class HelloWorldInitializer /*implements WebApplicationInitializer*/ {

//    public void onStartup(ServletContext container) throws ServletException {
//
//        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//
//        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(appContext));
//
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//    }

}