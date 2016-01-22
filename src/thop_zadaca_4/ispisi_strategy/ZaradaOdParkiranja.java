/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.ispisi_strategy;

import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.ispisi_zona_iterator.Container;
import thop_zadaca_4.ispisi_zona_iterator.Iterator;
import thop_zadaca_4.podaci.Zona;

/**
 *
 * @author Tomislav
 */
public class ZaradaOdParkiranja implements Ispis, Container {

    @Override
    public void ispisiOpciju() {
        System.out.println("Zarada po zonama -  parkiranje");
        for (Iterator iter = new ZaradaOdParkiranja.ZonaIterator(); iter.hasNext();) {
            Zona zona = (Zona) iter.next();
            System.out.println("Zona broj " + zona.getBrojZone() + "\tZarada: " + zona.getZaradaPoParkiranju());
        }
    }

    @Override
    public Iterator getIterator() {
        return new ZonaIterator();
    }

    private class ZonaIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < ParkingApplication.zone.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return ParkingApplication.zone.get(index++);
            }
            return null;
        }
    }
}
