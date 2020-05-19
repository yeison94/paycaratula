package com.api.paycaratula.Service;

import com.api.paycaratula.domain.viafirma.*;
import com.api.paycaratula.implementation.ViafirmaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.print.Doc;

@Service
public class ViafirmaService {

    String url = "https://sandbox.viafirma.com/documents/api/v3/messages/";

    public Mono<Response> firmaweb(String base64, String email){

        Body body = new Body();
        Workflow workflow = new Workflow();
        Notification notification = new Notification();
        SharedLink sharedLink = new SharedLink();
        Document document = new Document();

        body.setGroupCode("sura");
        workflow.setType("WEB");
        notification.setText("Caratula");
        notification.setDetail("Hola<br><br>Porfa firma");

        sharedLink.setAppCode("com.viafirma.documents");
        sharedLink.setEmail(email);
        sharedLink.setSubject("Caratula Seguro");
        notification.setSharedLink(sharedLink);
        body.setNotification(notification);

        document.setTemplateType("base64");
        document.setTemplateReference(base64);
        document.setPolicyCode("Caratula");
        document.setReadRequired(true);
        document.setWatermarkText("Preview");

        body.setDocument(document);
        body.setCallbackURL(null);
        body.setCallbackMails(null);

        body.setWorkflow(workflow);

        return new ViafirmaClient().creardocumento(url,body);

    }

}
