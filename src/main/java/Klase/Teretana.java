package Klase;

import java.util.ArrayList;

public class Teretana {
    private ArrayList<Clan> clanovi;
    private ArrayList<Radnik> radnici;

    public Teretana() {
        this.clanovi = new ArrayList<Clan>();
        this.radnici = new ArrayList<Radnik>();
    }
    
    public void DodajClana(Clan clan)
    {
        // exception ako pokusamo da dodamo istog clana, isti broj_clana
        clanovi.add(clan);
    }
    
    public void DodajRadnika(Radnik radnik)
    {
        // exception ako pokusamo da dodamo istog radnika/menadzera, isti broj_radnika
        radnici.add(radnik);
    }
    
    public Clan PronadjiClana(int broj_clana)
    {
        // exception ako je broj_clana <= 0
        
        for(Clan c : clanovi)
            if(c.getBroj_clana() == broj_clana)
                return c;
        
        return null;
    }
    
    public Radnik PronadjiRadnika(int broj_radnika)
    {
        // exception ako je broj_radnika <= 0
        
        for(Radnik r : radnici)
            if(r.getBroj_radnika() == broj_radnika)
                return r;
        
        return null;
    }
    
    public static double ProsecnaPlata(ArrayList<Radnik> radnici)
    {
        if(radnici.isEmpty())
            return 0;
        
        double suma = 0;
        
        for (Radnik r : radnici)
            suma += r.getPlata();
        
        return suma / radnici.size();
    }
}
