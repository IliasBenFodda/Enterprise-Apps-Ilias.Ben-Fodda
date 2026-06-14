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

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }
}
