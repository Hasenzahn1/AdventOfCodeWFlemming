package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.hasenzahn1.aoc._2021.utilclasses.Board;
import me.util.AoCFile;

import java.util.ArrayList;


public class Day4 extends Day {


    @Override
    public void run1(AoCFile file) {
        ArrayList<Board> board_objs = new ArrayList<>();

        String content = file.readCompleteFile();
        String[] boards = content.split("\n\n");
        String calledNumbers = boards[0];
        for(int i = 1; i < boards.length; i++){
            if (boards[i].charAt(0) == ' ') boards[i] = boards[i].replaceFirst(" ", "");
            board_objs.add(new Board(boards[i]));
        }

        String[] numbers = calledNumbers.split(",");
        for(String n : numbers){
            int number = Integer.parseInt(n);
            for(Board b : board_objs){
                b.mark(number);
                if (b.hasWon()){
                    System.out.println("Result: " + b.getResult(number));
                    b.print();
                    return;
                }
            }
        }
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<Board> board_objs = new ArrayList<>();

        String content = file.readCompleteFile();
        String[] boards = content.split("\n\n");
        String calledNumbers = boards[0];
        for(int i = 1; i < boards.length; i++){
            if (boards[i].charAt(0) == ' ') boards[i] = boards[i].replaceFirst(" ", "");
            board_objs.add(new Board(boards[i]));
        }

        String[] numbers = calledNumbers.split(",");
        for(String n : numbers){
            ArrayList<Board> inGame = new ArrayList<>();
            Board won = null;
            int number = Integer.parseInt(n);
            for(Board b : board_objs){
                b.mark(number);
                if (!b.hasWon()){
                    inGame.add(b);
                }else{
                    won = b;
                }
            }
            if (won != null && inGame.size() == 0){
                System.out.println("Result: " + won.getResult(number));
                won.print();
                return;
            }
            board_objs = inGame;
        }
    }

}