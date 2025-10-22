package exercitiul2;

import java.time.LocalDate;
import java.util.List;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate data_expirarii;
    public static double incasari=0;

    public Produs(String denumire,double pret,int cantitate,LocalDate data_expirarii)
    {
        this.denumire=denumire;
        this.pret=pret;
        this.cantitate=cantitate;
        this.data_expirarii=data_expirarii;
    }
    public void vinde(int cantitateVanduta)
    {
        if( cantitateVanduta<=cantitate) {
            cantitate -= cantitateVanduta;
            incasari += pret * cantitateVanduta;
        }else{
            System.out.println("Insuficient stoc pt produsul: "+ denumire);
        }
    }
    @Override
    public String toString() {
        return "denumire: "+denumire+ " pret: "+ pret+" cantitate: "+cantitate+ " data expirare: "+data_expirarii;
    }

    public static double getIncasari() {
        return incasari;
    }

    public static void setIncasari(double incasari) {
        Produs.incasari = incasari;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getData_expirarii() {
        return data_expirarii;
    }

    public void setData_expirarii(LocalDate data_expirarii) {
        this.data_expirarii = data_expirarii;
    }

}
