import java.io.Serializable;
public class Bankkonto implements Serializable{

    //Instanzvariablen
    private double kontostand;
    private String name;
    private int pin;
    private int kontonr;

    //Klassenkonstante (gibt es nur einmal im Programm)
    public static final int DISPO = 500;

    //Klassenvariablen (static) (gibts nur einmal im Programm)
    private static double zins = 0.1;

    //Konstruktoren
    public Bankkonto(int kontonr, double kontostand, String name, int pin) {
        this.kontostand = kontostand;
        this.name = name;
        this.pin = pin;
        this.kontonr = kontonr;
    }
    public Bankkonto() {
        this(1000, 0, "Max Mustermann", 1234);
    }
    //Instanzmethoden (Objektmethoden), arbeiten mit Instanzvariablen
    public void abheben(double betrag, int pin) {
        if (pinCheck(pin)) {
            if (betrag > kontostand + DISPO || betrag < 0) {
                System.out.println("Abhebung nicht möglich");
            } else {
                kontostand = kontostand - betrag;
                System.out.println("Neuer Kontostand: " + kontostand);
            }
        } else {
            System.out.println("Pin Falsch, bitte richtige PIN eingeben.");
        }
    }
    public void einzahlen(double betrag) {
        if (betrag < 0) {
            System.out.println("Einzahlung NULL nicht möglich");
            return; // Ausstieg aus der Methode
        }
        kontostand += betrag;
        System.out.println();
    }
    //Klassenmethode (kein Zugriff auf Instanzvariablen)
    public static double zinsGewinnBerechnung(double betrag, int laufzeit) {
        //lokale Variable (nur innerhalb der Methode sichtbar)
        double gewinn = betrag;
        for (int i = 0; i < laufzeit; i++) {
            gewinn = gewinn + gewinn * zins;
        }
        return gewinn;
        //System.out.println("Ihr Gesamtbetrag beläuft sich auf " + gewinn);
    }

    //private Objektmethode, soll nach aussen nicht sichbar sein
    private boolean pinCheck(int pin) {
        if (pin == this.pin) {
            return true;
        } else {
            return false;
        }
    }
    // Getter und Setter Methoden, Zugriff auf Instanzvariablen (Getter = lesend, Setter = schreibend)
    public String getName() {
        return name;
    }
    public int getDispo() {
        return DISPO;
    }
    public double getKontostand() {
        return kontostand;
    }
}