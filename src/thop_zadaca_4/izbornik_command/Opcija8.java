/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.izbornik_command;

/**
 *
 * @author Tomislav
 */
public class Opcija8 implements OdaberiOpciju{
    
    private Opcije izvrsiOpciju;

    public Opcija8(Opcije izvrsiOpciju) {
        this.izvrsiOpciju = izvrsiOpciju;
    }

    @Override
    public void odaberi() {
        izvrsiOpciju.opcija8();
    }
    
}
