/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.layer;

import java.util.ArrayList;
import java.util.List;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;

/**
 *
 * @author Tomislav
 */
public class DohvacanjeAutomobila implements KomunikacijaSlojeva {

    private KomunikacijaSlojeva layerInterface;

    @Override
    public Object izvrsiSvojuMetodu(List<PodaciOAutomobilima> dnevnik, List<Automobil> auti) {
        //System.out.println("Dohvaćanje automobila");
        
        List<Automobil> listaAutomobila = new ArrayList<>();
        
        for(Automobil auto : auti)
        {
            listaAutomobila.add(new Automobil(auto.getAutomobilID()));
        }
        
        
        return listaAutomobila;
    }
}
