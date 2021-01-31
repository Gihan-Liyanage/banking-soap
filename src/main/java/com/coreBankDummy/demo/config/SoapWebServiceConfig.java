package com.coreBankDummy.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/account/*");
    }


    @Bean
    public XsdSchema accountSchema() {
        return new SimpleXsdSchema(new ClassPathResource("accounts.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema accountsSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(accountsSchema);
        definition.setLocationUri("/account");
        definition.setPortTypeName("AccountServicePort");
        definition.setTargetNamespace("http://www.trebeyainterview.com/spring-boot-soap");
        return definition;
    }

    @Bean(name = "total")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema accountsSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(accountsSchema);
        definition.setLocationUri("/account");
        definition.setPortTypeName("AccountServicePort");
        definition.setTargetNamespace("http://www.trebeyainterview.com/spring-boot-soap");
        return definition;
    }

    @Bean(name = "transfer")
    public DefaultWsdl11Definition defaultWsdl11Definition3(XsdSchema accountsSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(accountsSchema);
        definition.setLocationUri("/account");
        definition.setPortTypeName("AccountServicePort");
        definition.setTargetNamespace("http://www.trebeyainterview.com/spring-boot-soap");
        return definition;
    }

    @Bean(name = "interAccount")
    public DefaultWsdl11Definition defaultWsdl11Definition4(XsdSchema accountsSchema) {

        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(accountsSchema);
        definition.setLocationUri("/account");
        definition.setPortTypeName("AccountServicePort");
        definition.setTargetNamespace("http://www.trebeyainterview.com/spring-boot-soap");
        return definition;
    }


}
