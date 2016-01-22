/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.dretve;

import java.util.Date;
import java.util.List;
import thop_zadaca_4.GeneriranjeSvihVrijednosti;
import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.podaci.Automobil;

/**
 *
 * @author Tomislav
 */
public class KontolorDretva extends Thread {

    private GeneriranjeSvihVrijednosti gsv;
    private List<Integer> argumenti;

    @Override
    public void interrupt() {
        super.interrupt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        while (true) {
            try {
                float rand1 = gsv.vrijemeRazmakaKontrolora();
                int random1 = (int) (rand1 * 1000);              
                sleep(random1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            }
            dolazakKontrolora();
        }
    }

    private void dolazakKontrolora() {
        if (baremJedanAutoParkiran()) {
            for (Automobil auto : ParkingApplication.auti) {

                if (auto.isNaParkiralistu()) {
                    if(true){}
                }
            }
        }

    }
    
    private boolean provjeraParkiranja(Date kadaJeParkiran, int naKolikoJeParkiran)
    {
        return false;
    }

    private boolean baremJedanAutoParkiran() {
        for (Automobil auto : ParkingApplication.auti) {
            if (auto.isNaParkiralistu() == true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setGsv(GeneriranjeSvihVrijednosti gsv) {
        this.gsv = gsv;
    }

    public void setArgumenti(List<Integer> argumenti) {
        this.argumenti = argumenti;
    }
}
