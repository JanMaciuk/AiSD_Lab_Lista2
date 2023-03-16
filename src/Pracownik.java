import java.io.Serializable;

public abstract class Pracownik implements Serializable {
    protected String imie;
    protected String nazwisko;
    protected long pesel;
    protected String stanowisko;
    protected int staz;
    public Pracownik() {
        this.imie = "imie";
        this.nazwisko = "nazwisko";
        this.pesel = 0;
        this.stanowisko = "stanowisko";
        this.staz = 0;
    }
    public Pracownik(String imie, String nazwisko, long pesel, String stanowisko, int staz) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.stanowisko = stanowisko;
        this.staz = staz;
    }
    public void wyswietl() {
        System.out.printf("Imie: %s, Nazwisko: %s, Pesel: %d, Stanowisko: %s, Staz: %d, Pensja: %s %n", imie, nazwisko, pesel, stanowisko, staz,pensja());
    }
    public String toString() {
        return String.format("Imie: %s, Nazwisko: %s, Pesel: %d, Stanowisko: %s, Staz: %d", imie, nazwisko, pesel, stanowisko, staz);
    }
    public abstract String pensja();
}
