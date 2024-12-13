package org.example;

// Klasa reprezentująca osobę z polami różnych typów.
public class Person {
    private int intField;          // Pole typu int
    private String stringField;    // Pole typu String
    private float floatField;      // Pole typu float
    private boolean booleanField;  // Pole typu boolean

    // Konstruktor klasy Person
    public Person(int intField, String stringField, float floatField, boolean booleanField) {
        this.intField = intField;
        this.stringField = stringField;
        this.floatField = floatField;
        this.booleanField = booleanField;
    }

    // Gettery dla pól
    public int getIntField() {
        return intField;
    }

    public String getStringField() {
        return stringField;
    }

    public float getFloatField() {
        return floatField;
    }

    public boolean isBooleanField() {
        return booleanField;
    }

    // Przekształcenie obiektu Person na tekst w formacie CSV
    @Override
    public String toString() {
        return intField + "," + stringField + "," + floatField + "," + booleanField;
    }
}