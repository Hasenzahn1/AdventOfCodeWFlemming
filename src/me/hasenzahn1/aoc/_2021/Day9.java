package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day9 extends Day {


    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();

        int[][] field = new int[lines.size()][lines.get(0).length()];
        for(int x = 0; x < lines.size(); x++){
            for(int y = 0; y < lines.get(x).length(); y++){
                field[x][y] = Integer.parseInt(String.valueOf(lines.get(x).charAt(y)));
            }
        }

        System.out.println(Arrays.deepToString(field));
        int count = 0;
        for(int x = 0; x < field.length; x++){
            for(int y = 0; y < field[x].length; y++){
                boolean lower = true;
                int value = field[x][y];
                for(int ax = -1; ax < 2; ax++){
                    if (!lower) break;
                    for(int ay = -1; ay < 2; ay++){
                        try{
                            if(field[x + ax][y + ay] < value){
                                lower = false;
                                break;
                            }
                        }catch (IndexOutOfBoundsException e){

                        }
                    }
                }
                if(lower){
                    count += value + 1;
                }
            }
        }
        System.out.println(count);
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();

        int[][] field = new int[lines.size()][lines.get(0).length()];
        int[][] fieldtraverse = new int[lines.size()][lines.get(0).length()];
        for(int x = 0; x < lines.size(); x++){
            for(int y = 0; y < lines.get(x).length(); y++){
                field[x][y] = Integer.parseInt(String.valueOf(lines.get(x).charAt(y)));
                fieldtraverse[x][y] = Integer.parseInt(String.valueOf(lines.get(x).charAt(y)));
            }
        }
        for(String s : Arrays.deepToString(fieldtraverse).split("], ")){
            System.out.println(s + "]");
        }

        ArrayList<Integer> basins = new ArrayList<>();
        for(int x = 0; x < field.length; x++){
            for(int y = 0; y < field[x].length; y++){
                boolean lower = true;
                int value = field[x][y];
                for(int ax = -1; ax < 2; ax++){
                    if (!lower) break;
                    for(int ay = -1; ay < 2; ay++){
                        try{
                            if(field[x + ax][y + ay] < value){
                                lower = false;
                                break;
                            }
                        }catch (IndexOutOfBoundsException ignored){

                        }
                    }
                }
                if(lower){
                    basins.add(traverse(fieldtraverse, x, y));
                }
            }
        }
        Collections.sort(basins);
        int amount = 1;
        for(int i = basins.size() - 1; i > basins.size() - 1 - 3; i--){
            amount *= basins.get(i);
        }
        System.out.println(amount);


    }

    public int traverse(int[][] field, int x, int y){
        int value = 1;
        field[x][y] = -10;
        if((x - 1) >= 0 && field[x - 1][y] != 9 && field[x - 1][y] != -10){
            value += traverse(field, x - 1, y);
        }
        if((x + 1) < field.length && field[x + 1][y] != 9 && field[x + 1][y] != -10){
            value += traverse(field, x + 1, y);
        }
        if((y - 1) >= 0 && field[x][y - 1] != 9 && field[x][y - 1] != -10){
            value += traverse(field, x, y - 1);
        }
        if((y + 1) < field[x].length && field[x][y + 1] != 9 && field[x][y + 1] != -10){
            value += traverse(field, x, y + 1);
        }
        return value;
    }
}
