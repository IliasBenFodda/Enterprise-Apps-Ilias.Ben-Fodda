package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.services;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.EmailModel;

public interface EmailService {
    String sendEmail(EmailModel emailDetails);

    String sendEmailWithAttachment(EmailModel emailDetails);
}
