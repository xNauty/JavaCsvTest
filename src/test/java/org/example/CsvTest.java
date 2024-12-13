package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Klasa testowa do sprawdzania plików CSV.
public class CsvTest {

    @Test
    public void testCsvWithRandomPersons() throws IOException {
        // Generowanie listy losowych osób
        int numberOfPersons = 10;
        List<Person> persons = RandomPersonGenerator.generateRandomPersons(numberOfPersons);
        String filePath = "src/main/resources/person.csv";

        // Zapis danych do pliku CSV
        CsvFileHandler.saveToCsv(persons, filePath);
        System.out.println("Plik CSV zapisany z " + numberOfPersons + " wierszami.");

        // Weryfikacja pliku
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Asercja 1: Sprawdzenie, czy plik nie jest pusty
            assertNotNull(reader.readLine(), "Plik jest pusty.");
            System.out.println("Asercja 1: Plik nie jest pusty - OK");

            // Asercja 2: Sprawdzenie liczby linii
            int linesCount = 1; // Pierwsza linia już przeczytana
            while (reader.readLine() != null) {
                linesCount++;
            }
            assertEquals(numberOfPersons, linesCount, "Liczba wierszy w pliku nie zgadza się.");
            System.out.println("Asercja 2: Liczba wierszy w pliku zgadza się - OK");
        }

        // Asercja 3: Walidacja typów danych
        boolean isValid = CsvValidator.validateCsv(filePath, persons);
        assertTrue(isValid, "CSV validation failed.");
        System.out.println("Asercja 3: Wszystkie pola mają prawidłowe typy - OK");
    }
}