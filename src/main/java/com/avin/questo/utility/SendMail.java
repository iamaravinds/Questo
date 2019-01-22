package com.avin.questo.utility;


import com.avin.questo.service.QuestoServiceImpl;
import com.sendgrid.*;
import org.slf4j.LoggerFactory;


import java.io.IOException;

public class SendMail {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SendMail.class);
    public Boolean sendMyMail(String email ) throws IOException {
        logger.info("Into Send mail");
        Boolean result=false;
        Email from = new Email("test@example.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email(email);
        Content content = new Content("text/plain", "Congratulations on registring.. You are only ONE step away");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("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"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            result=true;
        } catch (IOException ex) {
            throw ex;
        }
        return result;
    }
}