import java.io.Serializable;

public class PracownikGodzinowy extends Pracownik implements Serializable {
    protected double stawka;
    protected int liczba_godz;

    public PracownikGodzinowy() {
        super();
        this.stawka = 0;
        this.liczba_godz = 0;
    }
    public PracownikGodzinowy(String imie, String nazwisko, long pesel, String stanowisko, int staz, double stawka, int liczba_godz) {
        super(imie, nazwisko, pesel, stanowisko, staz);
        this.stawka = stawka;
        this.liczba_godz = liczba_godz;
    }
    public String pensja() {
            return String.format("%.2f",stawka*liczba_godz);
    }
    public String toString() {
        return String.format("%s, %s, %d, %s, %d, %s", imie, nazwisko, pesel, stanowisko, staz, pensja());
    }
}
