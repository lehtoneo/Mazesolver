package fi.lehtoneo.mazesolver.domain;


import fi.lehtoneo.mazesolver.util.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * Class to create maze with Prim's algorithm (modified version)
 */
public class Prim {
    
    char[][] grid;
    
    
    public Prim(int rows, int columns) {
        this.grid = new char[rows][columns];
        init();
    }
    
    /**
     * Prim's algorithm to generate a "perfect" maze
     */
    public void generate() {
        List<Cell> frontiers = new ArrayList<>();
        Random random = new Random();
        this.grid[1][3] = '.';
        frontiers.add(new Cell(1, 5));
        frontiers.add(new Cell(3, 3));
        frontiers.add(new Cell(1, 1));
        
        while (frontiers.size() > 0) {
            
            
            int r = random.nextInt(frontiers.size());
            Cell c = frontiers.get(r);
            
            frontiers.remove(r);
            
            if (this.grid[c.getRow()][c.getColumn()] == '.') {
                continue;
            }
            
            int row = c.getRow();
            int col = c.getColumn();
            this.grid[row][col] = '.';
            List<Cell> neighbours = new ArrayList<>();
            
            if (row - 2 > 0) {
                if (this.grid[row - 2][col] == '.') {
                    neighbours.add(new Cell(row - 2, col));
                }
            }
            
            if (row + 2 < this.grid.length - 1) {
                if (this.grid[row + 2][col] == '.') {
                    neighbours.add(new Cell(row + 2, col));
                }
            }
            
            if (col - 2 > 0) {
                if (this.grid[row][col - 2] == '.') {
                    neighbours.add(new Cell(row, col - 2));
                }
            }
            
            if (col + 2 < this.grid[0].length - 1) {
                if (this.grid[row][col + 2] == '.') {
                    neighbours.add(new Cell(row, col + 2));
                }
            }
            
            
            
            if (neighbours.isEmpty()) {
                continue;
            }
            
            Cell neighbour = neighbours.get(new Random().nextInt(neighbours.size()));
            
            if (neighbour.getRow() < row) {
                this.grid[row - 1][col] = '.';
            } else if (neighbour.getRow() > row) {
                this.grid[row + 1][col] = '.';
            } else if (neighbour.getColumn() < col) {
                this.grid[row][col - 1] = '.';
            } else {
                this.grid[row][col + 1] = '.';
            }
            
            
            
            if (row - 2 > 0) {
                if (this.grid[row - 2][col] == '#') {
                    frontiers.add(new Cell(row - 2, col));
                }
            }
            
            if (row + 2 < this.grid.length - 1) {
                if (this.grid[row + 2][col] == '#') {
                    frontiers.add(new Cell(row + 2, col));
                }
            }
            
            if (col - 2 > 0) {
                if (this.grid[row][col - 2] == '#') {
                    frontiers.add(new Cell(row, col - 2));
                }
            }
            
            if (col + 2 < this.grid[0].length - 1) {
                if (this.grid[row][col + 2] == '#') {
                    frontiers.add(new Cell(row, col + 2));
                }
            }
        }
    }
    
    
    public char[][] getGrid() {
        return this.grid;
    }
    
    
    /** 
    * Puts a wall (character '#') to every cell
    */
    public void init() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                this.grid[i][j] = '#';
            }
        }
    }
    
}
