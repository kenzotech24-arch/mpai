package com.exam.magazin.loader;

import com.exam.magazin.model.Comanda;
import com.exam.magazin.model.StatusComanda;
import com.exam.magazin.service.ComandaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private final ComandaService comandaService;

    public DataLoader(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathResource resource = new ClassPathResource("data/comenzi.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";");
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
        }
    }
}
