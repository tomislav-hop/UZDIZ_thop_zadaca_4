/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.aplikacija;

/**
 * Provjera svih argumenata koji se prosljeđuju aplikaciji
 *
 * @author Tomislav
 */
public class ProvjeraArgumenata {

    public boolean provjera(String[] args) {
        if (args.length < 10) {
            System.out.println("GRESKA KOD POKRETANJA: Nedovoljno parametara");
            return false;
        } else {
            for (int i = 0; i < 10; i++) {
                if (args[i] == null) {
                    System.out.println("GRESKA KOD POKRETANJA: " + i + "-ti parametar nema vrijednost");
                    return false;
                }
            }

            int brojAutomobila = 0, brojZona = 0, kapacitetZone = 0, maksParkiranje = 0, vremenskaJedinica = 0, intervalDolaska = 0, intervalOdlaska = 0, cijenaJedinice = 0, intervalKontrole = 0, kaznaParkiranja = 0;

            try {
                brojAutomobila = Integer.parseInt(args[0]);
                brojZona = Integer.parseInt(args[1]);
                kapacitetZone = Integer.parseInt(args[2]);
                maksParkiranje = Integer.parseInt(args[3]);
                vremenskaJedinica = Integer.parseInt(args[4]);
                intervalDolaska = Integer.parseInt(args[5]);
                intervalOdlaska = Integer.parseInt(args[6]);
                cijenaJedinice = Integer.parseInt(args[7]);
                intervalKontrole = Integer.parseInt(args[8]);
                kaznaParkiranja = Integer.parseInt(args[9]);
            } catch (Exception e) {
                System.out.println("GRESKA KOD POKRETANJA: Jedan od parametara nije broj");
                return false;
            }

            if (brojAutomobila < 10 || brojAutomobila > 100) {
                System.out.println("GRESKA KOD POKRETANJA: 'brojAutomobila' treba biti između 10 i 100");
                return false;
            }
            if (brojZona < 1 || brojZona > 4) {
                System.out.println("GRESKA KOD POKRETANJA: 'brojZona' treba biti između 1 i 4");
                return false;
            }
            if (kapacitetZone < 1 || kapacitetZone > 100) {
                System.out.println("GRESKA KOD POKRETANJA: 'kapacitetZone' treba biti između 1 i 100");
                return false;
            }
            if (maksParkiranje < 1 || maksParkiranje > 10) {
                System.out.println("GRESKA KOD POKRETANJA: 'maksParkiranje' treba biti između 1 i 10");
                return false;
            }
            if (vremenskaJedinica < 1 || vremenskaJedinica > 10) {
                System.out.println("GRESKA KOD POKRETANJA: 'vremenskaJedinica' treba biti između 1 i 10");
                return false;
            }
            if (intervalDolaska < 1 || intervalDolaska > 10) {
                System.out.println("GRESKA KOD POKRETANJA: 'intervalDolaska' treba biti između 1 i 10");
                return false;
            }
            if (intervalOdlaska < 1 || intervalOdlaska > 10) {
                System.out.println("GRESKA KOD POKRETANJA: 'intervalOdlaska' treba biti između 1 i 10");
                return false;
            }
            if (cijenaJedinice < 1 || cijenaJedinice > 10) {
                System.out.println("GRESKA KOD POKRETANJA: 'cijenaJedinice' treba biti između 1 i 10");
                return false;
            }
            if (intervalKontrole < 1 || intervalKontrole > 10) {
                System.out.println("GRESKA KOD POKRETANJA: 'intervalKontrole' treba biti između 1 i 10");
                return false;
            }
            if (kaznaParkiranja < 10 || kaznaParkiranja > 100) {
                System.out.println("GRESKA KOD POKRETANJA: 'kaznaParkiranja' treba biti između 10 i 100");
                return false;
            }
        }

        return true;
    }

}
