package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.util.ArrayList;

public class Day11 extends Day {

    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        int[][] levels = new int[lines.size()][lines.get(0).length()];

        for(int x = 0; x < lines.size(); x++){
            for(int y = 0; y < lines.get(x).length(); y++){
                levels[x][y] = Integer.parseInt(lines.get(x).charAt(y) + "");
            }
        }

        print(levels);
        System.out.println();

        //Master
        int flashes = 0;
        int counter = 0;
        while(true){
            counter++;
            for (int x = 0; x < levels.length; x++) {
                for (int y = 0; y < levels[x].length; y++) {
                    levels[x][y] += 1;
                }
            }
            while (true) {
                boolean flashed = false;

                for (int x = 0; x < levels.length; x++) {
                    for (int y = 0; y < levels[x].length; y++) {
                        if (levels[x][y] > 9) {
                            //Flash
                            flashed = true;
                            flashes ++;
                            for (int ax = -1; ax < 2; ax++) {
                                for (int ay = -1; ay < 2; ay++) {
                                    if ((x + ax) >= 0 && (x + ax) < levels.length) {
                                        if ((y + ay) >= 0 && (y + ay) < levels[x + ax].length) {
                                            if (levels[x + ax][y + ay] != -1) {
                                                levels[x + ax][y + ay] += 1;
                                            }
                                        }
                                    }
                                }
                            }
                            levels[x][y] = -1;
                        }
                    }
                }

                if (!flashed) break;
            }
            boolean allFlashed = true;
            for (int x = 0; x < levels.length; x++) {
                for (int y = 0; y < levels[x].length; y++) {
                    if (levels[x][y] == -1) levels[x][y] = 0;
                    else allFlashed = false;
                }
            }
            if(allFlashed) {
                System.out.println("All Flashed at step " + (counter));
                break;
            }

            //print(levels);
            //System.out.println();
        }
        System.out.println(flashes);
    }

    public void print(int[][] levels){
        for(int i=0; i<levels.length; i++){
            for(int j=0; j<levels[i].length; j++){
                System.out.print(String.format("%1s", levels[i][j]));
            }
            System.out.println();
        }
    }

    @Override
    public void run2(AoCFile file) {

    }
}
