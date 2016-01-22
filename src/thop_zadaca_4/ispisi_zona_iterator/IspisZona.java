/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.ispisi_zona_iterator;

import java.util.ArrayList;
import java.util.List;
import thop_zadaca_4.aplikacija.ParkingApplication;
import thop_zadaca_4.podaci.Zona;

/**
 *
 * @author Tomislav
 */
public class IspisZona implements Container {

    //private List<Zona> zone = new ArrayList<>();

    /*public IspisZona(List<Zona> zone) {
        this.zone = zone;
    }*/
    
    public void ispisZona() {
        for (Iterator iter = new IspisZona.ZonaIterator(); iter.hasNext();) {
            Zona zona = (Zona) iter.next();
            zona.ispisZone();
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

   /* public List<Zona> getZone() {
        return zone;
    }

    public void setZone(List<Zona> zone) {
        this.zone = zone;
    }
*/
}
