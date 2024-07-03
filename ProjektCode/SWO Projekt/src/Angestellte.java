import java.time.LocalDate;

public class Angestellte extends Mitarbeiter {
    private double stundenLohn;
    private double ueberstundenLohn;
    private double stundenAnzahl;
    private double ueberstundenAnzahl;

    public Angestellte(char geschlecht, String vorname, String nachname, String adresse, LocalDate geburtsdatum,
                       LocalDate eintrittsdatum, double stundenLohn, double ueberstundenLohn, double stundenAnzahl,
                       double ueberstundenAnzahl) throws Exception {
        super(nachname, vorname, adresse, geburtsdatum, eintrittsdatum, geschlecht, null, null);
        try {
            setStundenLohn(stundenLohn);
            setUeberstundenLohn(ueberstundenLohn);
            setStundenAnzahl(stundenAnzahl);
            setUeberstundenAnzahl(ueberstundenAnzahl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(double stundenLohn) throws Exception {
        if (stundenLohn <= 0) {
            throw new Exception("Der Stundenlohn muss größer als 0 sein.");
        }
        this.stundenLohn = stundenLohn;
    }

    public double getUeberstundenLohn() {
        return ueberstundenLohn;
    }

    public void setUeberstundenLohn(double ueberstundenLohn) throws Exception {
        if (ueberstundenLohn <= stundenLohn) {
            throw new Exception("Der Überstundenlohn muss höher sein als der Reguläre Lohn.");
        }
        this.ueberstundenLohn = ueberstundenLohn;
    }

    public double getStundenAnzahl() {
        return stundenAnzahl;
    }

    public void setStundenAnzahl(double stundenAnzahl) throws Exception {
        if (stundenAnzahl <= 0) {
            throw new Exception("Die Stundenanzahl darf nicht 0 sein.");
        }
        this.stundenAnzahl = stundenAnzahl;
    }

    public double getUeberstundenAnzahl() {
        return ueberstundenAnzahl;
    }

    public void setUeberstundenAnzahl(double ueberstundenAnzahl) throws Exception {
        if (ueberstundenAnzahl < 0) {
            throw new Exception("Die Anzahl an Überstunden darf nicht negativ sein.");
        }
        this.ueberstundenAnzahl = ueberstundenAnzahl;
    }

    public void lohnErhoehen() {
        stundenLohn += stundenLohn * 1.5;           //Beispiel Werte
        ueberstundenLohn += ueberstundenLohn * 2;
    }

    @Override
    public double GehaltBerechnen() {
        return (stundenLohn * stundenAnzahl) + (ueberstundenLohn * ueberstundenAnzahl);
    }
}
