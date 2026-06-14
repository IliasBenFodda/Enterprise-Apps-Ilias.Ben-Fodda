package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.controller;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto.ContactForm;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.EmailModel;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping
    public String sendContact(@Valid @ModelAttribute("contactForm") ContactForm contactForm,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        EmailModel email = new EmailModel();
        email.setFrom(contactForm.getEmail());
        email.setTo("ngo@anderlecht.be");
        email.setSubject(contactForm.getOnderwerp());
        email.setBody("Van: " + contactForm.getNaam() + "\n\n" + contactForm.getBericht());

        emailService.sendEmail(email);

        return "redirect:/";
    }
}
