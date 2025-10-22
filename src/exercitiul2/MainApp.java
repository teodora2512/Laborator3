package exercitiul2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*2. Să se scrie un program care citește din fișierul produse.csv informații referitoare la
produsele dintr-un magazin. Pe fiecare linie se află: denumirea produsului, preţul (număr real)
cantitatea (număr întreg), data expirării (LocalDate). Cele patru elemente sunt separate prin
caracterul "," (zahar, 1.5, 50, 2024-02-25). Pentru fiecare rând citit se va crea un obiect de tip
Produs care se va adăuga unei colecții de obiecte de tip List. Se va defini o clasă Produs care
va conține: variabile membre private corespunzătoare celor trei elemente care descriu un produs,
cel puţin un constructor, gettere si settere în funcție de necesități şi redefinirea metodei toString()
din clasa Object, metodă care va fi utilizată pentru afișarea produselor.
Să se realizeze un program care va dispune de un meniu și va implementa următoarele
cerințe:
a) afișarea tuturor produselor din colecția List
b) afișarea produselor expirate
c) vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.
Daca produsul ajunge la cantitate zero, se elimina din listă. În clasa Produs se va declara
o variabilă statica încasări care se va actualiza la fiecare vânzare a unui produs, luând în
considerare prețul produsului vândut şi cantitatea vândută .
d) afișarea produselor cu prețul minim (pot fi mai multe cu același preț)
e) salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură
într-un fișier de ieșire. */
public class MainApp {
    public static void main(String[] args) {
        List<Produs> produse = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/exercitiul2/produse.csv"))) {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine().trim();
                if (linie.isEmpty()) {
                    continue;
                }
                String[] valori = linie.split(",");
                if (valori.length < 4) {
                    System.out.println("Linie incompleta! " + linie);
                    continue;
                }
                String denumire = valori[0];
                double pret = Double.parseDouble(valori[1].trim());
                int cantitate = Integer.parseInt(valori[2].trim());
                String data_string = valori[3].trim();
                LocalDate data_expirarii = LocalDate.parse(data_string, DateTimeFormatter.ofPattern("yyy-MM-dd"));
                produse.add(new Produs(denumire, pret, cantitate, data_expirarii));
            }
        } catch (Exception e) {
            System.out.println("Fisierul csv cu produsele nu a fost gasit! ");
        }
        Scanner scanner = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n=== Meniu Produse ===");
            System.out.println("1. Afișare toate produsele");
            System.out.println("2. Afișare produse expirate");
            System.out.println("3. Vânzare produs");
            System.out.println("4. Afișare produse cu preț minim");
            System.out.println("5. Salvare produse cu stoc mic în fișier");
            System.out.println("6. Afișare încasări totale");
            System.out.println("0. Ieșire");
            System.out.print("Alege  opțiune: ");
            opt = scanner.nextInt();
            scanner.nextLine();
            switch (opt) {
                case 1 -> {
                    System.out.println("Lista produse: ");
                    for (Produs p : produse)
                        System.out.println(p);
                }
                case 2 -> {
                    System.out.println("Produse expirate! ");
                    LocalDate azi = LocalDate.now();
                    for (Produs p : produse) {
                        if (p.getData_expirarii().isBefore(azi)) {
                            System.out.println(p);
                            ;
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Introduceti denumire produs vandut ! ");
                    String nume = scanner.nextLine();
                    System.out.println("Cantitate: ");
                    int cant = scanner.nextInt();

                    boolean gasit = false;
                    for (Produs p : produse) {
                        if (p.getDenumire().equalsIgnoreCase(nume.trim())) {
                            gasit = true;
                            if (p.getCantitate() >= cant) {
                                p.vinde(cant);
                                System.out.println("Produs vandut cu succes! ");
                                if (p.getCantitate() == 0) produse.remove(p);
                            } else {
                                System.out.println("Stoc insuficient! ");
                            }
                            break;
                        }
                    }
                    if (!gasit) System.out.println("Produsul nu exista in lista! ");


                }
                case 4 -> {


                    double pret_minim = Double.MAX_VALUE;
                    for (Produs p : produse) {
                        if (p.getPret() < pret_minim) {
                            pret_minim = p.getPret();
                        }
                        if (p.getPret() == pret_minim) {
                            System.out.println(p);
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Introduceti cantitate minima: ");

                    int cantitate = scanner.nextInt();

                    try (PrintWriter pw = new PrintWriter("src/exercitiul2/stoc_mic.csv")) {
                        for (Produs p : produse) {
                            if (p.getCantitate() < cantitate) {
                                pw.println(p);
                                pw.println();

                            }
                        }
                        System.out.println("Produsele a carui cantitate e mai mica decat: " + cantitate + " au fost salvate in fisier! ");
                    } catch (Exception e) {
                        System.out.println("Eroare la scrierea fisierului! ");

                    }
                }
                case 6 -> System.out.printf("Încasări totale: %.2f lei%n", Produs.incasari);
                case 0 -> System.out.println("La revedere!");
                default -> System.out.println("Opt invalidat");
            }

        } while (opt != 0);

    }
}
