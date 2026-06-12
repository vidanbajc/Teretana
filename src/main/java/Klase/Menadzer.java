package Klase;

public class Menadzer extends Radnik{
    private int broj_zaposlenih;
    
    public Menadzer(int broj_radnika, String ime, String prezime, double plata, String pozicija, int broj_zaposlenih) {
        // exception ako je broj_zaposlenih <= 0
        super(broj_radnika, ime, prezime, plata, pozicija);
        this.broj_zaposlenih = broj_zaposlenih;
    }

    public int getBroj_zaposlenih() {
        return broj_zaposlenih;
    }

    public void setBroj_zaposlenih(int broj_zaposlenih) {
        // exception ako je broj_zaposlenih <= 0
        this.broj_zaposlenih = broj_zaposlenih;
    }

    @Override
    public String toString() {
        return String.format("Radnik:%nBroj menadzera: %d%nIme: %s%nPrezime:"
                + " %s%nPlata: %f%nPozicija: %s%nBroj zaposlenih: %d%n", 
                getBroj_radnika() , getIme(), getPrezime(), getPlata(), getPozicija(), broj_zaposlenih);
    }
    
    
}
