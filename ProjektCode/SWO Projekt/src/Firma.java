import java.time.LocalDate;

public class Firma {

    /**
     *
     * Version 1.0 Arkadius Skatulla, Devran Sakar
     *
     */


    private Mitarbeiter[] angestellteMitarbeiter = new Mitarbeiter[20];
    private Mitarbeiter[] ehemaligeMitarbeiter;
    private static int anzahlMitarbeiter = 0;

    public Firma(Mitarbeiter[] angestellteMitarbeiter) {
        try {
            angestellteMitarbeiter(angestellteMitarbeiter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void angestellteMitarbeiter(Mitarbeiter[] angestellteMitarbeiter) {

    }

    /**
     *
     * Getter und Setter
     *
     * @return
     */
    public Mitarbeiter[] getAngestellteMitarbeiter() {

        return angestellteMitarbeiter;
    }


    public void setAngestellteMitarbeiter(Mitarbeiter[] angestellteMitarbeiter) throws Exception {
        for (int i = 0; i < angestellteMitarbeiter.length; i++) {
            if (angestellteMitarbeiter[i] != null) {
                this.angestellteMitarbeiter = angestellteMitarbeiter;
            }
        }

        if (getAngestellteMitarbeiter() == null) {
            throw new Exception("Die Angestelltenliste ist leer, ihr Unternehmen hat keine Mitarbeiter");
        }
    }

    public Mitarbeiter[] getEhemaligeMitarbeiter() {
        return ehemaligeMitarbeiter;
    }

    public void setEhemaligeMitarbeiter(Mitarbeiter[] ehemaligeMitarbeiter) {
        this.ehemaligeMitarbeiter = ehemaligeMitarbeiter;
    }

    public static int getAnzahlMitarbeiter() {
        return anzahlMitarbeiter;
    }


    public static void setAnzahlMitarbeiter(int anzahlMitarbeiter) throws Exception {
        if (anzahlMitarbeiter <= 0) {
            throw new Exception("Die Anzahl der Mitarbeiter muss über 0 sein.");
        }
        Firma.anzahlMitarbeiter = anzahlMitarbeiter;
    }

    /**
     *
     * Mitarbeiter Hinzufügen
     * @param mitarbeiter
     * @throws Exception
     */
    public void mitarbeiterHinzufuegen(Mitarbeiter mitarbeiter) throws Exception {
        if (mitarbeiter == null) {
            throw new Exception("mitarbeiter must not be null");
        }
        for (int i = 0; i < getAngestellteMitarbeiter().length; i++) {
            if (getAngestellteMitarbeiter()[i] == null) {
                getAngestellteMitarbeiter()[i] = mitarbeiter;
            }
        }
    }

    /**
     * Mitarbeiter Entfernen
     * @param mitarbeiter
     * @throws Exception
     */

    public void mitarbieterEntfernen(Mitarbeiter mitarbeiter) throws Exception {
        if (mitarbeiter == null) {
            throw new Exception("mitarbeiter must not be null");
        }
        for (int i = 0; i < getAngestellteMitarbeiter().length; i++) {
            if (getAngestellteMitarbeiter()[i] == mitarbeiter) {
                for (int j = i + 1; j < getEhemaligeMitarbeiter().length; j++) {
                    if (getEhemaligeMitarbeiter()[j] != null) {
                        getEhemaligeMitarbeiter()[j] = mitarbeiter;
                    }
                }
                getAngestellteMitarbeiter()[i] = null;
            }
        }
    }

    /**
     *Niedrigsten Lohn berechnen
     *
     * @return
     */

    public double MinLohn(){
        double temp = MaxLohn();
        for (int i = 0; i < angestellteMitarbeiter.length; i++) {
            if (angestellteMitarbeiter[i] != null) {
                if (angestellteMitarbeiter[i].GehaltBerechnen() < temp){
                    temp = angestellteMitarbeiter[i].GehaltBerechnen();
                }
            } else if (angestellteMitarbeiter[i] == null) {
                System.out.println("Der Index i der Liste ist Leer." + i);
                break;
            }
        }
        return temp;
    }

    /**
     *
     * Den höchsten Lohn Berechnen
     * @return
     */

    public double MaxLohn(){
        double temp = 0.0;
        for (int i = 0; i < angestellteMitarbeiter.length; i++) {
            if (angestellteMitarbeiter[i] != null) {
                if (angestellteMitarbeiter[i].GehaltBerechnen() > temp){
                    temp = angestellteMitarbeiter[i].GehaltBerechnen();
                }
            } else if (angestellteMitarbeiter[i] == null) {
                System.out.println("Der Index i der Liste ist Leer." + i);
                break;
            }
        }
        return temp;
    }

    /**
     * Die Verdienstspanne festlegen
     * @return
     */
    public double VerdienstSpanne(){
        return MaxLohn() - MinLohn();
    }

    /**
     *
     * Durchschnittliches Alter ermitteln
     * @return
     */

    public double DurchschittsAlter(){
        double temp = 0.0;
        for (int i = 0; i < angestellteMitarbeiter.length; i++) {
            if (angestellteMitarbeiter[i] != null) {
                temp += angestellteMitarbeiter[i].getGeburtsjahr().getYear();
            } else if (angestellteMitarbeiter[i] == null) {
                System.out.println("Der Index i der Liste ist Leer." + i);
                break;
            }
        }
        return temp / getAnzahlMitarbeiter();
    }

    /**
     *
     *  Ermittelt den am Längsten Eingestellten Mitarbeiter des Unternehmens.
     *
     * @return
     */


    public Mitarbeiter LaengsterMitarbeiter(){
        int temp = LocalDate.now().getYear();
        Mitarbeiter mitarbeiter = null;
        for (int i = 0; i < angestellteMitarbeiter.length; i++) {
            if (angestellteMitarbeiter[i] != null) {
                if (angestellteMitarbeiter[i].getEintrittsdatum().getYear() < temp) {
                    mitarbeiter = angestellteMitarbeiter[i];
                    temp = angestellteMitarbeiter[i].getEintrittsdatum().getYear();
                }
            }
        }
        return mitarbeiter;
    }



}






