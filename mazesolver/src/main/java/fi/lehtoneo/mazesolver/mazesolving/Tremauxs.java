/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.mazesolving;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.util.Cell;
import java.util.Random;
/**
 * 
 * Class to solve a maze with Tremaux's algorithm
*/
public class Tremauxs {

    char[][] maze;
    int[][] visited;
    
    private int[][][] exit;
    ArrayList<Cell> routeList;
    private final int gX;
    private final int gY;
    private int x;
    private int y;
    
    private boolean[][] isIntersection;
    
    private final int startX;
    private final int startY;
    private int[][][] parent;
    
    /**
     * 
     * @param grid maze which is solved
     * @param start the point where algorithm starts. Here start[0] is x of starting point and start[1] is y of starting point.
     * @param end the point that the algorithm tries to find the path to. Here end[0] is x of ending point and end[1] is y of ending point.
     */
    public Tremauxs(char[][] grid, int[] start, int[] end) {
        maze = grid;
        visited = new int[grid.length][grid.length];
        routeList = new ArrayList();
        isIntersection = new boolean[grid.length][grid.length];
        parent = new int[grid.length][grid.length][2];
        
        x = start[0];
        y = start[1];
        startY = x;
        startX = y;
        exit = new int[grid.length][grid.length][2];
        gX = end[0];
        gY = end[1];
    }
    /**
     * 
     * Solves the maze given in constructor with Tremaux's algorithm.
     * It adds every visited maze cell into routeList.
     */
    public void solve() {
        Random r = new Random();
        
        routeList.add(new Cell(x, y));
        visited[x][y] = 1;
        int helpX = x;
        int helpY = y;
        
        if(maze[x+1][y] == '.') {
            x++;
            parent[x][y][0] = helpX;
            parent[x][y][1] = helpY;
            
        } else if (maze[x-1][y] == '.') {
            x--;
            parent[x][y][0] = helpX;
            parent[x][y][1] = helpY;
        } else if (maze[x][y-1] == '.') {
            y--;
            parent[x][y][0] = helpX;
            parent[x][y][1] = helpY;
        } else {
            y++;
            parent[x][y][0] = helpX;
            parent[x][y][1] = helpY;
        }
        
        boolean goingForward = true;
        
        while(x != gX || y != gY) {
            visited[x][y] = 1;
            
            routeList.add(new Cell(x, y));
            
            if(goingForward) {
                ArrayList<Cell> possible = getPossibleDirections(x, y);
                
                
                if(isIntersection(x, y)) {
                    
                    //non visited intersection, take some path
                    if(exit[x][y][0] == 0) {
                        
                        Cell prev = routeList.get(routeList.size()-2);
                        
                        exit[x][y][0] = prev.getRow();
                        exit[x][y][1] = prev.getColumn();
                        Cell next = possible.get(r.nextInt(possible.size()));
                        
                        parent[next.getRow()][next.getColumn()][0] = x;
                        parent[next.getRow()][next.getColumn()][1] = y;
                        
                        x = next.getRow();
                        y = next.getColumn();
                        // visited intersection, go back
                    } else {
                        
                        Cell c = routeList.get(routeList.size()-2);
                        x = c.getRow();
                        y = c.getColumn();
                        goingForward = false;
                    }
                    continue;
                } 
                
                if(possible.size() == 0) {
                    Cell prev = routeList.get(routeList.size() - 2);
                    x = prev.getRow();
                    y = prev.getColumn();
                    goingForward = false;
                    
                //just normal path, continue
                } else {
                    Cell next = possible.get(0);
                    
                    parent[next.getRow()][next.getColumn()][0] = x;
                    parent[next.getRow()][next.getColumn()][1] = y;
                    x = next.getRow();
                    y = next.getColumn();
                } 
                
            } else {
                
                if(!isIntersection(x, y)) {
                    helpX = x;
                    helpY = y;
                    x = parent[helpX][helpY][0];
                    y = parent[helpX][helpY][1];
                    continue;
                }
                
                
                ArrayList<Cell> possible = getPossibleGoingbackDirections(x, y);
                if(possible.size() == 0) {
                    helpX = x;
                    helpY = y;
                    x = exit[helpX][helpY][0];
                    y = exit[helpX][helpY][1];
                } else {
                    
                    Cell next = possible.get(r.nextInt(possible.size()));
                    
                    parent[next.getRow()][next.getColumn()][0] = x;
                    parent[next.getRow()][next.getColumn()][1] = y;
                    x = next.getRow();
                    y = next.getColumn();
                    goingForward = true;
                }
            }
            
        }
        routeList.add(new Cell(gX, gY));
        
    }
    
    
    

