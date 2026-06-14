package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.controller;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.EmailModel;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public String sendSimpleMail(@ModelAttribute EmailModel email) {
        String result;
        if (email.getAttachment() == null) {
            result = emailService.sendEmail(email);
        } else {
            result = emailService.sendEmailWithAttachment(email);
        }
        return result;
    }
}
