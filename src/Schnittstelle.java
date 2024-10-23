import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Schnittstelle {
    private Bankkonto konto;

    public Bankkonto getKonto(){
        return konto;
    }
    // Laden des gespeicherten Kontos
    private void loadAccount() {
        konto = FileHandler.loadObjectFromFile("BankFileDaten");
        if (konto != null) {
            System.out.println("\nGespeichertes Konto geladen.");
            System.out.println("Ihr Kontostand: " + konto.getKontostand() + " EUR");
        } else {
            System.out.println("Kein gespeichertes Konto gefunden, bitte ein neues Konto erstellen.");
        }
    }
    // Speichern des Kontos
    private void saveAccount() {
        FileHandler.saveObjectToFile(konto, "BankFileDaten");
        System.out.println("Kontodaten gespeichert.");
        System.out.println("Auf Wiedersehen!");
    }
    public void newAccountSchnittstelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie Ihren Namen ein: ");
        String name = scanner.nextLine();
        System.out.println("Bitte legen Sie Ihre PIN fest: ");
        int pin = scanner.nextInt();
        System.out.println("Bitte legen Sie Ihre Kontonummer fest: ");
        int kontonr = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Bitte geben Sie Ihren Betrag ein: ");
        double kontostand = scanner.nextDouble();
        scanner.nextLine();
        //double kontostand;

        konto = new Bankkonto(kontonr, kontostand, name, pin);
        System.out.println("Ein neues Konto wurde erstellt: ");
        System.out.println("Name: " +name + " | Kontostand: " + kontostand + " | Dispo: " + konto.getDispo());
    }
    public void abhebenSchnittstelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie die PIN ein: ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Bitte geben Sie den Betrag ein, den Sie abheben möchten: ");
        double betrag = scanner.nextInt();
        scanner.nextLine();
        konto.abheben(betrag, pin);
        System.out.println("Neuer Kontostand: " +konto.getKontostand()+" EUR.");
    }
    public void einzahlenSchnittstelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie den Betrag ein, den Sie EINZAHLEN möchten: ");
        int betrag = scanner.nextInt();
        scanner.nextLine();
        // Auf die einzahlen-Methode von Bankkonto zugreifen
        konto.einzahlen(betrag);
        System.out.println("Neuer Kontostand: " + konto.getKontostand());
    }
    public void kontostandSchnittstelle() {
        System.out.println(konto.getKontostand());
    }
    private void menuAnzeigen(){
        System.out.println("Bitte wählen Sie: \n");
        System.out.println("(1) Konto eröffnen ");
        System.out.println("(2) Barauszahlung");
        System.out.println("(3) Bareinzahlung");
        System.out.println("(4) Kontostand anzeigen");
    }
    private boolean beendenAuswahl() {
        boolean isWeitermachen = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Möchten Sie fortfahren? (J/N)");
        String entscheidung = scanner.nextLine();
        if (entscheidung.equalsIgnoreCase("N")){
            return false;
        } else {
            return true;
        }
    }
    public void go() {
        loadAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHerzlich Willkommen!");
        boolean isWeitermachen = true;

        while (isWeitermachen) {
            menuAnzeigen();
            String eingabe = scanner.nextLine();
            if (eingabe.equals("1")) {
                newAccountSchnittstelle();
            } else if (eingabe.equals("2")) {
                abhebenSchnittstelle();
            } else if (eingabe.equals("3")) {
                einzahlenSchnittstelle();
            } else if (eingabe.equals("4")) {
                kontostandSchnittstelle();
            } else {
                System.out.println("Falsche Eingabe, bitte gültige Eingabe machen!");
                continue;
            }
            isWeitermachen = beendenAuswahl();
        }
        saveAccount();
    }
}
