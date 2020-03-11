/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.domain;

/**
 *
 * @author ossij
 */
public class Maze {
    
    private int columns;
    private int rows;
    private char[][] grid;
    private int[][] start;
    private int[][] end;
    
    
    //test maze
    public Maze () {
        
        char[][] t = {{'#','#','#','#','#','#','#'},
              {'#','x','#','.','y','.','#'},
              {'#','z','.','.','#','#','#'},
              {'#','.','.','.','.','.','#'},
              {'#','#','#','#','#','#','#'}};
        
        this.rows = t.length;
        this.columns = t[0].length;
        System.out.println("rows " + this.rows);
        System.out.println("colums " + this.columns);
        this.grid = t;
    }
    
    public Maze (int rows, int columns) {
        
        this.rows = rows;
        this.columns = columns;
        this.grid = new char[rows][columns];
        this.start = new int[1][1];
        this.end = new int[1][1];
        
        init();
    }
    

    
    public String toString() {
        String toReturn = "";
        
        for(int x = 0; x < this.rows; x++) {
            if(x != 0){
                toReturn += "\n";
            }
            for(int y = 0; y < this.columns; y++) {
                System.out.println("x: " + x + "y: " + y);
                toReturn += this.grid[x][y];
            }
        }
        
        return toReturn;
    }
    
    public char[][] getGrid() {
        return this.grid;
    }
    
    
    
    
    private void init() {
        
        for(int i = 0; i  < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if(i == 0 || i ==  this.rows - 1|| j == 0 || j == this.columns - 1) {
                    this.grid[i][j] = '#';
                } else {
                    this.grid[i][j] = '.';
                }
            }
        }
        
    }
    
}
