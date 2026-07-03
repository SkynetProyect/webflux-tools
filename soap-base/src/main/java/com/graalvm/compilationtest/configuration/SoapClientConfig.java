
package com.graalvm.compilationtest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Configuration
public class SoapClientConfig {

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.afterPropertiesSet(); // required manual init since we're not using Spring's factory-bean lifecycle here

        WebServiceTemplate template = new WebServiceTemplate(messageFactory);
        template.setDefaultUri("http://localhost:8080/ws"); // swap once you have the real endpoint
        return template;
    }
}