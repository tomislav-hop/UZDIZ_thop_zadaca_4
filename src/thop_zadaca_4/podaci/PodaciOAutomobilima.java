/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.podaci;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tomislav
 */
public class PodaciOAutomobilima {

    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS dd.MM.yyyy");
    private String tip;
    private Automobil auto;
    private String vrijeme;
    private int zona;
    private int iznos;
    private String status;

    public PodaciOAutomobilima(Automobil auto, int zona, int iznos, String status, String tip) {
        this.auto = auto;
        this.vrijeme = datumIVrijeme();
        this.tip = tip;
        this.zona = zona;
        this.iznos = iznos;
        this.status = status;
    }

    public String datumIVrijeme() {

        Date date = new Date();
        return dateFormat.format(date);
    }

    public void ispisZapisaDnevnika() {
        //+ "\tParking na: " + auto.getNaKolikoSeParkira() + " sec"
        if (auto.getZona() != null) {
            System.out.println(tip + "\tAuto ID: " + auto.getAutomobilID() + "\tVrijeme: " + vrijeme + "    Zona: " + auto.getZona().getBrojZone() + "\tStatus: " + status);
        }
        else{System.out.println(tip + "\tAuto ID: " + auto.getAutomobilID() + "\tVrijeme: " + vrijeme + "    Zona: null" + "\tStatus: " + status);}
    }

    public Automobil getAuto() {
        return auto;
    }

    public void setAuto(Automobil auto) {
        this.auto = auto;
    }

    public String getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
