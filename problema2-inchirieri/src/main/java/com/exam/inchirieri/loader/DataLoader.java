package com.exam.inchirieri.loader;

import com.exam.inchirieri.model.Echipament;
import com.exam.inchirieri.model.Inchiriere;
import com.exam.inchirieri.model.StatusInchiriere;
import com.exam.inchirieri.service.EchipamentService;
import com.exam.inchirieri.service.InchiriereService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private final EchipamentService echipamentService;
    private final InchiriereService inchiriereService;

    public DataLoader(EchipamentService echipamentService, InchiriereService inchiriereService) {
        this.echipamentService = echipamentService;
        this.inchiriereService = inchiriereService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ClassPathResource("data/echipamente.txt").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split(";");
                echipamentService.salveazaModel(new Echipament(p[0].trim(), p[1].trim(), Boolean.parseBoolean(p[2].trim())));
            }
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new ClassPathResource("data/inchirieri.txt").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split(";");
                Echipament e = echipamentService.findById(Long.parseLong(p[2].trim()));
                Inchiriere i = new Inchiriere(p[0].trim(), p[1].trim(), e,
                        LocalDate.parse(p[3].trim()), LocalDate.parse(p[4].trim()),
                        p[5].trim(), StatusInchiriere.valueOf(p[6].trim()));
                inchiriereService.salveaza(i);
            }
        }
    }
}
