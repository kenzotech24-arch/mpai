package com.exam.magazin.controller;

import com.exam.magazin.dto.ComandaDTO;
import com.exam.magazin.model.StatusComanda;
import com.exam.magazin.service.ComandaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ComandaController {

    private final ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/client")
    public String clientPage(@RequestParam(required = false) String email, Model model) {
        if (email != null && !email.isBlank()) {
            model.addAttribute("comenzi", comandaService.getByEmail(email));
            model.addAttribute("notificari", comandaService.getNotificari(email));
            model.addAttribute("email", email);
        }
        model.addAttribute("comanda", new ComandaDTO());
        return "client/comenzi";
    }

    @PostMapping("/client/adauga")
    public String adauga(@ModelAttribute ComandaDTO dto, RedirectAttributes ra) {
        comandaService.adauga(dto);
        ra.addFlashAttribute("mesaj", "Comanda a fost plasata cu succes!");
        return "redirect:/client?email=" + dto.getClientEmail();
    }

    @PostMapping("/client/anuleaza/{id}")
    public String anuleaza(@PathVariable Long id, @RequestParam String email, RedirectAttributes ra) {
        comandaService.anuleaza(id);
        ra.addFlashAttribute("mesaj", "Comanda a fost anulata.");
        return "redirect:/client?email=" + email;
    }

    @GetMapping("/admin/comenzi")
    public String adminComenzi(@RequestParam(required = false) String email,
                               @RequestParam(required = false) String status,
                               Model model) {
        model.addAttribute("comenzi", comandaService.filter(email, status));
        model.addAttribute("statusuri", StatusComanda.values());
        model.addAttribute("filterEmail", email);
        model.addAttribute("filterStatus", status);
        return "admin/comenzi";
    }

    @PostMapping("/admin/status/{id}")
    public String schimbaStatus(@PathVariable Long id, @RequestParam String status, RedirectAttributes ra) {
        comandaService.schimbaStatus(id, StatusComanda.valueOf(status));
        ra.addFlashAttribute("mesaj", "Status actualizat cu succes!");
        return "redirect:/admin/comenzi";
    }
}
