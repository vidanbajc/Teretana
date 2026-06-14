package Klase;

import Exception.NeispravanDatumPocetkaException;
import Exception.NeispravnaVrednostException;
import Exception.PraznoPoljeException;
import Interface.Placanje;
import java.time.LocalDate;

public class Clanarina implements Placanje{
    private String tip;
    private double cena;
    private int broj_aktivnih_meseci;
    private LocalDate datum_pocetka;

    public Clanarina(String tip, double cena, int broj_aktivnih_meseci) 
            throws PraznoPoljeException, NeispravnaVrednostException {
        
        if(tip == null || tip.trim().isEmpty())
            throw new PraznoPoljeException("Tip placanja koji ste uneli nije validan!");

        if(cena <= 0)
            throw new NeispravnaVrednostException("Cena koju ste uneli nije validna (mora biti veca od nule)!");

        if(broj_aktivnih_meseci <= 0)
            throw new NeispravnaVrednostException("Broj aktivnih meseci koji ste uneli nije validan (mora biti veci od nule)!");

        this.tip = tip;
        this.cena = cena;
        this.broj_aktivnih_meseci = broj_aktivnih_meseci;
        this.datum_pocetka = LocalDate.now();
    }
    
    public Clanarina(String tip, double cena, int broj_aktivnih_meseci, LocalDate datum_pocetka) 
            throws PraznoPoljeException, NeispravnaVrednostException, NeispravanDatumPocetkaException{
        
        if(tip == null || tip.trim().isEmpty())
            throw new PraznoPoljeException("Tip placanja koji ste uneli nije validan!");

        if(cena <= 0)
            throw new NeispravnaVrednostException("Cena koju ste uneli nije validna (mora biti veca od nule)!");

        if(broj_aktivnih_meseci <= 0)
            throw new NeispravnaVrednostException("Broj aktivnih meseci koji ste uneli nije validan (mora biti veci od nule)!");

        if(datum_pocetka == null || datum_pocetka.isAfter(LocalDate.now()))
            throw new NeispravanDatumPocetkaException("Datum nije validan!");

        this.tip = tip;
        this.cena = cena;
        this.broj_aktivnih_meseci = broj_aktivnih_meseci;
        this.datum_pocetka = datum_pocetka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) throws PraznoPoljeException{
        if(tip == null || tip.trim().isEmpty())
            throw new PraznoPoljeException("Tip placanja koji ste uneli nije validan!");

        this.tip = tip;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) throws NeispravnaVrednostException{
        if(cena <= 0)
            throw new NeispravnaVrednostException("Cena koju ste uneli nije validna (mora biti veca od nule)!");

        this.cena = cena;
    }

    public int getBroj_aktivnih_meseci() {
        return broj_aktivnih_meseci;
    }

    public void setBroj_aktivnih_meseci(int broj_aktivnih_meseci) throws NeispravnaVrednostException{
        if(broj_aktivnih_meseci <= 0)
            throw new NeispravnaVrednostException("Broj aktivnih meseci koji ste uneli nije validan (mora biti veci od nule)!");

        this.broj_aktivnih_meseci = broj_aktivnih_meseci;
    }

    public LocalDate getDatum_pocetka() {
        return datum_pocetka;
    }

    public void setDatum_pocetka(LocalDate datum_pocetka) throws NeispravanDatumPocetkaException{
        if(datum_pocetka == null || !datum_pocetka.equals(LocalDate.now()))
            throw new NeispravanDatumPocetkaException("Datum pocetka koji ste uneli nije validan (mora biti danasnji datum)!");

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
