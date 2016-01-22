/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import thop_zadaca_4.podaci.Zona;

/**
 *
 * @author Tomislav
 */
public class GeneriranjeSvihVrijednosti {
    /*
     0 brojAutomobila
     1 brojZona
     2 kapacitetZone
     3 maksParkiranje
     4 vremenskaJedinica
     5 intervalDolaska
     6 intervalOdlaska
     7 cijenaJedinice
     8 intervalKontrole
     9 kaznaParkiranja 
     */

    List<Integer> argumenti;

    public GeneriranjeSvihVrijednosti(List<Integer> argumenti) {
        this.argumenti = argumenti;
    }

    public int random_broj(int min, int max) {
        Random rand = new Random();

        int randB = rand.nextInt((max - min) + 1) + min;

        return randB;
    }

    public List<Zona> generirajZone() {
        List<Zona> zone = new ArrayList<>();
        for (int i = 1; i <= argumenti.get(1); i++) {
            zone.add(new Zona(i, argumenti.get(2), argumenti.get(3), argumenti.get(4), argumenti.get(1), argumenti.get(7)));
        }
        return zone;
    }

    public float vrijemeRazmakaDolazaka() {
        int generiranaVrijednost1 = random_broj(0, 1000);
        float vrijemeRazmakaAutomobila = (((float) argumenti.get(4) / (float) argumenti.get(5)) * (float) generiranaVrijednost1) / 1000;
        return vrijemeRazmakaAutomobila;
    }

    public int odabirZone() {
        int odabranaZona = -1;
        int brojZona = argumenti.get(1);
        float generiranaVrijednost2 = random_broj(0, 1000) / 1000;

        //Automobil odabire zonu na temelju formule (brojZona * generiranaVrijednost2) tako da sve zone imaju istu vjerojatnost odabira.
        //izracun po formuli
        float formula = brojZona * generiranaVrijednost2;

        //odabir random zone
        float randomZona = random_broj(1, brojZona);
        System.err.println("WAT: " + randomZona);
        float randomZona2 = (float)randomZona * (float)generiranaVrijednost2;
        System.err.println("WAT2: " + randomZona2);
        //ako je provjera u kojem je intervalu generirana random zona
        for (int i = 0; i < brojZona; i++) {
            if (randomZona > i * generiranaVrijednost2 && randomZona < (i + 1) * generiranaVrijednost2) {
                return i + 1;
            }
        }
        return odabranaZona;
    }

    public float vrijemeRazmakaOdlazaka() {
        int generiranaVrijednost3 = random_broj(0, 1000);
        float vrijemeRazmakaAutomobila = (((float) argumenti.get(4) / (float) argumenti.get(6)) * (float) generiranaVrijednost3) / 1000;
        return vrijemeRazmakaAutomobila;
    }

    public int randomAkcijaVlasnika() {
        int akcija = -1;
        float generiranaVrijednost4 = (float) random_broj(0, 1000) / 1000;

        if (generiranaVrijednost4 >= 0 && generiranaVrijednost4 < 0.25) {
            return 0;
        } else if (generiranaVrijednost4 >= 0.25 && generiranaVrijednost4 <= 0.75) {
            return 1;
        } else if (generiranaVrijednost4 > 0.75 && generiranaVrijednost4 <= 1) {
            return 2;
        }
        return akcija;
    }
    
    public float vrijemeRazmakaKontrolora()
    {
        float vrijemeRazmakaKontrolora = (float)argumenti.get(4)/(float)argumenti.get(8);
        return vrijemeRazmakaKontrolora;
    }

}
