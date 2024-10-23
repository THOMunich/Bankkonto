import java.io.*;
import java.util.ArrayList;

public class Bank implements Serializable{
    //Arraylist mit 4 Konten anlegen
    private ArrayList<Bankkonto> kontoliste;

    // Konstruktor der Bank-Klasse
    public Bank() {
        kontoliste = new ArrayList<>();  // ArrayList initialisieren
        kontoliste.add(new Bankkonto(1001, 1000, "Thomas", 1001));  // Konto hinzufügen
        kontoliste.add(new Bankkonto(1002, 2000, "Alice", 1002));
        kontoliste.add(new Bankkonto(1003, 3000, "Bob", 1003));
        kontoliste.add(new Bankkonto(1004, 4000, "Charlie", 1004));
    }
}
