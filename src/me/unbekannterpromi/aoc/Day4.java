package me.unbekannterpromi.aoc;

import me.aoc.Day;
import me.util.AoCFile;

public class Day4 extends Day {




    @Override
    public void run1(AoCFile file) {


        String input = file.readCompleteFile();
        //kompletter input zu pässen auseinandergeschustert
        String[] splitinput = input.split("\n\n");

        int zeahler = 0;
        String[] fieldseinzeln = new String[17];
        for (int i = 0; i < splitinput.length; i++) {

            //hier werden fields einzeln gemacht
            String[] einzelnes = splitinput[i].split(" |\n");

            for (int t = 0; t < einzelnes.length; t++) {
                //hier werden amount und field getrennt
                fieldseinzeln = einzelnes[t].split(":");
            }

            String[] fields = new String[9];

            //amounts wegfallen lassen
            for (int z = 0; z < fieldseinzeln.length / 2; z++) {

                fields[z] = fieldseinzeln[z * 2];
            }

             if (fields.length == 7) {

                for (int x = 0; x < fields.length; x++) {
                    if (fields[i] == "cid") {

                    } else {
                        zeahler++;
                    }
                }

            } else if (fields.length == 8){
                zeahler++;
            }
        }
        System.out.println(zeahler);
    }

    @Override
    public void run2(AoCFile file) {

    }
}
