# Implementation document

## Prim maze creation algorithm 

### Pseudo code

Frontier of some cell C is a cell with distance 2 from C and it is within the maze and not wall.

1. Choose a random cell R withing the maze grid.
2. Mark R as visited.
3. Add all R's frontier cells to frontier list
4. While frontier list is not empty:

    a) Choose a random frontier A from the list.
    
    b) Remove A from frontier list.
    
    c) Choose a random cell B which is in distance 2 from A and not visited.
    
    d) Connect A with B.
    
    e) Add all B's frontiers to frontier list.

The maximum number of verticles in the frontier list is (n^2)/2. The time complexity
 of removing a cell from the list is O(n). Hence the time complexity is O(n*(n^2)/2) = O(n^3).
