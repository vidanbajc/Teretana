package Klase;

import Exception.NeispravnaVrednostException;
import Exception.PraznoPoljeException;

public class Menadzer extends Radnik{
    private int broj_zaposlenih;
    
    public Menadzer(String ime, String prezime, double plata, String pozicija, int broj_zaposlenih) throws PraznoPoljeException, NeispravnaVrednostException{
        super(ime, prezime, plata, pozicija);
        
        if(broj_zaposlenih < 0) // moze da ima 0 podredjenih
            throw new NeispravnaVrednostException("Broj zaposlenih koji ste uneli nije validan (mora biti pozitivan)!");

        this.broj_zaposlenih = broj_zaposlenih;
    }
    
    public Menadzer(int broj_radnika, String ime, String prezime, double plata, String pozicija, int broj_zaposlenih) throws PraznoPoljeException, NeispravnaVrednostException{
        super(broj_radnika, ime, prezime, plata, pozicija);
        
        if(broj_zaposlenih < 0) // moze da ima 0 podredjenih
            throw new NeispravnaVrednostException("Broj zaposlenih koji ste uneli nije validan (mora biti pozitivan)!");

        this.broj_zaposlenih = broj_zaposlenih;
    }

    public int getBroj_zaposlenih() {
        return broj_zaposlenih;
    }

    public void setBroj_zaposlenih(int broj_zaposlenih) throws NeispravnaVrednostException{
        if(broj_zaposlenih < 0) // moze da ima 0 podredjenih
            throw new NeispravnaVrednostException("Broj zaposlenih koji ste uneli nije validan (mora biti pozitivan)!");

        this.broj_zaposlenih = broj_zaposlenih;
    }

    @Override
    public String toString() {
        return String.format("Radnik:%nBroj menadzera: %d%nIme: %s%nPrezime:"
                + " %s%nPlata: %f%nPozicija: %s%nBroj zaposlenih: %d%n", 
                getBroj_radnika() , getIme(), getPrezime(), getPlata(), getPozicija(), broj_zaposlenih);
    }
    
    
}
