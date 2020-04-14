# Implementation document

## Prim maze creation algorithm 


The algorithm gets n x m sized maze as an input. The maze given to the algorithm is filled with 
wall character '#'. For the sake of simplicity, 
all mazes given to the algorithm in the project are sized n x n. 

### Pseudo code

Frontier of some cell C is a cell with distance 2 from C and it is within the maze and not wall.

    Choose a random cell R withing the maze grid.
    Mark R as visited.
    Add all R's frontier cells to frontier list
    While frontier list is not empty:

        Choose a random frontier A from the list.

        Remove A from frontier list.

        Choose a random cell B which is in distance 2 from A and not visited.

        Connect A with B.

        Add all B's frontiers to frontier list.

The maximum number of verticles in the frontier list is (n^2). The time complexity
of removing a cell from the list is O(n). Hence the time complexity is O(n*(n^2)) = O(n^3). 

The time complexity can be also expressed as O(E+V).

 
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
                    
    This is done for every other possible directions (left, up, down)
    
The worst case scenario is that the algorithm has to visit every verticle twice. Hence, if we have V verticles in a  maze, the time complexity is  O(2V) = O(V).

## Tremaux's

The algorithm works with and without loops in the maze.

### Pseudo code
        
    The algorithm can be in two states: going forward or not going forward (going backwards).

    while not in the end point
        if going forward

            if you are in an intersection 
                if you haven't been in the intersection
                    take a random path from the intersection and continue going forward
                    mark the cell you came from
                else (you have been in the intersection)
                    going forward = false

        else (going backwards)

            if you are in an intersection
                if there are unvisited paths you can take from the intersection
                    take a random unvisited path
                    going forward = true
                 else (there are not unvisited paths you can take from the intersection)
                    go back from the cell you first came to the intersection
 
The worst case scenario is that the algorithm has to visit every verticle twice. Hence, if we have V verticles in a  maze, the time complexity is  O(2V) = O(V).
 
## Shortest path algorithm (with BFS)
 
The algorithm works with and without loops in the maze.

### Pseudo code

    put starting verticle in the stack

    while stack is not empty or we are in the end point

        get first verticle (v) from the stack
        if not visited v
            for each veticle v2 you can go from v 
                if not visited v2
                    add v as parent of v2
                    add v2 to stack

    traceback from end point to start every verticles parent.


The time complexity of the algorithm is O(V) where V is the number of verticles. It may look like the time complexity is O(v^2) since there is a loop inside a loop, but every verticle has up to 4 verticles you can go to. Hence the upper limit of actions is V + 4V which leads to the time complexity of O(V).  
