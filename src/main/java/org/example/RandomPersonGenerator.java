package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Klasa generująca listę losowych obiektów Person.
public class RandomPersonGenerator {

    // Metoda generująca listę losowych obiektów Person.
    public static List<Person> generateRandomPersons(int count) {
        List<Person> persons = new ArrayList<>(); // Lista do przechowywania osób
        Random random = new Random(); // Obiekt Random do generowania losowych wartości

        for (int i = 0; i < count; i++) {
            // Generowanie losowych wartości dla każdego pola
            int intField = random.nextInt(100); // Liczba całkowita z zakresu 0-99
            String stringField = "Name" + i;    // Unikalna nazwa na podstawie indeksu
            float floatField = random.nextFloat() * 100; // Liczba zmiennoprzecinkowa 0-100
            boolean booleanField = random.nextBoolean(); // Losowa wartość true/false

            // Dodanie nowego obiektu Person do listy
            persons.add(new Person(intField, stringField, floatField, booleanField));
        }

        return persons; // Zwracanie listy losowych osób
    }
}