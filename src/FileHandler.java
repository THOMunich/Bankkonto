import java.io.*;

public class FileHandler {
    // Methode zum Speichern eines Objekts in einer Datei
    public static void saveObjectToFile(Bankkonto konto, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(konto);
            os.close();
        } catch (Exception ex) {
            System.out.println("Fehler beim Speichern!");
        }
    }

    // Methode zum Laden eines Objekts aus einer Datei
    public static Bankkonto loadObjectFromFile(String filename) {
        Object one = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            one = objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("Fehler beim Laden des Objekts!");
            e.printStackTrace();
        }
        return (Bankkonto) one;
    }
}
