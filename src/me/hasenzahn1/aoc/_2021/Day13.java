package me.hasenzahn1.aoc._2021;

import me.aoc.Day;
import me.util.AoCFile;

public class Day13 extends Day {

    @Override
    public void run1(AoCFile file) {
        String content = file.readCompleteFile();
        String[] points = content.split("\n\n")[0].split("\n");
        String[] instructions = content.split("\n\n")[1].split("\n");
        boolean[][] grid = new boolean[447 * 2 + 1][655 * 2 + 1];
        for(String point : points){
            int y = Integer.parseInt(point.split(",")[0]);
            int x = Integer.parseInt(point.split(",")[1]);
            grid[x][y] = true;
        }
        //print(grid);
        grid = foldY(grid, 655);
        //System.out.println("\n");
        //print(grid);
        int count = 0;
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[x][y]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public boolean[][] foldY(boolean[][] grid, int yFold){
        boolean[][] newGrid = new boolean[grid.length][(int) Math.floor(grid[0].length / 2.)];
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(grid[x][y]){
                    //System.out.println(yFold - (y - yFold));
                    newGrid[x][yFold - Math.abs(y - yFold)] = true;
                }
            }
        }
        return newGrid;
    }
    public boolean[][] foldX(boolean[][] grid, int xFold){
        boolean[][] newGrid = new boolean[(int) Math.floor(grid.length / 2.0)][grid[0].length];
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(grid[x][y]){
                    newGrid[xFold - Math.abs(x - xFold)][y] = true;
                }
            }
        }
        return newGrid;
    }

    public void print(boolean[][] levels){
        for(int j=0; j<levels[0].length; j++){
            for(int i=0; i<levels.length; i++){
                if(levels[i][j]){
                    System.out.print("#");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void run2(AoCFile file) {
        String content = file.readCompleteFile();
        String[] points = content.split("\n\n")[0].split("\n");
        String[] instructions = content.split("\n\n")[1].split("\n");
        boolean[][] grid = new boolean[447 * 2 + 1][655 * 2 + 1];
        for(String point : points){
            int y = Integer.parseInt(point.split(",")[0]);
            int x = Integer.parseInt(point.split(",")[1]);
            grid[x][y] = true;
        }
        //print(grid);
        grid = foldY(grid, 655);
        grid = foldX(grid, 447);
        grid = foldY(grid, 327);
        grid = foldX(grid, 223);
        grid = foldY(grid, 163);
        grid = foldX(grid, 111);
        grid = foldY(grid, 81);
        grid = foldX(grid, 55);
        grid = foldY(grid, 40);
        grid = foldX(grid, 27);
        grid = foldX(grid, 13);
        grid = foldX(grid, 6);
        //System.out.println("\n");
        print(grid);
        int count = 0;
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(grid[x][y]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
