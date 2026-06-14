package com.exam.inchirieri.controller;

import com.exam.inchirieri.dto.InchiriereDTO;
import com.exam.inchirieri.model.StatusInchiriere;
import com.exam.inchirieri.service.EchipamentService;
import com.exam.inchirieri.service.InchiriereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InchiriereController {

    private final InchiriereService inchiriereService;
    private final EchipamentService echipamentService;

    public InchiriereController(InchiriereService inchiriereService, EchipamentService echipamentService) {
        this.inchiriereService = inchiriereService;
        this.echipamentService = echipamentService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/user")
    public String userPage(@RequestParam(required = false) String email, Model model) {
        if (email != null && !email.isBlank()) {
            model.addAttribute("inchirieri", inchiriereService.getByEmail(email));
            model.addAttribute("notificari", inchiriereService.getNotificari(email));
            model.addAttribute("email", email);
        }
        model.addAttribute("echipamente", echipamentService.getDisponibile());
        model.addAttribute("cerere", new InchiriereDTO());
        return "user/inchirieri";
    }

    @PostMapping("/user/adauga")
    public String adaugaCerere(@ModelAttribute InchiriereDTO dto, RedirectAttributes ra) {
        inchiriereService.adaugaCerere(dto);
        ra.addFlashAttribute("mesaj", "Cererea de inchiriere a fost trimisa!");
        return "redirect:/user?email=" + dto.getUtilizatorEmail();
    }

    @PostMapping("/user/anuleaza/{id}")
    public String anuleaza(@PathVariable Long id, @RequestParam String email, RedirectAttributes ra) {
        inchiriereService.anuleaza(id);
        ra.addFlashAttribute("mesaj", "Cererea a fost anulata.");
        return "redirect:/user?email=" + email;
    }

    @GetMapping("/admin/inchirieri")
    public String adminInchirieri(@RequestParam(required = false) String email,
                                  @RequestParam(required = false) String status,
                                  @RequestParam(required = false) String echipament,
                                  Model model) {
        model.addAttribute("inchirieri", inchiriereService.filter(email, status, echipament));
        model.addAttribute("statusuri", StatusInchiriere.values());
        model.addAttribute("filterEmail", email);
        model.addAttribute("filterStatus", status);
        model.addAttribute("filterEchipament", echipament);
        return "admin/inchirieri";
    }

    @GetMapping("/admin/echipamente")
    public String adminEchipamente(Model model) {
        model.addAttribute("echipamente", echipamentService.getAll());
        model.addAttribute("echipament", new com.exam.inchirieri.dto.EchipamentDTO());
        return "admin/echipamente";
    }

    @PostMapping("/admin/echipamente/adauga")
    public String adaugaEchipament(@ModelAttribute com.exam.inchirieri.dto.EchipamentDTO dto, RedirectAttributes ra) {
        echipamentService.salveaza(dto);
        ra.addFlashAttribute("mesaj", "Echipament adaugat!");
        return "redirect:/admin/echipamente";
    }

    @PostMapping("/admin/status/{id}")
    public String schimbaStatus(@PathVariable Long id, @RequestParam String status, RedirectAttributes ra) {
        inchiriereService.schimbaStatus(id, StatusInchiriere.valueOf(status));
        ra.addFlashAttribute("mesaj", "Status actualizat!");
        return "redirect:/admin/inchirieri";
    }
}
