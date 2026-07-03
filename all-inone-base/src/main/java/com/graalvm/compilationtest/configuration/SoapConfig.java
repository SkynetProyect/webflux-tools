package com.graalvm.compilationtest.configuration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@EnableWs
@Configuration
public class SoapConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext context) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "objetos")
    public DefaultWsdl11Definition wsdl(XsdSchema schema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("ObjetosPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://example.com/Objetos");
        wsdl.setSchema(schema);
        return wsdl;
    }
    
    @Bean
    public XsdSchema objetosSchema() {
        return new SimpleXsdSchema(new ClassPathResource("objetos.xsd"));
    }

}