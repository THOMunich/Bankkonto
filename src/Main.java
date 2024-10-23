import java.io.*;

public class Main {
    public static void main(String[] args) {
        // via class Schnittstelle alle Methoden implementiert
        Schnittstelle neueSchnittstelle = new Schnittstelle();
        neueSchnittstelle.go();
    }
}

// Bankkonto erstellt mit Methoden, Schnittstelle erstellt welche auf Bankkonto Methoden zugreift uand ausführt,
// dann diese in der Main aufrufen
// 3. die Kontenbewegungen via Serializable in einem Textfile speichern (implementieren der Technik)