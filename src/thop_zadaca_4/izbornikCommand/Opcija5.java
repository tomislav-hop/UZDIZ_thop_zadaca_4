/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.izbornikCommand;

/**
 *
 * @author Tomislav
 */
public class Opcija5 implements OdaberiOpciju{
    
    private Opcije izvrsiOpciju;

    public Opcija5(Opcije izvrsiOpciju) {
        this.izvrsiOpciju = izvrsiOpciju;
    }

    @Override
    public void odaberi() {
        izvrsiOpciju.opcija5();
    }
    
}