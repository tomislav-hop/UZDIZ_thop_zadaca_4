/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.opcija_sedam_layer;

import java.util.Comparator;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.SimpleAuto;

/**
 * Komparator koji koristim kako bi sortirao jednostavnu listu po broju
 * parkiranja
 *
 * @author Tomislav
 */
public class ObjectComparator implements Comparator<SimpleAuto> {

    @Override
    public int compare(SimpleAuto o1, SimpleAuto o2) {
        if (o1.getBrojParkiranja() <= o2.getBrojParkiranja()) {
            return 1;
        } else {
            return -1;
        }
    }

}
