package com.graalvm.compilationtest.controller;

import com.graalvm.compilationtest.service.objeto.ObjetoService;

import org.springframework.ws.server.endpoint.annotation.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import com.graalvm.compilationtest.model.objeto.Objeto;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.core.io.ClassPathResource;

@Endpoint
public class ObjetoSOAPController {

    private static final String NAMESPACE = "http://example.com/Objetos";

    private final ObjetoService service;

    public ObjetoSOAPController(ObjetoService service) {
        this.service = service;
    }

    /* Este metodo es para recibir data en XML, transformar esa data a un objeto java, 
    hacer una peticion get asincrona y devolver el objeto de nuevo como xml */
    @PayloadRoot(namespace = NAMESPACE, localPart = "GetObjetoById")
    @ResponsePayload
    public Source getObjeto(@RequestPayload Source requestPayload) { 
        Objeto request = parse(requestPayload);
        Objeto objeto = service.readById(request.getId()).block();
        return getObjetoResponse(objeto);
    }


    // metodos de parseo manual - law is to avoid reflection at all costs
    private Source getObjetoResponse(Objeto objeto) {

        StringWriter writer = new StringWriter();

        writer.append("<obj:Objeto xmlns:obj=\"http://example.com/Objetos\">");

        writer.append("<obj:id>")
            .append(String.valueOf(objeto.getId()))
            .append("</obj:id>");

        writer.append("<obj:name>")
            .append(objeto.getNombre())
            .append("</obj:name>");

        writer.append("</obj:Objeto>");

        return new StreamSource(new java.io.StringReader(writer.toString()));
    }

    
    private Objeto parse(Source source) throws Exception {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(source);

        Objeto request = new Objeto();

        while (reader.hasNext()) {
            int event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT) {

                String tag = reader.getLocalName();

                switch (tag) {

                    case "id":
                        request.setId(Long.parseLong(reader.getElementText()));
                        break;

                    case "name":
                        request.setNombre(reader.getElementText());
                        break;

                    default:
                        // ignore unknown tags
                        break;
                }
            }
        }

        return request;
    }

}