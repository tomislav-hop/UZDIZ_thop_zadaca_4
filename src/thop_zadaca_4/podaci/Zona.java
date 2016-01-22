/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thop_zadaca_4.podaci;

/**
 *
 * @author Tomislav
 */
public class Zona {

    private int brojZone;
    private int kapacitetZone;
    private int vrijemeParkiranjaUZoni;
    private int cijenaParkiranjaUZoni;
    private int popunjenostZone;
    private int maksimalniBrojProduljenja;
    private int zaradaPoParkiranju;
    private int zaradaPoKaznama;

    public Zona(int brojZone, int kapacitetZone, int maksParkiranje, int vremenskaJedinica, int brojZona, int cijenaJedinice) {
        this.brojZone = brojZone;
        this.kapacitetZone = brojZone * kapacitetZone;
        this.vrijemeParkiranjaUZoni = brojZone * maksParkiranje * vremenskaJedinica;
        this.cijenaParkiranjaUZoni = (brojZona + 1 - brojZone) * cijenaJedinice;
        this.maksimalniBrojProduljenja = brojZone - 1;
        this.popunjenostZone = 0;
        this.zaradaPoParkiranju = 0;
        this.zaradaPoKaznama = 0;
    }

    public void dodajAutoUZonu() {
        popunjenostZone++;
        //System.out.println("Popunjenost zone je: " + popunjenostZone);
    }

    public void ukloniAutoIzZone() {
        if (popunjenostZone > 0) {
            popunjenostZone--;
        } else {
            System.err.println("Zona je prazna");
        }
    }

    public void dodajparkiranje(int vrijemeParkiranja) {
        if (vrijemeParkiranja == -1) {
            zaradaPoParkiranju += cijenaParkiranjaUZoni;
        } else {
            int zarada = (vrijemeParkiranja/vrijemeParkiranjaUZoni)*cijenaParkiranjaUZoni;
            zaradaPoParkiranju += zarada;
        }
    }

    public void dodajKaznu(int kazna) {
        zaradaPoKaznama += kazna;
    }

    public void ispisZone() {
        System.out.println("ID zone: " + brojZone + "\t Kapacitet zone: " + kapacitetZone + "\tVrijeme parkiranja: " + vrijemeParkiranjaUZoni + " sek \tCijena parkiranja: " + cijenaParkiranjaUZoni + " kn" + "\tMaksimalni broj produljenja: " + maksimalniBrojProduljenja);
    }

    public int getBrojZone() {
        return brojZone;
    }

    public void setBrojZone(int brojZone) {
        this.brojZone = brojZone;
    }

    public int getKapacitetZone() {
        return kapacitetZone;
    }

    public void setKapacitetZone(int kapacitetZone) {
        this.kapacitetZone = kapacitetZone;
    }

    public int getVrijemeParkiranjaUZoni() {
        return vrijemeParkiranjaUZoni;
    }

    public void setVrijemeParkiranjaUZoni(int vrijemeParkiranjaUZoni) {
        this.vrijemeParkiranjaUZoni = vrijemeParkiranjaUZoni;
    }

    public int getCijenaParkiranjaUZoni() {
        return cijenaParkiranjaUZoni;
    }

    public void setCijenaParkiranjaUZoni(int cijenaParkiranjaUZoni) {
        this.cijenaParkiranjaUZoni = cijenaParkiranjaUZoni;
    }

    public int getPopunjenostZone() {
        return popunjenostZone;
    }

    public void setPopunjenostZone(int popunjenostZone) {
        this.popunjenostZone = popunjenostZone;
    }

    public int getMaksimalniBrojProduljenja() {
        return maksimalniBrojProduljenja;
    }

}
