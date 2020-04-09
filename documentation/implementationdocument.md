# Implementation document

## Prim maze creation algorithm 


The algorithm gets n x m sized maze as an input. The maze given to the algorithm is filled with 
wall character '#'. For the sake of simplicity, 
all mazes given to the algorithm in the project are sized n x n. 

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
 
 ## Wall follower
 
 The implemented wall follower uses "right-hand rule". The algorithm might not work if there are loops in the maze. 
 
 ### Pseudo code
 
Initialize direction as right. 

while you are not in the end point
    if you are going right
        try to go down
        if you can't go down (there is a wall below you)
            try to go right
            if you can't go right
                try to go up
                if you can't go up
                    go left
    This is done for every possible direction (left, right, up, down)
    
The worst case scenario is that the algorithm has to visit every verticle twice. Hence, if we have V verticles in a  maze, the timecomplexity is  O(2V) = O(V).
        
    

