package com.exam.clinica.loader;

import com.exam.clinica.model.Medic;
import com.exam.clinica.model.Programare;
import com.exam.clinica.model.StatusProgramare;
import com.exam.clinica.service.MedicService;
import com.exam.clinica.service.ProgramareService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    private final MedicService medicService;
    private final ProgramareService programareService;

    public DataLoader(MedicService medicService, ProgramareService programareService) {
        this.medicService = medicService;
        this.programareService = programareService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ClassPathResource("data/medici.txt").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split(";");
                medicService.salveaza(new Medic(p[0].trim(), p[1].trim()));
            }
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ClassPathResource("data/programari.txt").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split(";");
                Medic m = medicService.findById(Long.parseLong(p[2].trim()));
                Programare prog = new Programare(p[0].trim(), p[1].trim(), m,
                        LocalDateTime.parse(p[3].trim()), p[4].trim(), StatusProgramare.valueOf(p[5].trim()));
                programareService.salveaza(prog);
            }
        }
    }
}
