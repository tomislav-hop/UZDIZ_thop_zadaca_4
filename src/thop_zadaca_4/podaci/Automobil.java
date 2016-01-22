/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.podaci;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Tomislav
 */
public class Automobil {

    private int automobilID;
    private Zona zona;
    private boolean naParkiralistu;
    private int cijenaKojuPlaca;
    private Timestamp vrijemeParkiranja;
    private int naKolikoSeParkira;
    private int brojProduljenja;
    private int brojParkiranja;

    public Automobil(int automobilID) {
        this.automobilID = automobilID;
        naParkiralistu = false;
        brojProduljenja = 0;
        brojParkiranja = 0;
    }

    public void povecajBrojParkiranja() {
        brojParkiranja++;
    }

    public boolean produljiParkiranje() {
        if (brojProduljenja <= zona.getMaksimalniBrojProduljenja()) {
            brojProduljenja++;
            return true;
        }
        return false;
    }

    public int getAutomobilID() {
        return automobilID;
    }

    public void setAutomobilID(int automobilID) {
        this.automobilID = automobilID;
    }

    /*public int getZonaUKojojSeNalazi() {
     return zonaUKojojSeNalazi;
     }

     public void setZonaUKojojSeNalazi(int zonaUKojojSeNalazi) {
     this.zonaUKojojSeNalazi = zonaUKojojSeNalazi;
     }*/
    public boolean isNaParkiralistu() {
        return naParkiralistu;
    }

    public void setNaParkiralistu(boolean naParkiralistu) {
        //System.err.println("Parkiranje: " + naParkiralistu + "\tID: " + this.automobilID);
        this.naParkiralistu = naParkiralistu;
    }

    public int getCijenaKojuPlaca() {
        return cijenaKojuPlaca;
    }

    public void setCijenaKojuPlaca(int cijenaKojuPlaca) {
        this.cijenaKojuPlaca = cijenaKojuPlaca;
    }

    public Timestamp getVrijemeParkiranja() {
        return vrijemeParkiranja;
    }

    public void setVrijemeParkiranja(Timestamp vrijemeParkiranja) {
        this.vrijemeParkiranja = vrijemeParkiranja;
    }

    public int getNaKolikoSeParkira() {
        return naKolikoSeParkira;
    }

    public void setNaKolikoSeParkira(int naKolikoSeParkira) {
        this.naKolikoSeParkira = naKolikoSeParkira;
    }

    public int getBrojProduljenja() {
        return brojProduljenja;
    }

    public void setBrojProduljenja(int brojProduljenja) {
        this.brojProduljenja = brojProduljenja;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public int getBrojParkiranja() {
        return brojParkiranja;
    }

}
