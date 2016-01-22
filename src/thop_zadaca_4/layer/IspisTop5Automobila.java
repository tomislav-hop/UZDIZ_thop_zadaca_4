/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.layer;

import java.util.List;
import thop_zadaca_4.podaci.Automobil;
import thop_zadaca_4.podaci.PodaciOAutomobilima;

/**
 * Prvi layer koji poziva sve ostale layere
 * @author Tomislav
 */
public class IspisTop5Automobila {

    private List<PodaciOAutomobilima> dnevnikPomocni;
    private List<Automobil> listaAuta;
    private KomunikacijaSlojeva layerInterface;

    public IspisTop5Automobila(List<PodaciOAutomobilima> dnevnik, List<Automobil> auti) {
        this.dnevnikPomocni = dnevnik;
        this.listaAuta = auti;
    }

    public void dohvatiAutomobileSve() {
        this.layerInterface = new DohvacanjeAutomobila();
        this.listaAuta = (List<Automobil>)this.layerInterface.izvrsiSvojuMetodu(dnevnikPomocni, listaAuta);
    }
    
    public void zbrojiDolaskeAutomobila()
    {
        this.layerInterface = new BrojacAutomobila();
        this.listaAuta = (List<Automobil>)this.layerInterface.izvrsiSvojuMetodu(dnevnikPomocni, listaAuta);
    }
    
    public void ispisiAutomobile()
    {
        this.layerInterface = new IspisAutomobila();
        this.layerInterface.izvrsiSvojuMetodu(dnevnikPomocni, listaAuta);
    }

}
