package Klase;

import Exception.NeispravnaVrednostException;
import Exception.PraznoPoljeException;

public class Clan extends Osoba{
    private final int broj_clana;
    private Clanarina clanarina;
    private static int sledeci_broj_clana = 1;

    public Clan(String ime, String prezime, Clanarina clanarina) throws PraznoPoljeException {
        super(ime, prezime);
        
        this.broj_clana = sledeci_broj_clana++;
        this.clanarina = clanarina;
    }

    public Clan(int broj_clana, String ime, String prezime, Clanarina clanarina) throws PraznoPoljeException, NeispravnaVrednostException {
        super(ime, prezime);
        
        if (broj_clana <= 0)
            throw new NeispravnaVrednostException("Broj clana nije validan!");
        
        this.broj_clana = broj_clana;
        this.clanarina = clanarina;
        
        if(broj_clana >= sledeci_broj_clana)
            sledeci_broj_clana = broj_clana + 1;
    }

    public int getBroj_clana() {
        return broj_clana;
    }

    public Clanarina getClanarina() {
        return clanarina;
    }

    public void setClanarina(Clanarina clanarina) {
        this.clanarina = clanarina;
    }
    
    @Override
    public String toString() {
        return String.format("Clan:%nBroj clanske karte: %d%nIme: %s%nPrezime: %s%n%s%n",
                              broj_clana, getIme(), getPrezime(), clanarina.toString());
    }
}