    /**
     * Check's if a cell is an intersection.
     * @param x x coordinate of the cell
     * @param y y coordinate of the cell
     * @return true if a cell is an intersection
     */
    private boolean isIntersection(int x, int y) {
        int h = 0;
        if(isIntersection[x][y]) {
            return true;
        }
        if(maze[x+1][y] == '.') {
            h++;
        }
        if(maze[x-1][y] == '.') {
            h++;
        }
        if(maze[x][y+1] == '.') {
            h++;
        }
        if(maze[x][y-1] == '.') {
            h++;
        }
        
        if(h > 2 || (x == startY && y == startX)) {
            isIntersection[x][y] = true;
        }
        
        return h > 2 || (x == startY && y == startX);
    
    }
    
    
    /**
     * Get's possible direction's where to go from given cell when going forward.
     * @param x x coordinate of the cell
     * @param y y coordinate of the cell
     * @return the possible directions as a list of cells.
     */
    private ArrayList<Cell> getPossibleDirections(int x, int y) {
        ArrayList<Cell> possible = new ArrayList();
        Cell prev = routeList.get(routeList.size()-2);
        int prevX = prev.getRow();
        int prevY = prev.getColumn();
        
        if(prevX < x) {
            if(maze[x + 1][y] == '.') {
                possible.add(new Cell(x + 1, y));
            }
            if(maze[x][y + 1] == '.') {
                possible.add(new Cell(x, y + 1));
            }
            if(maze[x][y - 1] == '.') {
                possible.add(new Cell(x, y - 1));
            }
        } else if (prevX > x) {
            if(maze[x - 1][y] == '.') {
                possible.add(new Cell(x - 1, y));
            }
            if(maze[x][y + 1] == '.') {
                possible.add(new Cell(x, y + 1));
            }
            if(maze[x][y - 1] == '.') {
                possible.add(new Cell(x, y - 1));
            }
        } else if (prevY < y) {
            if(maze[x][y + 1] == '.') {
                possible.add(new Cell(x, y + 1));
            }
            if(maze[x + 1][y] == '.') {
                possible.add(new Cell(x + 1, y));
            }
            if(maze[x - 1][y] == '.') {
                possible.add(new Cell(x - 1, y));
            }
        } else {
            if(maze[x][y - 1] == '.') {
                possible.add(new Cell(x, y - 1));
            }
            if(maze[x + 1][y] == '.') {
                possible.add(new Cell(x + 1, y));
            }
            if(maze[x - 1][y] == '.') {
                possible.add(new Cell(x - 1, y));
            }
        }
        
        return possible;
        
    }
    /**
     * Get's possible direction's where to go from given cell when going backwards.
     * @param x x coordinate of the cell
     * @param y y coordinate of the cell
     * @return the possible directions as a list of cells.
     */
    private ArrayList<Cell> getPossibleGoingbackDirections(int x, int y) {
        ArrayList<Cell> possible = new ArrayList();
        
        if(visited[x + 1][y] != 1) {
            if(maze[x + 1][y] == '.') {
                possible.add(new Cell(x + 1, y));
            }
        } 
        
        if(visited[x - 1][y] != 1) {
            if(maze[x - 1][y] == '.') {
                possible.add(new Cell(x - 1, y));
            }
        }
        
        if(visited[x][y + 1] != 1) {
            if(maze[x][y + 1] == '.') {
                possible.add(new Cell(x, y + 1));
            }
        }
        
        if(visited[x][y - 1] != 1) {
            if(maze[x][y - 1] == '.') {
                possible.add(new Cell(x, y - 1));
            }
        }
        
        return possible;
        
    }

    public ArrayList<Cell> getRouteList() {
        return routeList;
    }
    
    
    
    
}
