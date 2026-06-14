package Utils;

import Klase.Clan;
import Klase.Clanarina;
import Klase.Radnik;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtils {
    
    public static void SacuvajClanove(ArrayList<Clan> clanovi)
    {
        JSONArray json_niz = new JSONArray();
        
        for(Clan c : clanovi)
        {
            JSONObject obj = new JSONObject();
            obj.put("broj_clana", c.getBroj_clana());
            obj.put("ime", c.getIme());
            obj.put("prezime", c.getPrezime());
            
            JSONObject objj = new JSONObject();
            objj.put("tip", c.getClanarina().getTip());
            objj.put("cena", c.getClanarina().getCena());
            objj.put("broj_aktivnih_meseci", c.getClanarina().getBroj_aktivnih_meseci());
            objj.put("datum_pocetka", c.getClanarina().getDatum_pocetka().toString());
            
            obj.put("clanarina", objj);
            
            json_niz.add(obj);
        }
        
        try(FileWriter fw = new FileWriter("src/main/artifacts/clanovi.json")) {
            fw.write(json_niz.toJSONString());
        }
        catch(IOException e){
            System.err.println("Greska pri cuvanju: " + e.getMessage());
        }
    }
    
    public static void SacuvajRadnike(ArrayList<Radnik> radnici)
    {
        JSONArray json_niz = new JSONArray();
        
        for(Radnik r : radnici)
        {
            JSONObject obj = new JSONObject();
            obj.put("broj_radnika", r.getBroj_radnika());
            obj.put("ime", r.getIme());
            obj.put("prezime", r.getPrezime());
            obj.put("plata", r.getPlata());
            obj.put("pozicija", r.getPozicija());
            
            json_niz.add(obj);
        }
        
        try(FileWriter fw = new FileWriter("src/main/artifacts/radnici.json")) {
            fw.write(json_niz.toJSONString());
        }
        catch(IOException e){
            System.err.println("Greska pri cuvanju: " + e.getMessage());
        }
    }
    
    public static ArrayList<Clan> UcitajClanove()
    {
        ArrayList<Clan> clanovi = new ArrayList<>();
        
        File file = new File("src/main/artifacts/clanovi.json");
        
        if(!file.exists())
            return clanovi;
            
        try(FileReader fr = new FileReader(file)){
            JSONParser parser = new JSONParser();
            JSONArray json_niz = (JSONArray) parser.parse(fr);
            
            for(Object o : json_niz)
            {
                JSONObject obj = (JSONObject) o;
                int broj = Integer.parseInt(obj.get("broj_clana").toString());
                String ime = obj.get("ime").toString();
                String prezime = obj.get("prezime").toString();
                
                JSONObject objj = (JSONObject) obj.get("clanarina");
                String tip = objj.get("tip").toString();
                double cena = Double.parseDouble(objj.get("cena").toString());
                int broj_aktivnih_meseci = Integer.parseInt(objj.get("broj_aktivnih_meseci").toString());
                LocalDate datum_pocetka = LocalDate.parse(objj.get("datum_pocetka").toString());
                
                Clanarina clanarina = new Clanarina(tip, cena, broj_aktivnih_meseci, datum_pocetka);
                
                Clan clan = new Clan(broj, ime, prezime, clanarina);
                clanovi.add(clan);
            }
        }
        catch(Exception e){
            System.err.println("Greska pri ucitavanju: " + e.getMessage());
        }
        
        return clanovi;
    }
    
    public static ArrayList<Radnik> UcitajRadnike()
    {
        ArrayList<Radnik> radnici = new ArrayList<>();
        
        File file = new File("src/main/artifacts/radnici.json");
        
        if(!file.exists())
            return radnici;
        
        try(FileReader fr = new FileReader(file)){
            JSONParser parser = new JSONParser();
            JSONArray json_niz = (JSONArray) parser.parse(fr);
            
            for(Object o : json_niz)
            {
                JSONObject obj = (JSONObject) o;
                int broj = Integer.parseInt(obj.get("broj_radnika").toString());
                String ime = obj.get("ime").toString();
                String prezime = obj.get("prezime").toString();
                double plata = Double.parseDouble(obj.get("plata").toString());
                String pozicija = obj.get("pozicija").toString();
                
                Radnik radnik = new Radnik(broj, ime, prezime, plata, pozicija);
                radnici.add(radnik);
            }
        }
        catch(Exception e){
            System.err.println("Greska pri ucitavanju: " + e.getMessage());
        }
        
        return radnici;
    }
}
