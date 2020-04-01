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
 *
 * @author ossij
 */
public class BFS {
    int start[];
    int end[];
    char[][] maze;
    boolean[][] visited;
    
    int[][][] route;
    
    ArrayList<Cell> routeList;
    private final int gX;
    private final int gY;
    private final int x;
    private final int y;
    
    public BFS(char[][] grid, int[] start, int[] end) {
        maze = grid;
        visited = new boolean[grid.length][grid.length];
        routeList = new ArrayList();
        route = new int[maze.length][maze.length][2];
        
        x = start[0];
        y = start[1];
        
        gX = end[0];
        gY = end[1];
    }
    
    
    public void solveRoute() {
        LinkedList<Cell> stack = new LinkedList();
        stack.add(new Cell(x, y));
        
        
        while(!stack.isEmpty()) {
            
            Cell c = stack.pop();
            int row = c.getRow();
            int col = c.getColumn();
            
            if(!visited[row][col] && !visited[gX][gY]) {
                visited[row][col] = true;
                
                if(row - 1 > 0) {
                    if(maze[row - 1][col] == '.' && !visited[row - 1][col]) {
                        stack.add(new Cell(row - 1, col));
                        route[row - 1][col][0] = row;
                        route[row - 1][col][1] = col;
                    }
                }
                
                if(row + 1 < maze.length) {
                    if(maze[row + 1][col] == '.' && !visited[row + 1][col]) {
                        stack.add(new Cell(row + 1, col));
                        route[row + 1][col][0] = row;
                        route[row + 1][col][1] = col;
                    }
                }
                
                if(col - 1 > 0) {
                    if(maze[row][col - 1] == '.' && !visited[row][col - 1]) {
                        stack.add(new Cell(row, col - 1));
                        route[row][col - 1][0] = row;
                        route[row][col - 1][1] = col;
                        
                    }
                }
                
                if(col + 1 < maze.length) {
                    if(maze[row][col + 1] == '.' && !visited[row][col + 1]) {
                        stack.add(new Cell(row, col + 1));
                        route[row][col + 1][0] = row;
                        route[row][col + 1][1] = col;
                    }
                }
                
            }
        }
        
        
        initRouteList();
        
    }
    
    
    public boolean everythingIsReachableInMaze() {
        LinkedList<Cell> stack = new LinkedList();
        stack.add(new Cell(x, y));
        
        
        while(!stack.isEmpty()) {
            
            Cell c = stack.pop();
            int row = c.getRow();
            int col = c.getColumn();
            
            if(!visited[row][col]) {
                visited[row][col] = true;
                
                if(row - 1 > 0) {
                    if(maze[row - 1][col] == '.' && !visited[row - 1][col]) {
                        stack.add(new Cell(row - 1, col));
                    }
                }
                
                if(row + 1 < maze.length) {
                    if(maze[row + 1][col] == '.' && !visited[row + 1][col]) {
                        stack.add(new Cell(row + 1, col));
                    }
                }
                
                if(col - 1 > 0) {
                    if(maze[row][col - 1] == '.' && !visited[row][col - 1]) {
                        stack.add(new Cell(row, col - 1));
                    }
                }
                
                if(col + 1 < maze.length) {
                    if(maze[row][col + 1] == '.' && !visited[row][col + 1]) {
                        stack.add(new Cell(row, col + 1));
                    }
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
    
    
    public void initRouteList() {
        int gX = this.gX;
        int gY = this.gY;
        ArrayList<Cell> temp = new ArrayList();
        while(gX != x || gY != y) {
            int helpX = gX;
            temp.add(new Cell(gX, gY));
            gX = route[gX][gY][0];
            gY = route[helpX][gY][1];
            
        }
        temp.add(new Cell(x, y));
        
        int j = temp.size() - 1;
        for(int i = 0; i < temp.size(); i++) {
            routeList.add(temp.get(j));
            j--;
        }
    }
    
    public ArrayList<Cell> getRouteList() {
        return routeList;
    }
    
}
