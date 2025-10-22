package exercitiul1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        List<Parabola> parabole=new ArrayList<>();
        try(Scanner scanner=new Scanner(new File("src/exercitiul1/in.txt"))){
            while(scanner.hasNextLine()){
                String linie= scanner.nextLine();

                String[] valori=linie.split(" ");
                int a=Integer.parseInt(valori[0]);
                int b=Integer.parseInt(valori[1]);
                int c=Integer.parseInt(valori[2]);
                parabole.add(new Parabola(a,b,c));
            }
        } catch (Exception e) {
            System.out.println("Fisierul text nu a fost gasit! ");
            return;
        }

        for(Parabola p:parabole)
        {
            System.out.println(p);
        }
        if(parabole.size()>2){
            Parabola p1=parabole.get(0);
            Parabola p2=parabole.get(1);

            float[] mij=Parabola.mijlocIntreVarfuri(p1,p2);
            double lungime=Parabola.lungimeIntreVarfuri(p1,p2);

            System.out.println("Intre primele 2 parabole: ");
            System.out.printf("Mij segment ce uneste varfurile: (%.2f,%.2f)%n", mij[0],mij[1]);
            System.out.printf("Lungime segment ce uneste varfuri: %.4f%n",lungime);
        }
        else
            System.out.println("Mai introduceti parabole in fisierul text! ");
    }

}
