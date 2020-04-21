/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.mazegeneration;

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
    
    
    
    
    
}
