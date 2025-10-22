package exercitiuSuplimentar;

import java.time.LocalDate;

public class Angajat {
    String nume;
    String functie;
    double salariu;
    LocalDate data_angajarii;


    public Angajat(String nume,String functie, double salariu,LocalDate data_angajarii) {
        this.nume=nume;
        this.functie=functie;
        this.salariu=salariu;
        this.data_angajarii=data_angajarii;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    @Override
    public String toString()
    {
        return "nume:"+nume+" functie:"+functie+" salariu:"+salariu+" data angajarii:"+ data_angajarii;
    }
    public void majorareSalariu(double procent){
        salariu=salariu+(procent/100)*salariu;
    }

}
