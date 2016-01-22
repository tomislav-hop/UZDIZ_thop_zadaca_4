/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.ispisi_strategy;

/**
 *
 * @author Tomislav
 */
public class OdabirIspisa {
    private Ispis ispis;

    public OdabirIspisa(Ispis ispis) {
        this.ispis = ispis;
    }
    
    public void izvediIspis()
    {
        ispis.ispisiOpciju();
    }
}
