/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.izbornik_command;

import java.util.Scanner;

/**
 *
 * @author Tomislav
 */
public class IspisIzbornika {

    Scanner unos = new Scanner(System.in);

    public void ispisiIzbornik() {
        String izbornik = "1\tZatvaranje parkirališta za nove ulaze automobila\n"
                + "2\tOtvaranje parkirališta za nove ulaze automobila\n"
                + "3\tIspis zarada od parkiranja po zonama\n"
                + "4\tIspis zarada od kazni po zonama\n"
                + "5\tIspis broja automobila koji nisu mogli parkirati po zonama\n"
                + "6\tIspis broja automobila koji je pauk odveo na deponij po zonama\n"
                + "7\tIspis 5 automobila s najviše parkiranja\n"
                + "8\tStanje parkirnih mjesta po zonama (% zauzetih)\n"
                + "Q\tPrekid rada programa.";
        System.out.println(izbornik);
    }

    public String odabranaOpcija() {
        String izbor = unos.nextLine();
        return izbor;
    }

}
