package Klase;

import Exception.NeispravnaVrednostException;
import Exception.PraznoPoljeException;

public class Radnik extends Osoba{
    private final int broj_radnika;
    private double plata;
    private String pozicija;
    private static int sledeci_broj_radnika = 1;

    public Radnik(String ime, String prezime, double plata, String pozicija) throws PraznoPoljeException, NeispravnaVrednostException{
        super(ime, prezime);

        if(plata <= 0)
            throw new NeispravnaVrednostException("Plata koju ste uneli nije validna (mora biti veci od nule)!");

        if(pozicija == null || pozicija.trim().isEmpty())
            throw new PraznoPoljeException("Pozicija koju ste uneli nije validna!");

        this.broj_radnika = sledeci_broj_radnika++;
        this.plata = plata;
        this.pozicija = pozicija;
    }
    
    public Radnik(int broj_radnika, String ime, String prezime, double plata, String pozicija) throws PraznoPoljeException, NeispravnaVrednostException{
        super(ime, prezime);

        if(broj_radnika <= 0)
            throw new NeispravnaVrednostException("Broj radnika koji ste uneli nije validan (mora biti veci od nule)!");

        if(plata <= 0)
            throw new NeispravnaVrednostException("Plata koju ste uneli nije validna (mora biti veci od nule)!");

        if(pozicija == null || pozicija.trim().isEmpty())
            throw new PraznoPoljeException("Pozicija koju ste uneli nije validna!");

        this.broj_radnika = broj_radnika;
        this.plata = plata;
        this.pozicija = pozicija;
        
        if(broj_radnika >= sledeci_broj_radnika)
            sledeci_broj_radnika = broj_radnika + 1;
    }

    public int getBroj_radnika() {
        return broj_radnika;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) throws NeispravnaVrednostException{
        if(plata <= 0)
            throw new NeispravnaVrednostException("Plata koju ste uneli nije validna (mora biti veci od nule)!");

        this.plata = plata;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) throws PraznoPoljeException{

        if(pozicija == null || pozicija.trim().isEmpty())
            throw new PraznoPoljeException("Pozicija koju ste uneli nije validna!");

        this.pozicija = pozicija;
    }
    
    public static int getSledeci_broj_radnika() {
        return sledeci_broj_radnika;
    }
    
    public static void setSledeci_broj_radnika(int noviBroj) {
        sledeci_broj_radnika = noviBroj;
    }

    @Override
    public String toString() {
        return String.format("Radnik:%nBroj radnika: %d%nIme: %s%nPrezime: %s%nPlata: %f%nPozicija: %s%n", broj_radnika , getIme(), getPrezime(), plata, pozicija);
    }
}
