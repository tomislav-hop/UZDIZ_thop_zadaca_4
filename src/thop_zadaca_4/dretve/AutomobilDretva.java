/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.dretve;

import java.util.List;
import thop_zadaca_4.GeneriranjeSvihVrijednosti;
import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;

/**
 *
 * @author Tomislav
 */
public class AutomobilDretva extends Thread {

    private boolean stop = false;
    //private List<Automobil> automobil;
    private GeneriranjeSvihVrijednosti gsv;
    private List<Integer> argumenti;
    /*
     0 brojAutomobila
     1 brojZona
     2 kapacitetZone
     3 maksParkiranje
     4 vremenskaJedinica
     5 intervalDolaska
     6 intervalOdlaska
     7 cijenaJedinice
     8 intervalKontrole
     9 kaznaParkiranja 
     */

    @Override
    public void run() {
        while (true) { 
            if (!sviAutoParkirani()) {
                //System.err.println("ULAZ AUTOMOBILA ...");
                if (!ParkingApplication.zaustaviDolaskeAutomobila) {
                    ulazAutomobila();
                }
            }

            try {
                float rand1 = gsv.vrijemeRazmakaDolazaka();
                int random1 = (int) (rand1 * 1000);
                sleep(random1);
                //System.out.println("Razmak od " + rand1 + " sekundi");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void interrupt() {
        super.interrupt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    private void ulazAutomobila() {
        //prolaz po listi automobila
        for (Automobil auto : ParkingApplication.auti) {
            //ako automobil nije na parkiralistu on pokusava uc na njega
            if (auto.isNaParkiralistu() == false) {
                //auto odabire zonu
                //TODO Odabiremo zonu na normalan nacin ne po formuli
                int odabranaZona = gsv.random_broj(1, argumenti.get(1));
                //System.out.println("Auto " + auto.getAutomobilID() + " ulazi na parkiraliste... i odabire zonu broj: " + odabranaZona);

                //ako je kapacitet zone veći od popunjenosti još ima mjesta za auto u zoni
                int kapacitetZone = ParkingApplication.zone.get(odabranaZona - 1).getKapacitetZone();
                int popunjenostZone = ParkingApplication.zone.get(odabranaZona - 1).getPopunjenostZone();
                if (kapacitetZone > popunjenostZone) {
                    //System.out.println("Zona nije puna!");

                    //postavljanje da je auto parkiran, postavljanje njegove zone i cijene koju plaća, te kada je parkiran
                    auto.setNaParkiralistu(true);
                    //auto.setZonaUKojojSeNalazi(odabranaZona);
                    auto.setCijenaKojuPlaca(ParkingApplication.zone.get(odabranaZona - 1).getCijenaParkiranjaUZoni());
                    auto.setMaxProduzenjaZone(ParkingApplication.zone.get(odabranaZona-1).getMaksimalniBrojProduljenja());

                    int naKolikoSeDugoParkira = (argumenti.get(1) + 1 - odabranaZona) * argumenti.get(7);
                    auto.setNaKolikoSeParkira(naKolikoSeDugoParkira);

                    //povećavanja brojaca auta u ozni
                    ParkingApplication.zone.get(odabranaZona - 1).dodajAutoUZonu();
                    auto.setZona(ParkingApplication.zone.get(odabranaZona-1));
                    
                    //povecavanje zarade zone
                    ParkingApplication.zone.get(odabranaZona-1).dodajparkiranje(naKolikoSeDugoParkira);

                    //spremanje ulaza auta u dnevnik
                    PodaciOAutomobilima poa = new PodaciOAutomobilima(auto, auto.getZona().getBrojZone(), auto.getCijenaKojuPlaca(), "Dolazak automobila", "A");
                    poa.ispisZapisaDnevnika();
                    ParkingApplication.dnevnik.add(poa);

                    //izlaz iz funkcije
                    return;

                } else {
                    //ukoliko je zona puna ništa se ne događa i auto samo izlazi sa parkirališta
                    //System.out.println("Zona je puna te auto izlazi iz parkirališta!");
                    PodaciOAutomobilima poa = new PodaciOAutomobilima(auto, odabranaZona, 0, "Izlaz(ZONA JE PUNA)", "A");
                    poa.ispisZapisaDnevnika();
                    ParkingApplication.dnevnik.add(poa);

                    //budući da auto nije ušao stavljam ga na kraj liste kako bi opet pokušao nakon svih automobila
                    ParkingApplication.auti.remove(auto);
                    ParkingApplication.auti.add(auto);

                    return;
                }
            } else {
                //System.out.println("Auto vec je na parkiralistu!");
            }
        }
    }

    private boolean sviAutoParkirani() {
        for (Automobil auto : ParkingApplication.auti) {
            if (auto.isNaParkiralistu() == false) {
                return false;
            }
        }
        return true;
    }

    public void setGsv(GeneriranjeSvihVrijednosti gsv) {
        this.gsv = gsv;
    }

    public void setArgumenti(List<Integer> argumenti) {
        this.argumenti = argumenti;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

}
