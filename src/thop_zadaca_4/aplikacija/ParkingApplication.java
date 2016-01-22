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
import thop_zadaca_4.dretve.KontolorDretva;
import thop_zadaca_4.dretve.VlasnikDretva;
import thop_zadaca_4.ispisi_zona_iterator.IspisZona;
import thop_zadaca_4.izbornik_command.IspisIzbornika;
import thop_zadaca_4.izbornik_command.IzvrsiOpciju;
import thop_zadaca_4.izbornik_command.Opcija1;
import thop_zadaca_4.izbornik_command.Opcija2;
import thop_zadaca_4.izbornik_command.Opcija3;
import thop_zadaca_4.izbornik_command.Opcija4;
import thop_zadaca_4.izbornik_command.Opcija5;
import thop_zadaca_4.izbornik_command.Opcija6;
import thop_zadaca_4.izbornik_command.Opcija7;
import thop_zadaca_4.izbornik_command.Opcija8;
import thop_zadaca_4.izbornik_command.Opcije;
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
        dnevnik = Collections.synchronizedList(new ArrayList<>());
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

            //ispis zona iteratorom
            IspisZona iz = new IspisZona();
            iz.ispisZona();
            
            System.out.println(delimiter);

            IspisIzbornika ispisIzbornika = new IspisIzbornika();
            ispisIzbornika.ispisiIzbornik();
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

            //pokretanje dretve kontrolora
            KontolorDretva kd = new KontolorDretva();
            kd.setGsv(gsv);
            kd.setArgumenti(argumenti);
            kd.start();

            do {

                //System.out.println("Vaš odabir: ");
                System.out.println(delimiter);
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
                    case "4":
                        Opcija4 op4 = new Opcija4(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op4);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;
                    case "5":
                        Opcija5 op5 = new Opcija5(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op5);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;
                    case "6":
                        Opcija6 op6 = new Opcija6(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op6);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;
                    case "7":
                        Opcija7 op7 = new Opcija7(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op7);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;
                    case "8":
                        Opcija8 op8 = new Opcija8(opcije);
                        izvrsiOpciju.uhvatiOdabranuOpciju(op8);
                        izvrsiOpciju.izvrsiOdabraneOpcije();
                        break;

                }
            } while (!odabranaOpcija.equals("Q"));
            System.exit(0);
        }
    }
}
