package exercitiuSuplimentar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        List<Angajat> angajati = new ArrayList<>();

        // Citire din fișier
        try (Scanner scanner = new Scanner(new File("src/exercitiuSuplimentar/angajati.csv"))) {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine().trim();
                if (linie.isEmpty()) continue;

                String[] valori = linie.split(",");
                if (valori.length != 4) continue;

                String nume = valori[0].trim();
                String functie = valori[1].trim();
                double salariu = Double.parseDouble(valori[2].trim());
                LocalDate data_angajarii = LocalDate.parse(valori[3].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                angajati.add(new Angajat(nume, functie, salariu, data_angajarii));
            }

        } catch (Exception e) {
            System.out.println("Fisierul nu a putut fi gasit!");
        }

        // Meniu interactiv
        Scanner scanner = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n=== MENIU ===");
            System.out.println("1. Afișarea tuturor angajaților");
            System.out.println("2. Afișarea angajaților cu vechime mai mare decât o valoare dată");
            System.out.println("3. Majorarea salariilor pentru o funcție cu un procent dat");
            System.out.println("4. Afișarea angajaților cu salariul maxim");
            System.out.println("5. Salvarea în bonus.csv a angajaților cu salariul peste media firmei (descrescător)");
            System.out.println("0. Ieșire");
            System.out.print("Alege opțiunea: ");

            opt = scanner.nextInt();
            scanner.nextLine(); // consumă Enter-ul

            switch (opt) {
                case 1 -> {
                    System.out.println("\n--- Lista angajaților ---");
                    for (Angajat a : angajati) {
                        System.out.println(a);
                    }
                }

                case 2 -> {
                    System.out.print("Introdu valoarea vechimii (în ani): ");
                    int vechime_prag = scanner.nextInt();
                    System.out.println("\nAngajații cu vechime mai mare decât " + vechime_prag + " ani:");
                    for (Angajat a : angajati) {
                        int vechime = LocalDate.now().getYear() - a.getData_angajarii().getYear();
                        if (vechime > vechime_prag) {
                            System.out.println(a + " (vechime: " + vechime + " ani)");
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Introdu funcția: ");
                    String functie = scanner.nextLine();
                    System.out.print("Introdu procentul de majorare: ");
                    double procent = scanner.nextDouble();

                    for (Angajat a : angajati) {
                        if (a.getFunctie().equalsIgnoreCase(functie.trim())) {
                            a.majorareSalariu(procent);
                        }
                    }
                    System.out.println("Salariile au fost majorate pentru funcția " + functie + ".");
                }

                case 4 -> {
                    double maxim = angajati.stream()
                            .mapToDouble(Angajat::getSalariu)
                            .max()
                            .orElse(0);
                    System.out.println("\nAngajații cu salariul maxim (" + maxim + "):");
                    for (Angajat a : angajati) {
                        if (a.getSalariu() == maxim)
                            System.out.println(a);
                    }
                }

                case 5 -> {
                    double media = angajati.stream()
                            .mapToDouble(Angajat::getSalariu)
                            .average()
                            .orElse(0);

                    List<Angajat> pesteMedie = angajati.stream()
                            .filter(a -> a.getSalariu() > media)
                            .sorted((a1, a2) -> Double.compare(a2.getSalariu(), a1.getSalariu()))
                            .toList();

                    try (PrintWriter pw = new PrintWriter(new File("src/exercitiuSuplimentar/bonus.csv"))) {
                        for (Angajat a : pesteMedie) {
                            pw.println(a.getNume() + "," + a.getFunctie() + "," + a.getSalariu() + "," + a.getData_angajarii());
                        }
                        System.out.println("Fișierul bonus.csv a fost creat cu succes!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Eroare la scrierea fișierului: " + e.getMessage());
                    }
                }

                case 0 -> System.out.println("La revedere!");

                default -> System.out.println("Opțiune invalidă!");
            }

        } while (opt != 0);
    }
}
