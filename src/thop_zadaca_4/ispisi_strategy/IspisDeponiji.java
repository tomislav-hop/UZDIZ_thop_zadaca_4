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
public class IspisDeponiji implements Ispis{

    @Override
    public void ispisiOpciju() {
        System.out.println("Ispis broja automobila koje je pauk odvezao na deponij");
        for(Zona zona: ParkingApplication.zone){
            System.out.println("Zona broj " + zona.getBrojZone() + "\tBroj automobila: " + zona.getBrojacDeponij());
        }
    }
    
}
