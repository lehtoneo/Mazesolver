package fi.lehtoneo.mazesolver.mazegeneration;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.util.Random;
import fi.lehtoneo.mazesolver.datastructures.LinkedList;
import fi.lehtoneo.mazesolver.util.Cell;
/**
 * Class to generate a maze with recursive backtracker
 */
public class Backtracker {
    
    char[][] grid;
    boolean[][] visited;
    public Backtracker(int height, int width) {
        grid = new char[height][width];
        init();
    }
    
    /**
    * Generates a maze with recursive backtracker. 
    */
    public void generate() {
        Random r = new Random();
        
        LinkedList<Cell> stack = new LinkedList<>();
        //takes a random starting cell        
        int rX = r.randomInt(grid.length - 2) + 1;
        int rY = r.randomInt(grid[0].length - 2) + 1;
        
        grid[rX][rY] = '.';
        
        stack.add(new Cell(rX, rY));
        
        while (!stack.isEmpty()) {
            Cell curr = stack.pop();
            int x = curr.getRow();
            int y = curr.getColumn();
            
            ArrayList<Cell> unvisitedNeigh = getUnvisitedNeigh(x, y);
            
            if (unvisitedNeigh.size() != 0) {
            stack.push(curr);
            Cell chosen = unvisitedNeigh.get(r.randomInt(unvisitedNeigh.size()));
            connect(curr, chosen);
            stack.push(chosen);
            }
        }
    }
    
    /**
    * Connects two cells. In other words: removes wall between two cells.
    * @param a first of the two cells two be connected
    * @param b second of the two cells to be connected
    */
    public void connect(Cell a, Cell b) {
        int ax = a.getRow();
        int ay = a.getColumn();
        
        int bx = b.getRow();
        int by = b.getColumn();
        grid[bx][by] = '.';
        grid[ax][ay] = '.';
        
        if (bx > ax) {
            grid[ax + 1][ay] = '.'; 
        } else if (bx < ax ) {
            grid[ax - 1][ay] = '.';
        } else if (by > ay) {
            grid[ax][ay + 1] = '.';
        } else if (by < ay){
            grid[ax][ay - 1] = '.';
        }
        
        
        
    }
    
    
    /**
    * Gets unvisited neighbours of a cell.
    * @param i row of the cell
    * @param j col of the cell
    * @return list of unvisited neighbours
    */
    public ArrayList<Cell> getUnvisitedNeigh(int i, int j) {
        ArrayList<Cell> toReturn = new ArrayList();
        
        if(i - 2 >= 1) {
            if(grid[i-2][j] == '#')  {
                toReturn.add(new Cell(i - 2, j));
            } 
        }
        
        if(i + 2 < grid.length - 1) {
            if(grid[i + 2][j] == '#')  {
                toReturn.add(new Cell(i + 2, j));
            } 
        }
        
        if(j - 2 >= 1) {
            if(grid[i][j - 2] == '#')  {
                toReturn.add(new Cell(i, j - 2));
            } 
        }
        
        if(j + 2 < grid.length - 1) {
            if(grid[i][j + 2] == '#')  {
                toReturn.add(new Cell(i, j + 2));
            } 
        }
        
        
        
        return toReturn;
    }
    
    /** 
    * Puts a wall (character '#') to every cell
    */
    public void init() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                this.grid[i][j] = '#';
            }
        }
    }

    public char[][] getGrid() {
        return grid;
    }
    
    
    
}
    

