package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.controller;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto.EvenementForm;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.Locatie;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.service.EvenementService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new")
public class EvenementController {

    private final EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping
    public String showNewPage(Model model) {
        model.addAttribute("evenementForm", new EvenementForm());
        model.addAttribute("locatie", new Locatie());
        model.addAttribute("locaties", evenementService.getAllLocaties());
        return "new";
    }

    @PostMapping("/evenement")
    public String saveEvenement(@Valid @ModelAttribute("evenementForm") EvenementForm evenementForm,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("locatie", new Locatie());
            model.addAttribute("locaties", evenementService.getAllLocaties());
            return "new";
        }
        evenementService.saveEvenement(evenementForm);
        return "redirect:/";
    }

    @PostMapping("/locatie")
    public String saveLocatie(@Valid @ModelAttribute("locatie") Locatie locatie,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("evenementForm", new EvenementForm());
            model.addAttribute("locaties", evenementService.getAllLocaties());
            return "new";
        }
        evenementService.saveLocatie(locatie);
        return "redirect:/new";
    }
}
