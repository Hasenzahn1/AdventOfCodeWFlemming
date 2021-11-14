package me.unbekannterpromi.aoc;

import me.aoc.Day;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Day2 extends Day {
    public Day2(String fileName1, String fileName2) {
        super(fileName1, fileName2);
    }

    @Override
    public void run1() {
        int zaehler = 0;
        ArrayList<String> lines = file1.readLines();
        for (int u = 0; u < lines.size(); u++) {


            String text = lines.get(u);

            String[] Liste = text.split(": ");
            String[] BuchstabenListe = Liste[0].split(" ");
            String[] Zahlenliste = BuchstabenListe[0].split("-");

            String Buchstabe = BuchstabenListe[1];
            char[] Buchstabechar = Buchstabe.toCharArray();
            String durchsuchen = Liste[1];
            int AnzahlDerGewuenschtenBuchstaben = 0;
            char[] Kauderwelsch = durchsuchen.toCharArray();


            for (int i = 0; i < Kauderwelsch.length; i++) {
                if (Kauderwelsch[i] == Buchstabechar[0]) {
                    AnzahlDerGewuenschtenBuchstaben++;
                }
            }
            int minimum = Integer.parseInt(Zahlenliste[0]);
            int maximum = Integer.parseInt(Zahlenliste[1]);


            if (AnzahlDerGewuenschtenBuchstaben >= minimum && AnzahlDerGewuenschtenBuchstaben <= maximum) {
                zaehler = zaehler + 1;
            }
        }
        System.out.println(zaehler);
    }

    @Override
    public void run2() {
        // 5-10 q: qqqqqqqqqpqq

        int zaehler = 0;

       ArrayList<String> lines = file2.readLines();
        for (int u = 0; u < lines.size(); u++) {

            String text = lines.get(u);

            //Aufsplitten des Inputs
            String[] Liste = text.split(": ");
            String[] BuchstabenListe = Liste[0].split(" ");
            String[] Zahlenliste = BuchstabenListe[0].split("-");

            //Positionen aus der Zahlenliste zu integern casten
            int pos1 = Integer.parseInt(Zahlenliste[0]);
            int pos2 = Integer.parseInt(Zahlenliste[1]);

            String Buchstabe = BuchstabenListe[1];
            String durchsuchen = Liste[1];
            char[] Kauderwelsch = durchsuchen.toCharArray();


            //Damit ich in der if Abfrage den Buchstaben checken kann muss er auch n array sein:
            char[] Buchstabechar = Buchstabe.toCharArray();

            //Wenn der Buchstabe das dies und jenes nicht hat oder dies nicht dafür aber jenes zaehler eins hoch
            if (Buchstabechar[0]== Kauderwelsch[pos1-1] && Buchstabechar[0] != Kauderwelsch[pos2-1]) {
                zaehler = zaehler +1;
            } else if (Buchstabechar[0]!= Kauderwelsch[pos1-1] && Buchstabechar[0] == Kauderwelsch[pos2-1]) {
                zaehler = zaehler +1;
            }

        }
        System.out.println(zaehler);
    }
}
