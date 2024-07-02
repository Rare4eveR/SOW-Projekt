import java.time.LocalDate;

public class Angestellte extends Mitarbeiter{

    public Angestellte(String _nachname, String _vorname, String _adresse, LocalDate _geburtsdatum, LocalDate _eintrittsdatum, double stundenLohn, double ueberstundenLohn,
                       double stundenAnzahl, double ueberStundenAnzahl) {
        super(_nachname, _vorname, _adresse, _geburtsdatum, _eintrittsdatum);
        StundenLohn = stundenLohn;
        UeberstundenLohn = ueberstundenLohn;
        StundenAnzahl = stundenAnzahl;
        this.ueberStundenAnzahl = ueberStundenAnzahl;
    }

    private double StundenLohn;
	private double UeberstundenLohn;
	private double StundenAnzahl;
    private double ueberStundenAnzahl;

	public void Angestellte(double StundenLohn, double StundenAnzahl, double UeberstundenLohn, double ueberStundenAnzahl ){

    }
	public void GehaltBerechnen(double StundenLohn, double Ueberstunden){


    }

    public double getStundenLohn() {
        return StundenLohn;
    }

    public void setStundenLohn(double stundenLohn) {
        StundenLohn = stundenLohn;
    }

    public double getUeberstundenLohn() {
        return UeberstundenLohn;
    }

    public void setUeberstundenLohn(double ueberstundenLohn) {
        UeberstundenLohn = ueberstundenLohn;
    }

    public double getStundenAnzahl() {
        return StundenAnzahl;
    }

    public void setStundenAnzahl(double stundenAnzahl) {
        StundenAnzahl = stundenAnzahl;
    }

    public double getUeberStundenAnzahl() {
        return ueberStundenAnzahl;
    }

    public void setUeberStundenAnzahl(double ueberStundenAnzahl) {
        this.ueberStundenAnzahl = ueberStundenAnzahl;
    }
}
