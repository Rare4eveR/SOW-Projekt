import java.time.LocalDate;

public class Mitarbeiter {
    private int geburtsjahr;
    private char geschlecht;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private int laufNummer;
    private String adresse;
    private String mitArbeiterArt;
    private LocalDate eintrittsdatum;
    private LocalDate austrittsdatum;
    private LocalDate letzteErhoehung;
    private LocalDate letztePraemie;

    public Mitarbeiter(String _nachname, String _vorname, String mitArbeiterArt, String _adresse, LocalDate _geburtsdatum, LocalDate _eintrittsdatum, LocalDate _letzteErhoehung, LocalDate _letztePraemie) {
        vorname = _vorname;
        nachname = _nachname;
        adresse = _adresse;
        geburtsdatum = _geburtsdatum;
        eintrittsdatum = _eintrittsdatum;}


    public void setGeburtsjahr(int _geburtsjahr) {
        geburtsjahr = _geburtsjahr;

    }
    public void setGeschlecht(char _geschlecht) {
        geschlecht = _geschlecht;

    }

    public void setVorname(String _vorname) {
        vorname = _vorname;

    }

    public void setNachname(String _nachname) {
        nachname = _nachname;

    }

    public void setGeburtsdatum(LocalDate _geburtsdatum) {
        geburtsdatum = _geburtsdatum;
    }

    public void setEintrittsdatum(LocalDate _eintrittsdatum) {
        eintrittsdatum = _eintrittsdatum;

    }

    public void setAustrittsdatum(LocalDate _austrittsdatum) {
        austrittsdatum = _austrittsdatum;

    }

    public void setAdresse(String _adresse) {
        adresse = _adresse;

    }

    public void setMitArbeiterArt(String _mitArbeiterArt) {
        mitArbeiterArt = _mitArbeiterArt;

    }

    public int getGeburtsjahr() {
        return geburtsjahr;

    }

    public char getGeschlecht() {
        return geschlecht;

    }
    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;

    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;

    }

    public LocalDate getEintrittsdatum() {
        return eintrittsdatum;

    }

    public LocalDate getAustrittsdatum() {

        return austrittsdatum;

    }

    public String getAdresse() {
        return adresse;

    }

    public String getMitArbeiterArt() {
        return mitArbeiterArt;

    }


}