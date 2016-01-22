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
public class ZaradaOdParkiranja implements Ispis{

    @Override
    public void ispisiOpciju() {
        System.out.println("Zarada po zonama -  parkiranje");
        for(Zona zona: ParkingApplication.zone){
            System.out.println("Zona broj " + zona.getBrojZone() + "\tZarada: " + zona.getZaradaPoParkiranju());
        }
    }
    
}
