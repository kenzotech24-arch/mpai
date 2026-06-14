package com.exam.clinica.loader;

import com.exam.clinica.model.Medic;
import com.exam.clinica.model.Programare;
import com.exam.clinica.model.StatusProgramare;
import com.exam.clinica.service.MedicService;
import com.exam.clinica.service.ProgramareService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Scanner;

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
        File fisierMedici = new File("src/main/resources/data/medici.txt");
        Scanner scanner = new Scanner(fisierMedici);
        while (scanner.hasNextLine()) {
            String linie = scanner.nextLine();
            if (linie.isBlank()) continue;
            String[] parts = linie.split(";");
            medicService.salveaza(new Medic(parts[0].trim(), parts[1].trim()));
        }
        scanner.close();

        File fisierProgramari = new File("src/main/resources/data/programari.txt");
        Scanner scanner2 = new Scanner(fisierProgramari);
        while (scanner2.hasNextLine()) {
            String linie = scanner2.nextLine();
            if (linie.isBlank()) continue;
            String[] parts = linie.split(";");
            Medic m = medicService.findById(Long.parseLong(parts[2].trim()));
            Programare p = new Programare(parts[0].trim(), parts[1].trim(), m,
                    LocalDateTime.parse(parts[3].trim()), parts[4].trim(), StatusProgramare.valueOf(parts[5].trim()));
            programareService.salveaza(p);
        }
        scanner2.close();
    }
}
