import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class Main {
    protected static int liczbaPracownikow = 5;
    protected static String[] danePracownikow = new String[liczbaPracownikow*6];
    public static void main(String[] args) {

        //Generowanie pracowników
        PracownikGodzinowy pg1 = new PracownikGodzinowy("Marek", "Kowalski", 123456789, "Recepcjonista", 5, 25, 50);
        PracownikGodzinowy pg2 = new PracownikGodzinowy("Kuba", "Duda", 123456789, "Kierowca",1,20,40);
        PracownikEtatowy pe1 = new PracownikEtatowy("Jan", "Kowalski", 123456789, "Kierowca", 2, 1, 850);
        PracownikEtatowy pe2 = new PracownikEtatowy("Adam", "Spory", 123456789, "kierownik", 12, 0.5, 1000);
        PracownikEtatowy pe3 = new PracownikEtatowy("Jakub", "Spory", 123456789, "Magazynier", 12, 0.75, 1750);
        Pracownik[] pracownicy = {pg1, pg2, pe1, pe2,pe3};

        //Zapisywanie danych do listy
        int j = 0;
        for (Pracownik pracownik : pracownicy) {
            danePracownikow[j] = pracownik.nazwisko;
            danePracownikow[j + 1] = pracownik.imie;
            danePracownikow[j + 2] = Long.toString(pracownik.pesel);
            danePracownikow[j + 3] = pracownik.stanowisko;
            danePracownikow[j + 4] = Integer.toString(pracownik.staz);
            danePracownikow[j + 5] = Double.toString(pracownik.pensja());
            j = j + 6;
        }
        printTabela();
        iteratePrint();
        fileWriteRead(pracownicy);
    }


    public static void printTabela() {//Wyświetlanie danych
        System.out.printf("-------------------------------------------------------------------------------------%n");
        System.out.printf("| %-12s | %-10s | %-14s | %-14s | %-6s | %-10s |%n", "Nazwisko", "Imie", "Pesel", "Stanowisko", "Staz", "Pensja");
        System.out.printf("-------------------------------------------------------------------------------------%n");
        for (int i = 0; i < danePracownikow.length; i+=6) {
            System.out.printf("| %-12s | %-10s | %-14s | %-14s | %-6s | %-10s |%n", danePracownikow[i], danePracownikow[i+1], danePracownikow[i+2], danePracownikow[i+3], danePracownikow[i+4], danePracownikow[i+5]);
        }
        System.out.printf("-------------------------------------------------------------------------------------%n%n");}



    public static void iteratePrint() {
        Iterator<String> iterator = new Iterator<>() {
            int i = 0;
            @Override
            public boolean hasNext() {
               return i < danePracownikow.length;
            }

            @Override
            public String next() {
                return danePracownikow[i++];
            }};

        int i = 0;
        System.out.println("Wyświetlanie danych iteratorem:");
        while (iterator.hasNext()) {
            i++;
            System.out.print(iterator.next() + " ");
            if (i % 6 == 0) {
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void fileWriteRead(Pracownik[] pracownicy) {
        //Zapis:
        try {
            FileOutputStream fout = new FileOutputStream("plik.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(liczbaPracownikow);
            for (Pracownik pracownik : pracownicy) {
                oos.writeObject(pracownik);
            }
            System.out.println("Pomyślnie zapisano dane do pliku.");
        }
        catch (Exception e) {
            System.out.println("Błąd przy zapisie do pliku:");
            e.printStackTrace();
        }
        //Odczyt:
        try {
            FileInputStream fin = new FileInputStream("plik.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            int liczbazPliku = (int) ois.readObject();
            Pracownik[] pracownicyzPliku = new Pracownik[liczbazPliku];
            System.out.println("Odczytywanie z pliku:\nLiczba pracowników: " + liczbazPliku);
            for (int i = 0; i < liczbazPliku; i++) {
                pracownicyzPliku[i] = (Pracownik) ois.readObject();
                pracownicyzPliku[i].wyswietl();
            }
        }
        catch (Exception e) {
            System.out.println("Błąd przy odczycie z pliku:");
            e.printStackTrace();
        }
    }
}