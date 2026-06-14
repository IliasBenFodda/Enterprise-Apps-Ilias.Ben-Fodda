package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.services;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.EmailModel;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServicelmpl implements EmailService {
    private JavaMailSender mailSender;

    public EmailServicelmpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public String sendEmail(EmailModel emailDetails) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailDetails.getFrom());
            message.setTo(emailDetails.getTo());
            message.setSubject(emailDetails.getSubject());
            message.setText(emailDetails.getBody());
            mailSender.send(message);
            return "Email succesvol gestuurd";
        } catch (Exception e) {
            return "Email niet gestuurd probeer opnieuw" + e.getMessage();
        }
    }

    @Override
    public String sendEmailWithAttachment(EmailModel emailDetails) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailDetails.getFrom());
            helper.setTo(emailDetails.getTo());
            helper.setSubject(emailDetails.getSubject());
            helper.setText(emailDetails.getBody(), true);
            helper.addAttachment(emailDetails.getAttachment().getOriginalFilename(), emailDetails.getAttachment());
            mailSender.send(message);
            return "Email succesvol gestuurd";
        } catch (Exception e) {
            return "Email niet gestuurd probeer opnieuw" + e.getMessage();
        }
    }
}
