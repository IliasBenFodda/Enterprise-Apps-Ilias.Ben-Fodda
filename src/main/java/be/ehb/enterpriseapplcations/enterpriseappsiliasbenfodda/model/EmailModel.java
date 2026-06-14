package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model;

import org.springframework.web.multipart.MultipartFile;

public class EmailModel {
    private String from;
    private String to;
    private String subject;
    private String body;
    private MultipartFile attachment;

    public EmailModel(String from, String to, String subject, String body, MultipartFile attachment) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public EmailModel() {
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }
}
