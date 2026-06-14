package Klase;

import Exception.NeispravnaVrednostException;
import Exception.OsobaNijePronadjenaException;
import Exception.OsobaVecPostojiException;
import java.util.ArrayList;

public class Teretana {
    private final ArrayList<Clan> clanovi;
    private final ArrayList<Radnik> radnici;

    public Teretana() {
        this.clanovi = new ArrayList<>();
        this.radnici = new ArrayList<>();
    }

    public ArrayList<Clan> getClanovi() {
        return clanovi;
    }

    public ArrayList<Radnik> getRadnici() {
        return radnici;
    }
    
    public void DodajClana(Clan clan) throws OsobaVecPostojiException
    {
        for(Clan c : clanovi)
            if(c.getBroj_clana() == clan.getBroj_clana())
                throw new OsobaVecPostojiException("Clan sa ovim brojem clana vec postoji!");
        
        clanovi.add(clan);
    }
    
    public void DodajRadnika(Radnik radnik) throws OsobaVecPostojiException
    {
        for(Radnik r : radnici)
            if(r.getBroj_radnika() == radnik.getBroj_radnika())
                throw new OsobaVecPostojiException("Radnik sa ovim brojem radnika vec postoji!");
        
        radnici.add(radnik);
    }
    
    public Clan PronadjiClana(int broj_clana) throws NeispravnaVrednostException, OsobaNijePronadjenaException
    {
        if(broj_clana <= 0)
            throw new NeispravnaVrednostException("Broj radnika koji ste uneli nije validan (mora biti veci od nule)!");
        
        for(Clan c : clanovi)
            if(c.getBroj_clana() == broj_clana)
                return c;
        
        throw new OsobaNijePronadjenaException(String.format("Clan sa brojem clana %d nije pronadjen", broj_clana));
    }
    
    public Radnik PronadjiRadnika(int broj_radnika) throws NeispravnaVrednostException, OsobaNijePronadjenaException
    {
        if(broj_radnika <= 0)
            throw new NeispravnaVrednostException("Broj radnika koji ste uneli nije validan (mora biti veci od nule)!");
        
        for(Radnik r : radnici)
            if(r.getBroj_radnika() == broj_radnika)
                return r;
        
        throw new OsobaNijePronadjenaException(String.format("Radnik sa brojem radnika %d nije pronadjen", broj_radnika));
    }
    
    public static double ProsecnaPlata(ArrayList<Radnik> radnici)
    {
        if(radnici == null || radnici.isEmpty())
            return 0;
        
        double suma = 0;
        
        for (Radnik r : radnici)
            suma += r.getPlata();
        
        return suma / radnici.size();
    }
}
