package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.controller;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto.ContactForm;
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
        // email moet nog verstuurt worden
        return "redirect:/";
    }
}
