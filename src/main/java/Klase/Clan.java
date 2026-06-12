package Klase;

public class Clan extends Osoba{
    private int broj_clana;
    private Clanarina clanarina;

    public Clan(int broj_clana, String ime, String prezime, Clanarina clanarina) {
        // exception ako je broj_clana <= 0
        // u klasi teretana u metodi DodajClana exception ako clan sa broj_clana vec postoji
        super(ime, prezime);
        this.broj_clana = broj_clana;
        this.clanarina = clanarina;
    }

    public int getBroj_clana() {
        return broj_clana;
    }

    public void setBroj_clana(int broj_clana) {
        // exception ako je broj_clana <= 0
        // u klasi teretana u metodi DodajClana exception ako clan sa broj_clana vec postoji
        this.broj_clana = broj_clana;
    }

    public Clanarina getClanarina() {
        return clanarina;
    }

    public void setClanarina(Clanarina clanarina) {
        this.clanarina = clanarina;
    }
    
    @Override
    public String toString() {
        return String.format("Clan:%nBroj clanske karte: %d%nIme: %s%nPrezime: %s%n%s%n", broj_clana, getIme(), getPrezime(), clanarina.toString());
    }
    
    
}
