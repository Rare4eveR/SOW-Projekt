import java.time.LocalDate;

/**
 * @version 1.0
 * @author Devran Sakar, Arkadius Skatulla
 */

public class Manager extends Mitarbeiter {
    private double managerLohn;
    private double provisionsSatz;
    private double gewinn;
    private String laufNummer;

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
     * @throws Exception wenn der Managerlohn oder der Provisionssatz ungültig ist
     *      */

    public Manager(String nachname, String vorname, String adresse, LocalDate geburtsdatum,
                   LocalDate eintrittsdatum, char geschlecht, LocalDate letzteErhoehung, LocalDate letztePraemie) throws Exception {
        super(nachname, vorname, adresse, geburtsdatum, eintrittsdatum, geschlecht, null, null);
        try {
            setManagerLohn(managerLohn);
            setProvisionsSatz(provisionsSatz);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        laufNummer = super.generateLaufnummer();
    }



    @Override
    public String generateLaufnummer() {
        return laufNummer;
    }

    public double getManagerLohn() {
        return managerLohn;
    }

    public void setManagerLohn(double managerLohn) throws Exception {
        if (managerLohn <= 0) {
            throw new Exception("Der Managerlohn muss größer als 0 sein.");
        }
        this.managerLohn = managerLohn;
    }



    public double getProvisionsSatz() {
        return provisionsSatz;
    }

    public void setProvisionsSatz(double provisionsSatz) throws Exception {
        if (provisionsSatz <= 0) {
            throw new Exception("Der Provisionssatz muss größer als 0 sein.");
        }
        this.provisionsSatz = provisionsSatz;
    }

    public double berechneProvision() {
        if (gewinn <= 0) {
            return 0;
        }
        double provision = getGewinn();
        setGewinn(0);
        return provision * provisionsSatz;
    }

    /**
     *
     * @param prozentsatz der Prozentsatz, um den der Lohn erhöht werden soll
     * @throws Exception wenn der Prozentsatz ungültig ist
     */


    public void lohnErhoehen(double prozentsatz) throws Exception {
        if (prozentsatz > 0 && prozentsatz <= 15) {
            managerLohn += managerLohn * (prozentsatz / 100);
        } else {
            throw new Exception("Der Prozentsatz muss größer als 0 und kleiner als 15 sein.");
        }
    }

    public double getGewinn() {
        return gewinn;
    }

    public void setGewinn(double gewinn) {
        this.gewinn = gewinn;
    }

    @Override
    public double GehaltBerechnen() {
        return managerLohn + berechneProvision();
    }

    @Override
    public String toString() {
        return super.toString() +
                "Managerlohn=" + managerLohn +
                "€, Provisionssatz=" + provisionsSatz +
                "%, Gewinn=" + gewinn +
                "Laufnummer='" + laufNummer + '\'';
    }
}