package me.unbekannterpromi.aoc._2020;

import me.aoc.Day;
import me.util.AoCFile;

public class Day4 extends Day {




    @Override
    public void run1(AoCFile file) {


        String input = file.readCompleteFile();
        //kompletter input zu pässen auseinandergeschustert
        String[] splitinput = input.split("\n\n");

        int zeahler = 0;
        for (int i = 0; i < splitinput.length; i++) {

            //hier werden fields einzeln gemacht
            splitinput[i]= splitinput[i].replace("\n"," ");
            String[] einzelnes = splitinput[i].split(" ");


            if (einzelnes.length == 8){
                zeahler++;
            }else if (einzelnes.length == 7) {
                boolean IstCIDdadrinnen =false;
                 for (int x = 0; x < 7; x++) {
                     if (einzelnes[x].startsWith("cid")) {
                         IstCIDdadrinnen = true;
                         break;
                     }
                 }
                 if (!IstCIDdadrinnen) {
                     zeahler++;
                 }
             }
        }
        System.out.println(zeahler);
    }

    @Override
    public void run2(AoCFile file) {
        String input = file.readCompleteFile();
        //kompletter input zu pässen auseinandergeschustert
        String[] splitinput = input.split("\n\n");

        int zeahler = 0;
        for (int i = 0; i < splitinput.length; i++) {

            //hier werden fields einzeln gemacht
            splitinput[i]= splitinput[i].replace("\n"," ");
            String[] einzelnes = splitinput[i].split(" ");

            boolean cidcheck =false;
            boolean byrcheck = false;
            if (einzelnes.length == 8){
                cidcheck = true;
            }else if (einzelnes.length == 7) {

                for (int x = 0; x < 7; x++) {
                    if (einzelnes[x].startsWith("cid")) {
                        cidcheck = true;
                        break;
                    }
                }

            }
            if (!cidcheck) {
                for (int u= 0; u < einzelnes.length; u++) {
                    if (einzelnes[u].startsWith("byr")) {

                    }
                }
            }
        }
        System.out.println(zeahler);
    }
}
