package com.exam.clinica.controller;

import com.exam.clinica.dto.ProgramareDTO;
import com.exam.clinica.model.StatusProgramare;
import com.exam.clinica.service.MedicService;
import com.exam.clinica.service.ProgramareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProgramareController {

    private final ProgramareService programareService;
    private final MedicService medicService;

    public ProgramareController(ProgramareService programareService, MedicService medicService) {
        this.programareService = programareService;
        this.medicService = medicService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/pacient")
    public String pacientPage(@RequestParam(required = false) String email, Model model) {
        if (email != null && !email.isBlank()) {
            model.addAttribute("programari", programareService.getByEmail(email));
            model.addAttribute("notificari", programareService.getNotificari(email));
            model.addAttribute("email", email);
        }
        model.addAttribute("medici", medicService.getAll());
        model.addAttribute("programare", new ProgramareDTO());
        return "pacient/programari";
    }

    @PostMapping("/pacient/adauga")
    public String adauga(@ModelAttribute ProgramareDTO dto, RedirectAttributes ra) {
        programareService.adauga(dto);
        ra.addFlashAttribute("mesaj", "Programarea a fost solicitata cu succes!");
        return "redirect:/pacient?email=" + dto.getPacientEmail();
    }

    @PostMapping("/pacient/anuleaza/{id}")
    public String anuleaza(@PathVariable Long id, @RequestParam String email, RedirectAttributes ra) {
        programareService.anuleaza(id);
        ra.addFlashAttribute("mesaj", "Programarea a fost anulata.");
        return "redirect:/pacient?email=" + email;
    }

    @GetMapping("/admin/programari")
    public String adminProgramari(@RequestParam(required = false) String email,
                                  @RequestParam(required = false) String status,
                                  @RequestParam(required = false) String medic,
                                  Model model) {
        model.addAttribute("programari", programareService.filter(email, status, medic));
        model.addAttribute("statusuri", StatusProgramare.values());
        model.addAttribute("filterEmail", email);
        model.addAttribute("filterStatus", status);
        model.addAttribute("filterMedic", medic);
        return "admin/programari";
    }

    @PostMapping("/admin/status/{id}")
    public String schimbaStatus(@PathVariable Long id, @RequestParam String status, RedirectAttributes ra) {
        programareService.schimbaStatus(id, StatusProgramare.valueOf(status));
        ra.addFlashAttribute("mesaj", "Status actualizat!");
        return "redirect:/admin/programari";
    }
}
