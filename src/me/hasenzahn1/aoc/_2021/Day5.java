package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.hasenzahn1.aoc._2021.utilclasses.Diagram;
import me.util.AoCFile;

import java.util.ArrayList;
import java.util.Objects;

public class Day5 extends Day {


    @Override
    public void run1(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        Diagram d = new Diagram(1000, 1000);
        for(String line : lines){
            String[] cords = line.split(" -> ");
            String[] p1Cord = cords[0].split(",");
            String[] p2Cord = cords[1].split(",");
            if(Objects.equals(p1Cord[0], p2Cord[0]) || Objects.equals(p1Cord[1], p2Cord[1])){
                d.addPointStraight(Integer.parseInt(p1Cord[1]), Integer.parseInt(p1Cord[0]), Integer.parseInt(p2Cord[1]), Integer.parseInt(p2Cord[0]));
            }
        }
        System.out.println(d.getPoinitsWithMore());
    }

    @Override
    public void run2(AoCFile file) {
        ArrayList<String> lines = file.readLines();
        Diagram d = new Diagram(1000, 1000);
        for(String line : lines){
            String[] cords = line.split(" -> ");
            String[] p1Cord = cords[0].split(",");
            String[] p2Cord = cords[1].split(",");
            if(Objects.equals(p1Cord[0], p2Cord[0]) || Objects.equals(p1Cord[1], p2Cord[1])){
                d.addPointStraight(Integer.parseInt(p1Cord[1]), Integer.parseInt(p1Cord[0]), Integer.parseInt(p2Cord[1]), Integer.parseInt(p2Cord[0]));
            }else{
                d.addPointDiag(Integer.parseInt(p1Cord[1]), Integer.parseInt(p1Cord[0]), Integer.parseInt(p2Cord[1]), Integer.parseInt(p2Cord[0]));
            }
        }
        System.out.println(d.getPoinitsWithMore());
    }
}
