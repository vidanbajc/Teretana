package Klase;

public abstract class Osoba {
    private String ime;
    private String prezime;
    
    public Osoba() {
        this.ime = "";
        this.prezime = "";
    }

    public Osoba(String ime, String prezime) {
        // exception ako je ime null ili empty
        // exception ako je prezime null ili empty
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        // exception ako je ime null ili empty
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        // exception ako je prezime null ili empty
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return String.format("Osoba:%nIme: %s%nPrezime: %s%n", ime, prezime);
    }
    
    
}
