package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Jan", "Kowalski", 30);
            String filePath = "person.csv";

            // Zapisz do CSV
            CsvFileHandler.saveToCsv(person, filePath);

            // Sprawdź poprawność
            if (CsvValidator.validateCsv(filePath, person)) {
                System.out.println("Plik CSV został poprawnie zapisany i zweryfikowany!");
            } else {
                System.out.println("Błąd weryfikacji pliku CSV.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
