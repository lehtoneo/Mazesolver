package fi.lehtoneo.mazesolver.util;

/**
 *
 * Helps to handle maze cells
 */
public class Cell {
    private int row;
    private int column;
    
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    public boolean equals(Cell c) {
        
        return (this.row == c.getRow() && this.column == c.getColumn());
        
    }
    
    
    
    
}
