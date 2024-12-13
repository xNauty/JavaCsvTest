package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvTest {
    @Test
    public void testCsvOperations() throws IOException {
        // Tworzenie obiektu Person
        Person person = new Person("Jan", "Kowalski", 30);
        String filePath = "src/main/resources/person.csv";

        // Zapis danych do pliku CSV
        CsvFileHandler.saveToCsv(person, filePath);
        System.out.println("Plik CSV został zapisany.");

        // Otwórz plik i sprawdź jego zawartość
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine();

            // 1. Sprawdzenie czy plik nie jest pusty
            assertNotNull(firstLine, "Plik jest pusty.");
            System.out.println("Asercja 1: Plik nie jest pusty - OK");

            // 2. Sprawdzenie czy plik zawiera dokładnie jedną linię
            String secondLine = reader.readLine();
            assertNull(secondLine, "Plik zawiera więcej niż jedną linię.");
            System.out.println("Asercja 2: Plik zawiera dokładnie jedną linię - OK");

            // 3. Sprawdzenie zawartości linii
            assertEquals(person.toString(), firstLine, "Zawartość pliku nie zgadza się z oczekiwaną.");
            System.out.println("Asercja 3: Zawartość pliku jest poprawna - OK");
        }

        // Walidacja za pomocą klasy CsvValidator
        boolean isValid = CsvValidator.validateCsv(filePath, person);
        assertTrue(isValid, "CSV file validation failed.");
        System.out.println("Walidacja pliku CSV zakończona sukcesem.");
    }
}
