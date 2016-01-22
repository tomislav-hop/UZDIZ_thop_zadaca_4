/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.aplikacija;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import thop_zadaca_4.GeneriranjeSvihVrijednosti;
import thop_zadaca_4.dretve.AutomobilDretva;
import thop_zadaca_4.dretve.VlasnikDretva;
import thop_zadaca_4.izbornik.IspisIzbornika;
import thop_zadaca_4.izbornik.IzvrsiOpciju;
import thop_zadaca_4.izbornik.Opcija1;
import thop_zadaca_4.izbornik.Opcija2;
import thop_zadaca_4.izbornik.Opcija3;
import thop_zadaca_4.izbornik.Opcije;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;
import thop_zadaca_4.podaci.Zona;

/**
 *
 * @author Tomislav
 */
public class ParkingApplication {

    private static ParkingApplication instance;
    public static String delimiter = "-----------------------------------------------------";
    
    public static boolean zaustaviDolaskeAutomobila = false;
    public static List<Automobil> auti; 
    public static List<Zona> zone;
    public static List<PodaciOAutomobilima> dnevnik;

    private ParkingApplication() {
        System.out.println("Nova ParkingApplication aplikacija...");
    }

    public static ParkingApplication getInstance() {
        if (instance == null) {
            synchronized (ParkingApplication.class) {
                if (instance == null) {
                    instance = new ParkingApplication();
                }
            }
        }
        return instance;
    }

    public void start(String[] args) {
        dnevnik = new ArrayList<>();
        ProvjeraArgumenata provjeraArgumenata = new ProvjeraArgumenata();

        if (provjeraArgumenata.provjera(args)) {
            int brojAutomobila = Integer.parseInt(args[0]);
            int brojZona = Integer.parseInt(args[1]);
            int kapacitetZone = Integer.parseInt(args[2]);
            int maksParkiranje = Integer.parseInt(args[3]);
            int vremenskaJedinica = Integer.parseInt(args[4]);
            int intervalDolaska = Integer.parseInt(args[5]);
            int intervalOdlaska = Integer.parseInt(args[6]);
            int cijenaJedinice = Integer.parseInt(args[7]);
            int intervalKontrole = Integer.parseInt(args[8]);
            int kaznaParkiranja = Integer.parseInt(args[9]);

            //spremanje argumenata u listu
            List<Integer> argumenti = new ArrayList<>();
            argumenti.add(brojAutomobila);
            argumenti.add(brojZona);
            argumenti.add(kapacitetZone);
            argumenti.add(maksParkiranje);
            argumenti.add(vremenskaJedinica);
            argumenti.add(intervalDolaska);
            argumenti.add(intervalOdlaska);
            argumenti.add(cijenaJedinice);
            argumenti.add(intervalKontrole);
            argumenti.add(kaznaParkiranja);

            //ispis argumenata
            System.out.println(delimiter);
            System.out.println("brojAutomobila = " + brojAutomobila
                    + "\nbrojZona = " + brojZona
                    + "\nkapacitetZone = " + kapacitetZone
                    + "\nmaksParkiranje = " + maksParkiranje
                    + "\nvremenskaJedinica = " + vremenskaJedinica
                    + "\nintervalDolaska = " + intervalDolaska
                    + "\nintervalOdlaska = " + intervalOdlaska
                    + "\ncijenaJedinice = " + cijenaJedinice
                    + "\nintervalKontrole = " + intervalKontrole
                    + "\nkaznaParkiranja = " + kaznaParkiranja);

            String odabranaOpcija = "";

            //generiranje zona
            GeneriranjeSvihVrijednosti gsv = new GeneriranjeSvihVrijednosti(argumenti);
            zone = gsv.generirajZone();
            
            //ispis zona
            System.out.println(delimiter);
            for (Zona z : zone) {
                z.ispisZone();
            }
            System.out.println(delimiter);
            
            //popunjavanje liste automobila
            auti = Collections.synchronizedList(new ArrayList<>());
            for (int i = 1; i <= brojAutomobila; i++) {
                auti.add(new Automobil(i));
            }
            
            //pokretanje dretve za dolaske automobila
            AutomobilDretva ad = new AutomobilDretva();
            ad.setGsv(gsv);
            ad.setArgumenti(argumenti);
            ad.start();
            
            //pokretanje dretve za vlasnike
            VlasnikDretva vd = new VlasnikDretva();
            vd.setGsv(gsv);
            vd.setArgumenti(argumenti);
            vd.start();

            do {
                IspisIzbornika ispisIzbornika = new IspisIzbornika();
                ispisIzbornika.ispisiIzbornik();
                System.out.println("Vaš odabir: ");
                odabranaOpcija = ispisIzbornika.odabranaOpcija();
                //System.out.println("Odabrana opcija je: " + ispisIzbornika.odabranaOpcija());

                Opcije opcije = new Opcije();
                IzvrsiOpciju izvrsiOpciju = new IzvrsiOpciju();

                switch (odabranaOpcija) {
                    case "1":
                        Opcija1 op1 = new Opcija1(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op1);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;
                    case "2":
                        Opcija2 op2 = new Opcija2(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op2);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;
                    case "3":
                        Opcija3 op3 = new Opcija3(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op3);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;

                }
            } while (!odabranaOpcija.equals("Q"));
        }
    }
}
