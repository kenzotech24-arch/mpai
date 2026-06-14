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

import java.time.LocalDate;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(new ClassPathResource("data/echipamente.txt").getInputStream());
        while (scanner.hasNextLine()) {
            String linie = scanner.nextLine();
            if (linie.isBlank()) continue;
            String[] parts = linie.split(";");
            echipamentService.salveazaModel(new Echipament(parts[0].trim(), parts[1].trim(), Boolean.parseBoolean(parts[2].trim())));
        }
        scanner.close();

        Scanner scanner2 = new Scanner(new ClassPathResource("data/inchirieri.txt").getInputStream());
        while (scanner2.hasNextLine()) {
            String linie = scanner2.nextLine();
            if (linie.isBlank()) continue;
            String[] parts = linie.split(";");
            Echipament e = echipamentService.findById(Long.parseLong(parts[2].trim()));
            Inchiriere i = new Inchiriere(parts[0].trim(), parts[1].trim(), e,
                    LocalDate.parse(parts[3].trim()), LocalDate.parse(parts[4].trim()),
                    parts[5].trim(), StatusInchiriere.valueOf(parts[6].trim()));
            inchiriereService.salveaza(i);
        }
        scanner2.close();
    }
}
