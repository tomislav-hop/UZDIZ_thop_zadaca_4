/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.ispisi_strategy;

import java.util.ArrayList;
import java.util.List;
import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;

/**
 *
 * @author Tomislav
 */
public class PetAutomobilaParkiranja implements Ispis{

    @Override
    public void ispisiOpciju() {
        List<PodaciOAutomobilima> pomocniDnevnik = new ArrayList<>();
        pomocniDnevnik = ParkingApplication.dnevnik;
        
        List<Automobil> prvihPet = new ArrayList<>();
        
        System.out.println("KASNIJE");
    }
    
}
