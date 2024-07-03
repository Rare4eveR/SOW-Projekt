public class Firma {


    private Mitarbeiter[] angestellteMitarbeiter = new Mitarbeiter[20];
    private Mitarbeiter[] ehemaligeMitarbeiter = ehemaligeMitarbeiter;
    private static int anzahlMitarbeiter = 0;

    public Firma(Mitarbeiter[] angestellteMitarbeiter) {
        try {
            angestellteMitarbeiter(angestellteMitarbeiter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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

}






