/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.layer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;

/**
 *
 * @author Tomislav
 */
public class IspisAutomobila implements KomunikacijaSlojeva{

    @Override
    public Object izvrsiSvojuMetodu(List<PodaciOAutomobilima> dnevnik, List<Automobil> auti) {
        List<Automobil> listaPobrojanih = new ArrayList<>();
        int i = 1;
        for(Automobil auto : auti)
        {
            System.out.println("Auto ID: " + i + "\tBrojac parkiranja: " + auto.getBrojParkiranja());
            Automobil dodajAuto = new Automobil(i);
            dodajAuto.setBrojProduljenja(auto.getBrojParkiranja());
            listaPobrojanih.add(dodajAuto);
            i++;
        }
        
        Collections.sort(listaPobrojanih, new Comparator<Automobil>(){
        @Override
        public int compare(Automobil auto1, Automobil auto2)
        {
            return auto1.getBrojProduljenja() - auto2.getBrojProduljenja();
        }
        });
        
        
        return listaPobrojanih;
    }
    
}
