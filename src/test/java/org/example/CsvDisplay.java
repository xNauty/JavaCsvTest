package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Klasa do wyświetlania zawartości pliku CSV w konsoli.
public class CsvDisplay {

    // Metoda do odczytu i wyświetlania zawartości pliku CSV.
    public static void displayCsv(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Zawartość pliku CSV:");
            String line;
            int lineNumber = 1;

            // Odczytanie każdej linii i wypisanie jej w konsoli
            while ((line = reader.readLine()) != null) {
                System.out.printf("Linia %d: %s%n", lineNumber++, line);
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
        }
    }

    // Metoda główna do przetestowania wyświetlania pliku CSV.
    public static void main(String[] args) {
        String filePath = "src/main/resources/person.csv"; // Ścieżka do pliku CSV
        displayCsv(filePath);
    }
}