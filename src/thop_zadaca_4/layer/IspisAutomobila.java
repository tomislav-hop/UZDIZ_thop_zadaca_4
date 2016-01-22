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
import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;
import thop_zadaca_4.podaci.SimpleAuto;

/**
 * Layer koji uzima listu automobila prebacuje ju u jednostavnu listu, sortira ju te ispisuje
 * @author Tomislav
 */
public class IspisAutomobila implements KomunikacijaSlojeva {

    @Override
    public Object izvrsiSvojuMetodu(List<PodaciOAutomobilima> dnevnik, List<Automobil> auti) {
        List<SimpleAuto> jednostavnaLista = new ArrayList<>();

        int i = 1;
        for (Automobil auto : auti) {
            jednostavnaLista.add(new SimpleAuto(i, auto.getBrojParkiranja()));
            i++;
        }

        System.out.println(ParkingApplication.delimiter);
        ObjectComparator oc = new ObjectComparator();
        Collections.sort(jednostavnaLista, oc);

        System.out.println("Pet najboljih automobila po parkiranjima");
        int j = 1;
        for (SimpleAuto auto : jednostavnaLista) {
            System.out.println(j + ". Mjesto: Auto ID: " + auto.getIdAuto() + "\tBroj parkiranja: " + auto.getBrojParkiranja());
            j++;
            if (j == 6) {
                break;
            }
        }
        return null;
    }

}
