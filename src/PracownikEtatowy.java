import java.io.Serializable;

public class PracownikEtatowy extends Pracownik implements Serializable {
    protected double etat;
    protected double stawka;
    public PracownikEtatowy() {
        super();
        this.etat = 0;
        this.stawka = 0;
    }
    public PracownikEtatowy(String imie, String nazwisko, long pesel, String stanowisko, int staz, double etat, double stawka) {
        super(imie, nazwisko, pesel, stanowisko, staz);
        this.etat = etat;
        this.stawka = stawka;
    }
    public String pensja() {
        return String.format("%.2f",stawka*etat);
    }


    public String toString() {
        return String.format("Imie: %s, Nazwisko: %s, Pesel: %d, Stanowisko: %s, Staz: %d, Pensja: %s", imie, nazwisko, pesel, stanowisko, staz,pensja());
    }

}
