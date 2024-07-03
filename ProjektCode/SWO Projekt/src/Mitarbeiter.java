import java.time.LocalDate;

/**
 * @version 1.0
 * @author Devran Sakar, Arkadius Skatulla
 */
public abstract class Mitarbeiter {
    private String vorname;
    private String nachname;
    private String adresse;
    private char geschlecht;
    private LocalDate geburtsdatum;
    private LocalDate eintrittsdatum;
    private LocalDate austrittsdatum;
    private LocalDate letzteErhoehung;
    private LocalDate letztePraemie;

    /**
     *
     * @param nachname Nachname der Person
     * @param vorname Vorname der Person
     * @param adresse Adresse der Person
     * @param geburtsdatum Geburtsdatum der Person
     * @param eintrittsdatum Eintrittsdatum der Person
     * @param geschlecht Geschlecht der Person
     * @param letzteErhoehung letzte Gehaltserhöhung
     * @param letztePraemie letzte Premie
     * @throws Exception
     *      */

    public Mitarbeiter(String nachname, String vorname, String adresse, LocalDate geburtsdatum,
                       LocalDate eintrittsdatum, char geschlecht, LocalDate letzteErhoehung, LocalDate letztePraemie) {
        try {
            setGeschlecht(geschlecht);
            setNachname(nachname);
            setVorname(vorname);
            setAdresse(adresse);
            setGeburtsjahr(geburtsdatum);
            setEintrittsdatum(eintrittsdatum);
            setLetzteErhoehung(letzteErhoehung);
            setLetztePraemie(letztePraemie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        generateLaufnummer();
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) throws Exception {
        if (nachname.isBlank()) {
            throw new Exception("Der Nachname ist leer.");
        }
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) throws Exception {
        if (vorname.isBlank()) {
            throw new Exception("Der Vorname ist leer.");
        }
        this.vorname = vorname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) throws Exception {
        if (adresse.isBlank()) {
            throw new Exception("Die Adresse ist leer.");
        }
        this.adresse = adresse;
    }

    public LocalDate getGeburtsjahr() {
        return geburtsdatum;
    }

    public void setGeburtsjahr(LocalDate geburtsjahr) throws Exception {
        if (geburtsjahr == null) {
            throw new Exception("Geburtsjahr ist leer.");
        } else if (geburtsjahr.getYear() > LocalDate.now().getYear() - 13) {
            throw new Exception("Mitarbeiter ist zu jung.");
        }
        this.geburtsdatum = geburtsdatum;
    }

    public LocalDate getEintrittsdatum() {
        return eintrittsdatum;
    }

    public void setEintrittsdatum(LocalDate eintrittsdatum) throws Exception {
        if (eintrittsdatum == null) {
            throw new Exception("Eintrittsdatum ist leer.");
        }
        this.eintrittsdatum = eintrittsdatum;
    }

    public LocalDate getAustrittsdatum() {
        return austrittsdatum;
    }

    public void setAustrittsdatum(LocalDate austrittsdatum) throws Exception {
        if (austrittsdatum == null) {
            throw new Exception("Austrittsdatum ist leer.");
        }
        this.austrittsdatum = austrittsdatum;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(char geschlecht) throws Exception {
        if (geschlecht != 'w' && geschlecht != 'm' && geschlecht != 'd') {
            throw new Exception("Geschlecht ist nicht zugelassen.");
        }
        this.geschlecht = geschlecht;
    }

    public LocalDate getLetzteErhoehung() {
        return letzteErhoehung;
    }

    public void setLetzteErhoehung(LocalDate letzteErhoehung) throws Exception {
        if (letzteErhoehung == null) {
            throw new Exception("Es kam bisher zu keiner Erhöhung.");
        }
        this.letzteErhoehung = letzteErhoehung;
    }

    public LocalDate getLetztePraemie() {
        return letztePraemie;
    }

    public void setLetztePraemie(LocalDate letztePraemie) throws Exception {
        if (letztePraemie == null) {
            throw new Exception("Es kam bisher zu keiner Prämie.");
        }
        this.letztePraemie = letztePraemie;
    }

    public String generateLaufnummer() {
        return getNachname().substring(0, 1) + getVorname().substring(0, 1) + getClass().getSimpleName().substring(0, 1)
                + getGeschlecht() + getGeburtsjahr().getYear();
    }

    public abstract double GehaltBerechnen();
}
