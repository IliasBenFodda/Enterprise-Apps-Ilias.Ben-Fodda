package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.controller;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.service.EvenementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final EvenementService evenementService;

    public HomeController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("evenementen", evenementService.getRecenteEvenementen());
        return "index";
    }

    @GetMapping("/evenementen/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("evenement", evenementService.getEvenementDetail(id));
        return "details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
