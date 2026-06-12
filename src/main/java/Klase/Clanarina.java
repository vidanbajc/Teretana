package Klase;

import Interface.Placanje;
import java.time.LocalDate;

public class Clanarina implements Placanje{
    private String tip;
    private double cena;
    private int broj_aktivnih_meseci;
    private LocalDate datum_pocetka;

    public Clanarina(String tip, double cena, int broj_aktivnih_meseci, LocalDate datum_pocetka) {
        // exception ako je tip null ili empty
        // exception ako je cena <= 0
        // exception ako je broj_aktivnih_meseci <= 0
        // exception ako je datum_pocetka null ili nije danasnji datum
        this.tip = tip;
        this.cena = cena;
        this.broj_aktivnih_meseci = broj_aktivnih_meseci;
        this.datum_pocetka = datum_pocetka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        // exception ako je tip null ili empty
        this.tip = tip;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        // exception ako je cena <= 0
        this.cena = cena;
    }

    public int getBroj_aktivnih_meseci() {
        return broj_aktivnih_meseci;
    }

    public void setBroj_aktivnih_meseci(int broj_aktivnih_meseci) {
        // exception ako je broj_aktivnih_meseci <= 0
        this.broj_aktivnih_meseci = broj_aktivnih_meseci;
    }

    public LocalDate getDatum_pocetka() {
        return datum_pocetka;
    }

    public void setDatum_pocetka(LocalDate datum_pocetka) {
        // exception ako je datum_pocetka null ili nije danasnji datum
        this.datum_pocetka = datum_pocetka;
    }

    @Override
    public String toString() {
        return String.format("Clanarina: %nTip: %s%nCena: %f%nBroj aktivnih meseci: %d%nDatum pocetka: %s%n", tip, cena, broj_aktivnih_meseci, datum_pocetka);
    }
    
    @Override
    public double IzracunajIznos(){
        
        if(broj_aktivnih_meseci >= 12)
            return cena * 0.75;
        
        if(broj_aktivnih_meseci >= 6)
            return cena * 0.85;
        
        return cena;
    }
}
