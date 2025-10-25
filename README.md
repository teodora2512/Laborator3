# Lucrarea Practică 3 – Java: POO, I/O și Gestiune de Date

Acest proiect Java demonstrează competențe în **Programarea Orientată pe Obiecte (POO)**, gestionarea colecțiilor dinamice și operațiuni de **intrare/ieșire (I/O)** cu fișiere.  
Proiectul este împărțit în două exerciții principale, fiecare cu obiective și funcționalități specifice.

---

## 📐 Exercițiul 1: Modelarea Parabolei (Clasa `Parabola`)

### 🎯 Obiectiv
Modelarea funcției de gradul doi:  

\[
y = ax^2 + bx + c
\]  

și efectuarea de calcule analitice și geometrice.

### 🛠️ Competențe Demonstrate
- **POO**: Definirea clasei `Parabola` cu atribute private și metode de calcul (de exemplu, pentru vârf, axă de simetrie, puncte de intersecție).  
- **I/O**: Citirea coeficienților `(a, b, c)` din fișierul `in.txt`.  
- **Metode Statice**: Calculul segmentelor între puncte:
  - Determinarea **punctului de mijloc** al segmentului.  
  - Calculul **lungimii segmentului**.  

### 🔹 Exemplu de utilizare
```java
Parabola p = new Parabola(2, -4, 1);
System.out.println("Vârful parabolei: " + p.getVarf());
System.out.println("Lungimea segmentului între puncte: " + Parabola.calculeazaSegment(punct1, punct2));

Punct punct1 = new Punct(1, 2);
Punct punct2 = new Punct(3, 6);
System.out.println("Lungimea segmentului între puncte: " + Parabola.calculeazaSegment(punct1, punct2));
```

##🛒 Exercițiul 2: Sistem de Gestiune a Produselor (Clasa Produs)
🎯 Obiectiv
Crearea unui sistem de gestiune a stocului cu meniu interactiv, citire din CSV și calcularea încasărilor.
🛠️ Competențe Demonstrate
Manipulare I/O:
Citirea datelor din produse.csv.
Exportul stocului în stoc_mic.csv folosind PrintWriter.
Gestiune Colecții:
Stocarea produselor în List<Produs>.
Operațiuni de căutare, filtrare și eliminare a produselor.
Logică de Business & Variabile Statice:
Vânzare: verificarea stocului, actualizarea cantității și eliminarea produsului dacă stocul ajunge la zero.
Încasări Totale: variabilă statică incasari pentru suma totală a veniturilor magazinului.
Manipulare Date:
Utilizarea LocalDate pentru parsarea datelor de expirare.
Filtrarea și afișarea produselor expirate.
Interfață Utilizator:
Meniu interactiv în consolă cu do-while și switch.
🔹 Exemplu de meniu
```
1. Afișează toate produsele
2. Vinde produs
3. Afișează produse expirate
4. Export stoc
5. Ieșire
```

```
src/
├─ exercitiu1/
│  ├─ Parabola.java
│  └─ MainApp.java
├─ exercitiu2/
│  ├─ Produs.java
│  ├─ MainApp.java
│  └─ produse.csv
└─ util/
   └─ Utils.java
```
👩‍💻 Autor
Teodora Oțelariu
Lucrare Java – Anul III