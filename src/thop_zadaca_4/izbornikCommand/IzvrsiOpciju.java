/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.izbornikCommand;

import java.util.ArrayList;
import java.util.List;
import thop_zadaca_4.dretve.AutomobilDretva;

/**
 * Klasa koja prima zahtjeve te ih izvršava pozivima metoda
 *
 * @author Tomislav
 */
public class IzvrsiOpciju {

    private List<OdaberiOpciju> listaOdabranihOpcija = new ArrayList<>();

    public void uhvatiOdabranuOpciju(OdaberiOpciju odabranaOpcija) {
        listaOdabranihOpcija.add(odabranaOpcija);
    }

    public void izvrsiOdabraneOpcije() {
        for (OdaberiOpciju odabranaOpcija : listaOdabranihOpcija) {
            odabranaOpcija.odaberi();
        }
        listaOdabranihOpcija.clear();
    }
}
