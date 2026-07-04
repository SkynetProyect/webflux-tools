package com.graalvm.compilationtest.client;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import jakarta.annotation.PostConstruct;
import com.graalvm.compilationtest.model.objeto.Objeto;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;

@Component
public class ObjetoSOAPClient {

    private static final String NAMESPACE = "http://example.com/Objetos"; // placeholder — swap for real target namespace

    private final WebServiceTemplate webServiceTemplate;

    public ObjetoSOAPClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public Objeto getObjetoById(Long id) throws Exception {

        Source requestSource = buildRequest(id);
        StreamResult result = new StreamResult(new StringWriter());

        webServiceTemplate.sendSourceAndReceiveToResult(requestSource, result);

        return parseResponse(result.getWriter().toString());
    }

    private Source buildRequest(Long id) {
    
        String xml = "<obj:GetObjetoByIdRequest xmlns:obj=\"" + NAMESPACE + "\">"
                    + "<obj:id>" + id + "</obj:id>"
                    + "</obj:GetObjetoByIdRequest>";
        return new StreamSource(new StringReader(xml));
    }

    private Objeto parseResponse(String xml) throws Exception {
   
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(xml));

        Objeto objeto = new Objeto();

        while (reader.hasNext()) {
            int event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT) {
                String tag = reader.getLocalName();

                switch (tag) {
                    case "id":
                        objeto.setId(Long.parseLong(reader.getElementText()));
                        break;
                    case "nombre":
                        objeto.setNombre(reader.getElementText());
                        break;
                    default:
                        break;
                }
            }
        }

        return objeto;
    }

    
}