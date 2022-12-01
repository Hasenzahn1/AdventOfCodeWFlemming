package me.hasenzahn1.aoc._2021.utilclasses;

public class Diagram {

    private int[][] diagram;

    public Diagram(int x, int y){
        init(x, y);
    }

    public void print(){
        for (int x = 0; x < diagram.length; x++){
            for (int y = 0; y < diagram[x].length; y++){
                if (diagram[x][y] == 0){
                    System.out.print("  .");
                }else if(diagram[x][y] < 10){
                    System.out.print("  " + diagram[x][y]);
                }else{
                    System.out.print(" " + diagram[x][y]);
                }
            }
            System.out.println();
        }
    }

    public void addPointDiag(int y1, int x1, int y2, int x2){
        int xDir = (x2 - x1) / Math.abs(x2 - x1);
        int yDir = (y2 - y1) / Math.abs(y2 - y1);
        int cx = x1;
        int cy = y1;
        for(int i = 0; i < Math.abs(x2 - x1) + 1; i++){
            diagram[cx][cy] += 1;
            cx += xDir;
            cy += yDir;
        }
    }

    public void addPointStraight(int y1, int x1, int y2, int x2){
        for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++){
            for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++){
                diagram[x][y] += 1;
            }
        }
    }

    public void init(int x, int y){
        diagram = new int[x + 1][y + 1];
        for(int i = 0; i < x + 1; i++){
            for(int j = 0; j < y + 1; j++){
                diagram[i][j] = 0;
            }
        }
    }

    public int getPoinitsWithMore(){
        int count = 0;
        for (int x = 0; x < diagram.length; x++){
            for (int y = 0; y < diagram[x].length; y++){
                if (diagram[x][y] > 1){
                    count++;
                }
            }
        }
        return count;
    }

}
