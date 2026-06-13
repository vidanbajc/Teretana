package Klase;

import Exception.PraznoPoljeException;

public abstract class Osoba {
    private String ime;
    private String prezime;

    public Osoba(String ime, String prezime) throws PraznoPoljeException{
        
        if(ime == null || ime.trim().isEmpty())
            throw new PraznoPoljeException("Ime koje ste uneli nije validno!");

        if(prezime == null || prezime.trim().isEmpty())
            throw new PraznoPoljeException("Prezme koje ste uneli nije validno!");

        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) throws PraznoPoljeException{
        
        if(ime == null || ime.trim().isEmpty())
            throw new PraznoPoljeException("Ime koje ste uneli nije validno!");

        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) throws PraznoPoljeException{
        
        if(prezime == null || prezime.trim().isEmpty())
            throw new PraznoPoljeException("Prezime koje ste uneli nije validno!");

        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return String.format("Osoba:%nIme: %s%nPrezime: %s%n", ime, prezime);
    }
}
