/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.mazesolving;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.datastructures.LinkedList;
import fi.lehtoneo.mazesolver.util.Cell;

/**
 * Class to solve a maze with BFS
 */
public class BFS {
    
    char[][] maze;
    boolean[][] visited;
    
    int[][][] route;
    
    ArrayList<Cell> routeList;
    ArrayList<Cell> goBackList;
    private final int gX;
    private final int gY;
    private final int x;
    private final int y;
    
    /**
     * 
     * @param grid maze which is solved
     * @param start the point where algorithm starts. Here start[0] is x of starting point and start[1] is y of starting point.
     * @param end the point that the algorithm tries to find the path to. Here end[0] is x of ending point and end[1] is y of ending point.
     */
    public BFS(char[][] grid, int[] start, int[] end) {
        maze = grid;
        visited = new boolean[grid.length][grid.length];
        routeList = new ArrayList();
        goBackList = new ArrayList();
        route = new int[maze.length][maze.length][2];
        
        x = start[0];
        y = start[1];
        
        gX = end[0];
        gY = end[1];
    }
    
    /**
    * Solves the maze given in constructor with BFS.
    * After the algorithm is complete, routeList contains every visited cell in the order they were visited  
    * and goBackRoute contains the shortest path in reverse order.
    */
    public void solveRoute() {
        LinkedList<Cell> stack = new LinkedList();
        stack.add(new Cell(x, y));
        
        
        while(!stack.isEmpty()) {
            
            if(visited[gX][gY]) {
                break;
            }
            
            Cell c = stack.pop();
            int row = c.getRow();
            int col = c.getColumn();
            
            if(!visited[row][col]) {
                visited[row][col] = true;
                routeList.add(c);
                    if(maze[row - 1][col] == '.' && !visited[row - 1][col]) {
                        stack.add(new Cell(row - 1, col));
                        route[row - 1][col][0] = row;
                        route[row - 1][col][1] = col;
                    }
                
                
                    if(maze[row + 1][col] == '.' && !visited[row + 1][col]) {
                        stack.add(new Cell(row + 1, col));
                        route[row + 1][col][0] = row;
                        route[row + 1][col][1] = col;
                    }
                
                
                    if(maze[row][col - 1] == '.' && !visited[row][col - 1]) {
                        stack.add(new Cell(row, col - 1));
                        route[row][col - 1][0] = row;
                        route[row][col - 1][1] = col;
                        
                    }
                
                
                    if(maze[row][col + 1] == '.' && !visited[row][col + 1]) {
                        stack.add(new Cell(row, col + 1));
                        route[row][col + 1][0] = row;
                        route[row][col + 1][1] = col;
                    }
                
                
            }
        }
        
        
        initGoBackList();
        
    }
    
    /**
    * Checks if every path cell '.' in maze is reachable
    * @return true if every path cell '.' in maze is reachable.
    */
    public boolean everythingIsReachableInMaze() {
        LinkedList<Cell> stack = new LinkedList();
        stack.add(new Cell(x, y));
        
        
        while(!stack.isEmpty()) {
            
            Cell c = stack.pop();
            int row = c.getRow();
            int col = c.getColumn();
            
            if(!visited[row][col]) {
                visited[row][col] = true;
                
                    if(maze[row - 1][col] == '.' && !visited[row - 1][col]) {
                        stack.add(new Cell(row - 1, col));
                    }
                
                
                    if(maze[row + 1][col] == '.' && !visited[row + 1][col]) {
                        stack.add(new Cell(row + 1, col));
                    }
                
                
                    if(maze[row][col - 1] == '.' && !visited[row][col - 1]) {
                        stack.add(new Cell(row, col - 1));
                    }
                
                
                    if(maze[row][col + 1] == '.' && !visited[row][col + 1]) {
                        stack.add(new Cell(row, col + 1));
                    }
            }

        
    }
        
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == '.' && visited[i][j] == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Follows the found path from end to start and adds every cell to goBackList
     */
    public void initGoBackList() {
        int gX = this.gX;
        int gY = this.gY;
        
        while(gX != x || gY != y) {
            int helpX = gX;
            goBackList.add(new Cell(gX, gY));
            gX = route[gX][gY][0];
            gY = route[helpX][gY][1];
            
        }
        goBackList.add(new Cell(gX, gY));
        
    }
    
    public ArrayList<Cell> getRouteList() {
        return routeList;
    }
    
    public ArrayList<Cell> getGoBackList() {
        return goBackList;
    }
    
    
    
}
