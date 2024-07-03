import java.time.LocalDate;

public class Geschäftsführer extends Manager {

    private String laufNummer;
    private double geschaftsfuehrerZulage;

    public Geschäftsführer (String nachname, String vorname, String adresse,
                            LocalDate geburtsdatum, LocalDate eintrittsdatum, char geschlecht,
                            double managerLohn, double provisionsSatz, double geschaftsfuehrerZulage) throws Exception {
        super(nachname , vorname ,adresse , geburtsdatum, eintrittsdatum, geschlecht, managerLohn, provisionsSatz);
        kennung = super.kennung();

    }

    @Override
    public String getKennung(){
        return Kennung;
    }

    public double getGeschaftsfuehrerZulage() {
        return geschaftsfuehrerZulage;
    }

    public void setGeschaftsfuehrerZulage(double geschaftsfuehrerZulage)
        throws Exception {
        if(geschaftsfuehrerZulage <0) {
            throw new Exception("GeschaeftsfuehrerZulage kann nicht negativ sein");
        }
        this.geschaftsfuehrerZulage = geschaftsfuehrerZulage;
    }

    @Override
    public double GehaltBerechnen(){
        return super.GehaltBerechnen() + geschaftsfuehrerZulage;

    }

    @Override
    public String toString() {
        return super.toString() +
       "geschaeftsfuehrerZulage= " + geschaftsfuehrerZulage + "\"" +
       ",kennung=" + kennung + "€";
    }

}
