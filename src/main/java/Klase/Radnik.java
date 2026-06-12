package Klase;

public class Radnik extends Osoba{
    private int broj_radnika;
    private double plata;
    private String pozicija;

    public Radnik(int broj_radnika, String ime, String prezime, double plata, String pozicija) {
        // exception ako je broj_radnika <= 0
        // u klasi teretana u metodi DodajRadnika exception ako radnik sa broj_radnika vec postoji
        // exception ako je plata <= 0
        // exception ako je pozicija null ili empty
        super(ime, prezime);
        this.broj_radnika = broj_radnika;
        this.plata = plata;
        this.pozicija = pozicija;
    }

    public int getBroj_radnika() {
        return broj_radnika;
    }

    public void setBroj_radnika(int broj_radnika) {
        // exception ako je broj_radnika <= 0
        // u klasi teretana u metodi DodajRadnika exception ako radnik sa broj_radnika vec postoji
        this.broj_radnika = broj_radnika;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        // exception ako je plata <= 0
        this.plata = plata;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        // exception ako je pozicija null ili empty
        this.pozicija = pozicija;
    }

    @Override
    public String toString() {
        return String.format("Radnik:%nBroj radnika: %d%nIme: %s%nPrezime: %s%nPlata: %f%nPozicija: %s%n", broj_radnika , getIme(), getPrezime(), plata, pozicija);
    }
}
