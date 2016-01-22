/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.ispisi_strategy;

import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.podaci.PodaciOAutomobilima;
import thop_zadaca_4.podaci.Zona;

/**
 *
 * @author Tomislav
 */
public class AutomobiliKojiNisuParkirali implements Ispis {

    @Override
    public void ispisiOpciju() {
        System.out.println("Automobili koji nisu mogli parkirati po zonama");
        //int brojacAutomobila;
        for (Zona zona : ParkingApplication.zone) {
            System.out.println("Broj automobila: " + zona.getBrojacOdbijenihAutomobila());
        }
    }

}
