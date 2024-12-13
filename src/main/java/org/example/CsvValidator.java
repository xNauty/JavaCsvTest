package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvValidator {
    public static boolean validateCsv(String filePath, Person person) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                return false; // Plik jest pusty
            }
            if (reader.readLine() != null) {
                return false; // Więcej niż jedna linia
            }
            return line.equals(person.toString()); // Sprawdzenie zawartości
        }
    }
}