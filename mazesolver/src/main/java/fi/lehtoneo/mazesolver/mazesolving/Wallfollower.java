/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.mazesolving;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.util.Cell;

/**
 * 
 * Class to solve a maze with Wallfollower algorithm
 */
public class Wallfollower {
    
    char[][] maze;
    // 0 down, 1 right, 2 up, 3 left
    int direction;
    private final int down = 3;
    private final int right = 0;
    private final int left = 2;
    private final int up = 1;
    
    ArrayList<Cell> routeList;
    
    private int gX;
    private int gY;
    private int x;
    private int y;
    
     /**
     * 
     * @param grid maze which is solved by method solve()
     * @param start the point where algorithm starts. Here start[0] is x of starting point and start[1] is y of starting point.
     * @param end the point that the algorithm tries to find the path to. Here end[0] is x of ending point and end[1] is y of ending point.
     */
    public Wallfollower(char[][] grid, int[] start, int[] end) {
        this.maze = grid;
        direction = 1;
        
        routeList = new ArrayList();
        
        x = start[0];
        y = start[1];
        
        gX = end[0];
        gY = end[1];
    }
    
     /**
     * 
     * Solves the maze given in constructor with Wallfinder algorithm.
     * It adds every visited maze cell into routeList.
     * After the algorithm is complete, routeList contains the path that the algorithm found.
     */
    public void solve() {
        
        while (true) {
            
            
            routeList.add(new Cell(x, y));
            if (x == gX && y == gY) {
                break;
            }
            
            if (direction == right) {
                if (maze[x + 1][y] == '.') {
                    direction = down;
                    x++;
                } else if (maze[x][y + 1] == '.') {
                    direction = right;
                    y++;
                } else if (maze[x - 1][y] == '.') {
                    x--;
                    direction = up;
                } else {
                    y--;
                    direction = left;
                }
                
            } else if (direction == up) {
                if (maze[x][y + 1] == '.') {
                    direction = right;
                    y++;
                } else if (maze[x - 1][y] == '.') {
                    direction = up;
                    x--;
                } else if (maze[x][y - 1] == '.') {
                    direction = left;
                    y--;
                } else {
                    direction = down;
                    x++;
                }
                
            } else if (direction == left) {
                if (maze[x - 1][y] == '.') {
                    direction = up;
                    x--;
                } else if (maze[x][y - 1] == '.') {
                    direction = left;
                    y--;
                } else if (maze[x + 1][y] == '.') {
                    direction = down;
                    x++;
                } else {
                    direction = right;
                    y++;
                }
                
            } else {
                if (maze[x][y - 1] == '.') {
                    direction = left;
                    y--;
                } else if (maze[x + 1][y] == '.') {
                    direction = down;
                    x++;
                } else if (maze[x][y + 1] == '.') {
                    direction = right;
                    y++;
                } else {
                    direction = up;
                    x--;
                }
            }
        }
        
        
        
    }
    
    public ArrayList<Cell> getRouteList() {
        return routeList;
    }
    
}
