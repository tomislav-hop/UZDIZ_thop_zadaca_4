/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.ispisi_strategy;

import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.podaci.Zona;

/**
 *
 * @author Tomislav
 */
public class StanjeZona implements Ispis {

    @Override
    public void ispisiOpciju() {
        System.out.println("Stanje parkirnih mjesta po zonama");
        for (Zona zona : ParkingApplication.zone) {
            float postotak = ((float) zona.getPopunjenostZone() / (float) zona.getKapacitetZone())*100;
            System.out.println("Zona broj " + zona.getBrojZone() + "\t" + zona.getPopunjenostZone() + " / " + zona.getKapacitetZone() + " = " + postotak + " %");
        }
    }

}
