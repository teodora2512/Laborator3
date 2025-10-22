Lucrarea Practică 3 - Java: POO, I/O și Gestiune de Date
Acest proiect Java demonstrează competențe în Programarea Orientată pe Obiecte (POO), gestionarea colecțiilor dinamice și operațiuni de intrare/ieșire (I/O) cu fișiere. Proiectul este împărțit în două exerciții principale.

1. Exercițiul 1: Modelarea Parabolae (Clasa Parabola) 📐
Obiectiv

Modelarea funcției de gradul doi y=ax 
2
 +bx+c și efectuarea de calcule analitice și geometrice.

Competențe Demonstrate

POO: Definirea clasei Parabola cu atribute private și metode de calcul (de exemplu, pentru vârf).

I/O: Citirea coeficienților (a,b,c) din fișierul in.txt.

Metode Statice: Implementarea de calcule comune segmentului dintre vârfuri:

Determinarea punctului de mijloc al segmentului.

Calculul lungimii segmentului.

2. Exercițiul 2: Sistem de Gestiune a Produselor (Clasa Produs) 🛒
Obiectiv

Crearea unui sistem de gestiune a stocului, cu meniu interactiv, citire din CSV, operațiuni pe colecții și calcularea încasărilor.

Competențe Demonstrate

Manipulare I/O: Citirea datelor structurate (CSV) din produse.csv și scrierea (exportul) în stoc_mic.csv (PrintWriter).

Gestiune Colecții: Utilizarea List<Produs> pentru stocarea dinamică și aplicarea operațiunilor de căutare, filtrare și eliminare.

Logica de Business & Variabile Statice:

Vânzare: Logica de verificare a stocului, actualizare a cantității și eliminarea produsului din listă dacă stocul ajunge la zero.

Încasări Totale: Utilizarea unei variabile statice (incasari) pentru a cumula veniturile magazinului.

Manipulare Date: Lucrul cu LocalDate pentru:

Parsarea datelor de expirare din CSV.

Filtrarea și afișarea produselor expirate.

Interfață Utilizator: Implementarea unui meniu console do-while/switch pentru interacțiune.