package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Klasa do obsługi plików CSV.
public class CsvFileHandler {

    // Metoda zapisująca listę obiektów Person do pliku CSV.
    public static void saveToCsv(List<Person> persons, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person person : persons) {
                writer.write(person.toString()); // Zapisanie linii z danymi osoby
                writer.newLine(); // Przejście do nowej linii
                writer.flush(); // Wymuszenie zapisu każdej linii
            }
        }
    }
}