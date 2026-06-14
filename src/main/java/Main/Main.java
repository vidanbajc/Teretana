package Main;

import Exception.*;
import Klase.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Clan> clanovi = Utils.JSONUtils.UcitajClanove();
        ArrayList<Radnik> radnici = Utils.JSONUtils.UcitajRadnike();
        Teretana t = new Teretana();
        
        try{
            for(Clan c : clanovi)
                t.DodajClana(c);
            
            for(Radnik r : radnici)
                t.DodajRadnika(r);
        }
        catch (OsobaVecPostojiException e) {
            // nece se nikada pojaviti zasto sto ucitavamo jedinstvene osobe
            System.err.println(e.getMessage());
        }
        
        Scanner scan = new Scanner(System.in);
        int opcija;
        
        while(true)
        {
            System.out.println("*************************");
            System.out.println("1. Dodaj clana");
            System.out.println("2. Dodaj radnika");
            System.out.println("3. Pronadji clana");
            System.out.println("4. Pronadji radnika");
            System.out.println("5. Prosecna plata zaposlenih");
            System.out.println("6. Ispisi sve clanove");
            System.out.println("7. Ispisi sve radnike");
            System.out.println("0. Izlaz");
            System.out.println("*************************");
            System.out.print(">> ");
            
            opcija = scan.nextInt();
            scan.nextLine();
                
            switch(opcija)
            {
                case 1 -> { // Dodaj clana
                    try{
                        System.out.print("Unesite ime: ");
                        String ime = scan.nextLine();

                        System.out.print("Unesite prezime: ");
                        String prezime = scan.nextLine();

                        System.out.println("Unesite clanarinu:");
                        System.out.print("Unesite tip: ");
                        String tip = scan.nextLine();

                        System.out.print("Unesite cenu: ");
                        double cena = scan.nextDouble();

                        System.out.print("Unesite broj aktivnih meseci: ");
                        int broj_aktivnih_meseci = scan.nextInt();

                        Clanarina clanarina = new Clanarina(tip, cena, broj_aktivnih_meseci);
                        Clan clan = new Clan(ime, prezime, clanarina);

                        t.DodajClana(clan);
                        Utils.JSONUtils.SacuvajClanove(t.getClanovi());
                        
                    }
                    catch(PraznoPoljeException | NeispravnaVrednostException | OsobaVecPostojiException e){
                        System.err.println(e.getMessage());
                    }
                }

                case 2 -> { // Dodaj radnika
                    try{
                        System.out.println("1. Radnik");
                        System.out.println("2. Menadzer");
                        System.out.print(">> ");
                        
                        int izbor = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Unesite ime: ");
                        String ime = scan.nextLine();

                        System.out.print("Unesite prezime: ");
                        String prezime = scan.nextLine();

                        System.out.print("Unesite platu: ");
                        double plata = scan.nextDouble();
                        scan.nextLine();

                        System.out.print("Unesite poziciju: ");
                        String pozicija = scan.nextLine();

                        Radnik radnik = null;
                        
                        if(izbor == 1)
                            radnik = new Radnik(ime, prezime, plata, pozicija);
                        
                        else if(izbor == 2)
                        {
                            System.out.print("Unesite broj zaposlenih: ");
                            int broj_zaposlenih = scan.nextInt();
                            scan.nextLine();

                            radnik = new Menadzer(ime, prezime, plata, pozicija, broj_zaposlenih);
                        }
                        
                        else{
                            System.out.println("\nUneli ste navalidnu opciju, pokusajte ponovo...");
                            break;
                        }

                        t.DodajRadnika(radnik);
                        Utils.JSONUtils.SacuvajRadnike(t.getRadnici());
                    }
                    catch(PraznoPoljeException | NeispravnaVrednostException | OsobaVecPostojiException e){
                        System.err.println(e.getMessage());
                    }
                }
                case 3 -> { // Pronadji clana
                    try{
                        System.out.print("Unesite broj clana: ");
                        int broj_clana = scan.nextInt();
                        
                        System.out.println("\n" + t.PronadjiClana(broj_clana));
                    }
                    catch(NeispravnaVrednostException | OsobaNijePronadjenaException e){
                        System.err.println(e.getMessage());
                    }
                }
                case 4 -> { // Pronadji radnika
                    try{
                        System.out.print("Unesite broj radnika: ");
                        int broj_radnika = scan.nextInt();
                        
                        System.out.println("\n" + t.PronadjiRadnika(broj_radnika));
                    }
                    catch(NeispravnaVrednostException | OsobaNijePronadjenaException e){
                        System.err.println(e.getMessage());
                    }
                    
                }
                case 5 -> { // Prosecna plata zaposlenih
                    System.out.println("Prosecna plata svih zaposlenih: " + Teretana.ProsecnaPlata(t.getRadnici()) + "\n");
                }
                case 6 -> { // Ispisi sve clanove
                    if(t.getClanovi() == null || t.getClanovi().isEmpty())
                    {
                        System.out.println("\nTrenutno nemate nijednog clana.\n");
                        break;
                    }
                    
                    System.out.println("\nSvi clanovi:\n");
                    t.getClanovi().forEach((c) -> System.out.println(c));
                }
                case 7 -> { // Ispisi sve radnike
                    if(t.getRadnici() == null || t.getRadnici().isEmpty())
                    {
                        System.out.println("\nTrenutno nemate nijednog radnika.\n");
                        break;
                    }
                    
                    System.out.println("\nSvi radnici:\n");
                    t.getRadnici().forEach((r) -> System.out.println(r));
                }
                case 0 -> {
                    System.out.println("\n***********KRAJ***********\n");
                    System.exit(0);
                }
                default -> System.out.println("\nUneli ste navalidnu opciju, pokusajte ponovo...\n");
            }
        }
    }
}
