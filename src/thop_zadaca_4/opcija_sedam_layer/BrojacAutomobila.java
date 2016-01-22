/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.opcija_sedam_layer;

import java.util.ArrayList;
import java.util.List;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;

/**
 * Sloj koji broji koliko se puta koji automobil pojavio u dnevniku i povecava
 * brojac parkiranja za taj automobil
 *
 * @author Tomislav
 */
public class BrojacAutomobila implements KomunikacijaSlojeva {

    @Override
    public Object izvrsiSvojuMetodu(List<PodaciOAutomobilima> dnevnik, List<Automobil> auti) {
        for (PodaciOAutomobilima poa : dnevnik) {
            if (poa.getStatus().equals("Dolazak automobila")) {
                try {
                    auti.get(poa.getAuto().getAutomobilID() - 1).povecajBrojParkiranja();
                } catch (Exception e) {
                    
                }

            }
        }
        return auti;
    }

}
