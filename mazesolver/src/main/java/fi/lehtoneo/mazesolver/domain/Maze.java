/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.domain;

/**
 * Class to represent maze
 */
public class Maze {
    
    private int columns;
    private int rows;
    private char[][] grid;
    
    
    public Maze(char[][] g) {
        this.grid = g;
        
        this.rows = g.length;
        this.columns = g[0].length;
    }
    
    
    
    public Maze(int rows, int columns) {
        
        this.rows = rows;
        this.columns = columns;
        this.grid = new char[rows][columns];
        
        init();
    }
    

    /*
    *
    * Returns maze as string
    */
    @Override
    public String toString() {
        String toReturn = "";
        
        for (int x = 0; x < this.grid.length; x++) {
            if (x != 0) {
                toReturn += "\n";
            }
            for (int y = 0; y < this.grid[0].length; y++) {
                
                toReturn += this.grid[x][y];
            }
        }
        
        return toReturn;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }
    
    
    
    
    public char[][] getGrid() {
        return this.grid;
    }
    
    
    
    /*
    * Creates outerwalls to maze and inserts everything else as path
    */
    private void init() {
        
        for (int i = 0; i  < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (i == 0 || i ==  this.rows - 1 || j == 0 || j == this.columns - 1) {
                    this.grid[i][j] = '#';
                } else {
                    this.grid[i][j] = '.';
                }
            }
        }
        
    }
    
}
