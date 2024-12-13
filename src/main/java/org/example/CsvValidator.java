package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// Klasa do walidacji plików CSV.
public class CsvValidator {

    // Metoda weryfikująca zawartość pliku CSV na podstawie listy obiektów Person.
    public static boolean validateCsv(String filePath, List<Person> expectedPersons) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                if (index >= expectedPersons.size()) {
                    return false; // Więcej linii w pliku niż w danych
                }

                // Porównanie linii pliku z oczekiwanym obiektem Person
                String[] fields = line.split(",");
                Person expected = expectedPersons.get(index);

                // Sprawdzenie każdego pola pod względem typu
                if (!fields[0].matches("\\d+")) return false; // Pole int
                if (!fields[1].equals(expected.getStringField())) return false; // Pole String
                if (!fields[2].matches("\\d+\\.\\d+")) return false; // Pole float
                if (!fields[3].matches("true|false")) return false; // Pole boolean

                index++;
            }

            // Sprawdzenie, czy liczba linii w pliku zgadza się z liczbą obiektów Person
            return index == expectedPersons.size();
        }
    }
}