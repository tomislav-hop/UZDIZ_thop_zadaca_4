/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.izbornik;

import java.util.List;
import thop_zadaca_4.dretve.AutomobilDretva;

/**
 *
 * @author Tomislav
 */
public class Opcija3 implements OdaberiOpciju {

    private Opcije izvrsiOpciju;

    public Opcija3(Opcije izvrsiOpciju) {
        this.izvrsiOpciju = izvrsiOpciju;
    }

    @Override
    public void odaberi() {
        izvrsiOpciju.opcija3();
    }

}
