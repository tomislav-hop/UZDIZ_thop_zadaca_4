/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.podaci;

/**
 * Klasa korištena za sortiranje liste po broju parkiranja pomoću Comparator-a
 *
 * @author Tomislav
 */
public class SimpleAuto {

    private int idAuto;
    private int brojParkiranja;

    public SimpleAuto(int idAuto, int brojParkiranja) {
        this.idAuto = idAuto;
        this.brojParkiranja = brojParkiranja;
    }

    public int getBrojParkiranja() {
        return brojParkiranja;
    }

    public void setBrojParkiranja(int brojParkiranja) {
        this.brojParkiranja = brojParkiranja;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

}
