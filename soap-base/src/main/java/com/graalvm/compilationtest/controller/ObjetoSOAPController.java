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
import javax.xml.stream.XMLStreamException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;

@Endpoint
public class ObjetoSOAPController {

    private static final String NAMESPACE = "http://example.com/Objetos";

    private final ObjetoService service;

    public ObjetoSOAPController(ObjetoService service) {
        this.service = service;
    }

    /* Este metodo es para recibir data en XML, transformar esa data a un objeto java, 
    hacer una peticion get asincrona y devolver el objeto de nuevo como xml */
    @PayloadRoot(namespace = NAMESPACE, localPart = "GetObjetoByIdRequest")
    @ResponsePayload
    public Source getObjeto(@RequestPayload Source requestPayload) throws Exception {

        Objeto request = parse(requestPayload);
        Objeto objeto = service.readById(request.getId()).block();
        return getObjetoResponse(objeto);
    }

    // metodos de parseo manual - law is to avoid reflection at all costs
    private Source getObjetoResponse(Objeto objeto) {

        StringWriter writer = new StringWriter();

        writer.append("<obj:GetObjetoByIdResponse xmlns:obj=\"http://example.com/Objetos\">");

        writer.append("<obj:id>")
            .append(String.valueOf(objeto.getId()))
            .append("</obj:id>");

        writer.append("<obj:nombre>")
            .append(objeto.getNombre())
            .append("</obj:nombre>");

        writer.append("</obj:GetObjetoByIdResponse>");

        return new StreamSource(new java.io.StringReader(writer.toString()));
    }

    private Objeto parse(Source source) throws Exception {

    // Normalize any Source type (DOMSource, SAXSource, etc.) into a StreamSource
    StringWriter writer = new StringWriter();
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(source, new StreamResult(writer));

    Source streamSource = new StreamSource(new StringReader(writer.toString()));

    XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLStreamReader reader = factory.createXMLStreamReader(streamSource);

    Objeto request = new Objeto();

    while (reader.hasNext()) {
        int event = reader.next();

        if (event == XMLStreamConstants.START_ELEMENT) {
            String tag = reader.getLocalName();

            switch (tag) {
                case "id":
                    request.setId(Long.parseLong(reader.getElementText()));
                    break;
                case "nombre":
                    request.setNombre(reader.getElementText());
                    break;
                default:
                    break;
            }
        }
    }

    return request;
    }

}