/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.podaci;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tomislav
 */
public class PodaciOAutomobilima {

    //DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS dd.MM.yyyy");
    private String tip;
    private Automobil auto;
    private Timestamp vrijeme;
    private int zona;
    private int iznos;
    private String status;

    public PodaciOAutomobilima(Automobil auto, int zona, int iznos, Timestamp vrijeme, String status, String tip) {
        this.auto = auto;
        this.vrijeme = vrijeme;
        this.tip = tip;
        this.zona = zona;
        this.iznos = iznos;
        this.status = status;
    }

    /*public void datumIVrijeme(long vrijemeDolaska) {
     Timestamp vrijemeDolaskaTimestamp = new Timestamp(vrijemeDolaska);
     //Date date = new Date();
     this.vrijeme = vrijemeDolaskaTimestamp;
     }*/
    public void ispisZapisaDnevnika() {
        //+ "\tParking na: " + auto.getNaKolikoSeParkira() + " sec"
        if (auto.getZona() != null) {
            System.out.println(tip + "\tAuto ID: " + auto.getAutomobilID() + "\tVrijeme: " + vrijeme + "\tVrijeme: " + auto.getVrijemeParkiranja() + "\tZona: " + auto.getZona().getBrojZone() + "\t\tStatus: " + status);
        } else {
            System.out.println(tip + "\tAuto ID: " + auto.getAutomobilID() + "\tVrijeme: " + vrijeme + "\tZona: nema" + "\t\tStatus: " + status);
        }
    }

    public Automobil getAuto() {
        return auto;
    }

    public void setAuto(Automobil auto) {
        this.auto = auto;
    }

    public Timestamp getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Timestamp vrijeme) {
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
