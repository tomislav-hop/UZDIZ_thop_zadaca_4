/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.podaci;

import java.util.Date;

/**
 *
 * @author Tomislav
 */
public class Automobil {

  
    private int automobilID;
    //private int zonaUKojojSeNalazi;
    private int maxProduzenjaZone;
    
    private Zona zona;
    
    private boolean naParkiralistu;
    private int cijenaKojuPlaca;
    private Date vrijemeParkiranja;
    private int naKolikoSeParkira;
    private int brojProduljenja;
    
      public Automobil(int automobilID) {
        this.automobilID = automobilID;
        naParkiralistu = false;
        brojProduljenja = 0;
    }
      
    public boolean produljiParkiranje()
    {
        if(brojProduljenja <= maxProduzenjaZone)
        {
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
        this.naParkiralistu = naParkiralistu;
    }

    public int getCijenaKojuPlaca() {
        return cijenaKojuPlaca;
    }

    public void setCijenaKojuPlaca(int cijenaKojuPlaca) {
        this.cijenaKojuPlaca = cijenaKojuPlaca;
    }

    public Date getVrijemeParkiranja() {
        return vrijemeParkiranja;
    }

    public void setVrijemeParkiranja(Date vrijemeParkiranja) {
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

    public int getMaxProduzenjaZone() {
        return maxProduzenjaZone;
    }

    public void setMaxProduzenjaZone(int maxProduzenjaZone) {
        this.maxProduzenjaZone = maxProduzenjaZone;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }


    
}