package me.hasenzahn1.aoc._2021.utilclasses;

import java.util.Arrays;

public class Board{

    private int[][] marked, filled;

    public Board(String board){
        filled = toFilled(board);
        marked = new int[filled.length][filled[0].length];
        for(int i = 0; i < marked.length; i++){
            Arrays.fill(marked[i], -1);
        }
        //print();
        //System.out.println();

    }

    public void mark(int number){
        for(int i = 0; i < filled.length; i++){
            for(int j = 0; j < filled[i].length; j++){
                if(filled[i][j] == number) marked[i][j] = number;
            }
        }
    }

    public int[][] toFilled(String board){
        board = board.replace("\n ", "\n");
        String[] lines = board.split("\n");
        int collums = lines[0].replace("  ", " ").split(" ").length;
        int[][] create = new int[lines.length][collums];
        for(int i = 0; i < lines.length; i++){
            String[] collum = lines[i].replace("  ", " ").split(" ");
            int[] intcollum = new int[collums];
            for (int j = 0; j < collums; j++){
                intcollum[j] = Integer.parseInt(collum[j]);
            }
            create[i] = intcollum;
        }
        return create;
    }

    public boolean hasWon(){
        for(int i = 0; i < marked.length; i++){
            boolean won = true;
            for(int j = 0; j < marked[i].length; j++){
                if(marked[i][j] == -1) {
                    won = false;
                    break;
                }
            }
            if (won) return true;
        }

        for(int i = 0; i < marked[0].length; i++){
            boolean won = true;
            for(int j = 0; j < marked.length; j++){
                if(marked[j][i] == -1) {
                    won = false;
                    break;
                }
            }
            if (won) return true;
        }

        return false;
    }

    public void print(){
        for(int i = 0; i < filled.length; i++){
            for(int j = 0; j < filled[i].length; j++){
                if(filled[i][j] < 10){
                    System.out.print(" " + filled[i][j] + " ");
                }else{
                    System.out.print(filled[i][j] + " ");
                }
            }
            System.out.print("  |  ");
            for(int j = 0; j < filled[i].length; j++){
                if(marked[i][j] == -1){
                    System.out.print(" _ ");
                }else if(marked[i][j] < 10){
                    System.out.print(" " + marked[i][j] + " ");
                }else{
                    System.out.print(marked[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public int getResult(int number) {
        int sum = 0;
        for(int i = 0; i < filled.length; i++){
            for(int j = 0; j < filled[i].length; j++){
                if(marked[i][j] == -1) sum += filled[i][j];
            }
        }
        return sum * number;
    }
}
