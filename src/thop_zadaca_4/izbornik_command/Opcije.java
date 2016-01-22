/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.izbornik_command;

import java.util.List;
import thop_zadaca_4.aplikacija.ParkingApplication;
import static thop_zadaca_4.aplikacija.ParkingApplication.delimiter;
import thop_zadaca_4.dretve.AutomobilDretva;
import thop_zadaca_4.ispisi_strategy.AutomobiliKojiNisuParkirali;
import thop_zadaca_4.ispisi_strategy.IspisDeponiji;
import thop_zadaca_4.ispisi_strategy.ZaradaOdKazni;
import thop_zadaca_4.ispisi_strategy.OdabirIspisa;
import thop_zadaca_4.ispisi_strategy.PetAutomobilaParkiranja;
import thop_zadaca_4.ispisi_strategy.StanjeZona;
import thop_zadaca_4.ispisi_strategy.ZaradaOdParkiranja;

/**
 * Klasa koja obrađuje zahtjeve
 *
 * @author Tomislav
 */
public class Opcije {

    public void opcija1() {
        System.out.println(delimiter);
        System.out.println("Opcija 1\nParkiralište zatvoreno za nove ulaze automobila");
        ParkingApplication.zaustaviDolaskeAutomobila = true;

    }

    public void opcija2() {
        System.out.println(delimiter);
        System.out.println("Opcija 2\nParkiralište otvoreno za nove ulaze automobila");
        ParkingApplication.zaustaviDolaskeAutomobila = false;
    }

    public void opcija3() {
        System.out.println(delimiter);
        System.out.println("Opcija 3");
        OdabirIspisa oi = new OdabirIspisa(new ZaradaOdParkiranja());
        oi.izvediIspis();
    }

    public void opcija4() {
        System.out.println(delimiter);
        System.out.println("Opcija 4");
        OdabirIspisa oi = new OdabirIspisa(new ZaradaOdKazni());
        oi.izvediIspis();
    }

    public void opcija5() {
        System.out.println(delimiter);
        System.out.println("Opcija 5");
        OdabirIspisa oi = new OdabirIspisa(new AutomobiliKojiNisuParkirali());
        oi.izvediIspis();
    }

    public void opcija6() {
        System.out.println(delimiter);
        System.out.println("Opcija 6");
        OdabirIspisa oi = new OdabirIspisa(new IspisDeponiji());
        oi.izvediIspis();

        System.out.println(delimiter);
    }

    public void opcija7() {
        System.out.println(delimiter);
        System.out.println("Opcija 7");
        OdabirIspisa oi = new OdabirIspisa(new PetAutomobilaParkiranja());
        oi.izvediIspis();
    }

    public void opcija8() {
        System.out.println(delimiter);
        System.out.println("Opcija 8");
        OdabirIspisa oi = new OdabirIspisa(new StanjeZona());
        oi.izvediIspis();
    }

    public void opcijaQ() {
        System.out.println(delimiter);
        System.out.println("Prekid rada programa");
    }

}
