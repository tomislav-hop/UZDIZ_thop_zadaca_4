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
public class VlasnikDretva extends Thread {

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
            try {
                float rand1 = gsv.vrijemeRazmakaOdlazaka();
                int random1 = (int) (rand1 * 1000);
                sleep(random1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }
            dolazakVlasnika();
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

    private void dolazakVlasnika() {
        if (baremJedanAutoParkiran()) {
            for (Automobil auto : ParkingApplication.auti) {

                if (auto.isNaParkiralistu()) {
                    int akcijaVlasnika = gsv.randomAkcijaVlasnika();    
                    //System.out.println("Odabrana akcija: " + akcijaVlasnika);
                    switch (akcijaVlasnika) {
                        case 0:
                            ParkingApplication.auti.remove(auto);
                            ParkingApplication.auti.add(auto);
                            PodaciOAutomobilima poa1 = new PodaciOAutomobilima(auto, auto.getZona().getBrojZone(), auto.getCijenaKojuPlaca(), "Ništa ne radi vlasnik", "V");
                            poa1.ispisZapisaDnevnika();
                            ParkingApplication.dnevnik.add(poa1);
                            return;
                            //break;
                        case 1:
                            ParkingApplication.auti.remove(auto);

                            PodaciOAutomobilima poa2 = new PodaciOAutomobilima(auto, auto.getZona().getBrojZone(), auto.getCijenaKojuPlaca(), "Vlasnik izlazi autom", "V");
                            poa2.ispisZapisaDnevnika();
                            ParkingApplication.dnevnik.add(poa2);

                            auto.setNaParkiralistu(false);
                            auto.setBrojProduljenja(0);
                            auto.setCijenaKojuPlaca(0);
                            auto.setVrijemeParkiranja(null);
                            //auto.setZonaUKojojSeNalazi(0);
                            auto.setZona(null);
                            ParkingApplication.auti.add(auto);
                            return;
                            //break;
                        case 2:
                            if (auto.produljiParkiranje()) {      
                                auto.setNaKolikoSeParkira(auto.getNaKolikoSeParkira()+auto.getZona().getVrijemeParkiranjaUZoni());
                                ParkingApplication.zone.get(auto.getZona().getBrojZone()-1).dodajparkiranje(1);
                                PodaciOAutomobilima poa3 = new PodaciOAutomobilima(auto, auto.getZona().getBrojZone(), auto.getCijenaKojuPlaca(), "Produljio je parkiranje", "V");
                                poa3.ispisZapisaDnevnika();
                                ParkingApplication.dnevnik.add(poa3);
                            }
                            else{
                                PodaciOAutomobilima poa3 = new PodaciOAutomobilima(auto, auto.getZona().getBrojZone(), auto.getCijenaKojuPlaca(), "Odbijeno produljenje", "V");
                                poa3.ispisZapisaDnevnika();
                                ParkingApplication.dnevnik.add(poa3);
                            }
                            return;
                            //break;
                    }
                    //break;
                }
            }
        } else {

        }
    }

    public boolean baremJedanAutoParkiran() {
        for (Automobil auto : ParkingApplication.auti) {
            if (auto.isNaParkiralistu() == true) {
                return true;
            }
        }
        return false;
    }

    public void setGsv(GeneriranjeSvihVrijednosti gsv) {
        this.gsv = gsv;
    }

    public void setArgumenti(List<Integer> argumenti) {
        this.argumenti = argumenti;
    }

}
