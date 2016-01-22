/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.izbornikCommand;

import java.util.List;
import thop_zadaca_4.aplikacija.ParkingApplication;
import static thop_zadaca_4.aplikacija.ParkingApplication.delimiter;
import thop_zadaca_4.dretve.AutomobilDretva;
import thop_zadaca_4.ispisi_strategy.OdabirIspisa;
import thop_zadaca_4.ispisi_strategy.PrviIspis;

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
        System.out.println(delimiter);

    }

    public void opcija2() {
        System.out.println(delimiter);
        System.out.println("Opcija 2\nParkiralište otvoreno za nove ulaze automobila");
        ParkingApplication.zaustaviDolaskeAutomobila = false;
        System.out.println(delimiter);
    }

    public void opcija3() {
        System.out.println(delimiter);
        System.out.println("Opcija 3");
        
        OdabirIspisa oi = new OdabirIspisa(new PrviIspis());
        oi.izvediIspis();
        
        System.out.println(delimiter);
    }

}
