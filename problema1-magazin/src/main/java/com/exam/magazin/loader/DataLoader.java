package com.exam.magazin.loader;

import com.exam.magazin.model.Comanda;
import com.exam.magazin.model.StatusComanda;
import com.exam.magazin.service.ComandaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class DataLoader implements ApplicationRunner {

    private final ComandaService comandaService;

    public DataLoader(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File fisier = new File("src/main/resources/data/comenzi.txt");
        Scanner scanner = new Scanner(fisier);

        while (scanner.hasNextLine()) {
            String linie = scanner.nextLine();
            if (linie.isBlank()) continue;

            String[] parts = linie.split(";");
            Comanda c = new Comanda(
                    parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim(),
                    LocalDate.parse(parts[3].trim()),
                    StatusComanda.valueOf(parts[4].trim()),
                    Double.parseDouble(parts[5].trim())
            );
            comandaService.salveazaComanda(c);
        }

        scanner.close();
    }
}
