# Implementation document

## Overview
The project is written in java. Ui is made with JavaFXML. The mazes generated (and solved) in the project are two dimensional char arrays. "." represents a path cell in a maze and "#" represents a wall cell in a maze. 

### Structure
The project is structured into 6 different folders: datastructures, mazegeneration, mazesolving, ui, util and fxml. The names are somewhat selfexplanatory. 

Datastructures folder contains ArrayList and LinkedList classes.

Mazegeneration contains 3 classes: Backtracker, Prim and Maze. Prim and Backtracker classes take care of mazegeneration and Maze is only a helper class which is used in the ui implementation. 

Mazesolving contains 3 classes: BFS, Tremaux's and WallFollower. All of these classes take the mazegrid to be solved as a parameter. In addition, all of the classes have solve() method, which solves the maze with the corresponding algorithm. In all of the solve()-methods, the order in which the algorithm "visited" the cell, is saved into an ArrayList.

Ui has 3 classes aswell: MazesolverUI and two controller classes; ShowMazeController and StartController. MazesolverUI has the Main class of the project. The two controller classes take care of the ui. 

Util folder contains Cell, Node and Random classes. Cell is a helper class, which helps to handle maze verticles. Node is a helper class, which helps the implementation of LinkedList. Random class is only used to create a random integer. 

Fxml folder contains the two fxml files of the ui. 

### How it works (in a nutshell)
As said above, a maze is saved as two dimensional nxn array where "." represents a path cell in a maze and "#" represents a wall cell in a maze. When selecting maze size and clicking ok, a maze is generated with prim's algorithm. The maze is then "drawn" like this: a GridPane with the size of nxn is created. All of the cells of the GridPane are filled with Panes of which backgrounds are colored as black or white, depending on if the corresponding maze cell is wall or path.

When the maze is drawn and user has selected start and endpoints, when clicking solve, the start and endpoints are given to each of the algorithms and the algorithms solve the maze. When it is solved, the routelists of the algorithms are saved. 

Now when the routelists are saved and user clicks some of the "show route" buttons, the cells from the routelist are searched from the grid and saved to a list of panes. This list of panes is then given to animateRoute()-method, which color's the panes in order. 


## Pseudo codes and O-analyses

### Prim maze creation algorithm 


The algorithm gets n x m sized maze as an input. The maze given to the algorithm is filled with 
wall character '#'. For the sake of simplicity, 
all mazes given to the algorithm in the project are sized n x n. 

#### Pseudo code

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

Space complexity is O(n^2).

 ### Recursive backtracker 
 
The algorithm gets n x n sized maze as an input. The maze given to the algorithm is filled with wall character '#'. 

 #### Pseudo code
 
 https://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_backtracker (the second one)
 
 
 The time complexity is O(E+V), and space complexity is O(n^2)
 
 ### Wall follower
 
 The implemented wall follower uses "right-hand rule". The algorithm might not work if there are loops in the maze. 
 
 #### Pseudo code
 
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

The space complexity is O(n^2) where n is the width and height of the maze to be solve. The reason for this is that the algorithm saves the entire maze, including the walls. 

### Tremaux's

The algorithm works with and without loops in the maze.

#### Pseudo code
        
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

The space complexity is O(n^2) where n is the width and height of the maze to be solve. The reason for this is that the algorithm saves the entire maze, including the walls. 
 
### Shortest path algorithm (with BFS)
 
The algorithm works with and without loops in the maze.

#### Pseudo code

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

The space complexity is O(n^2) where n is the width and height of the maze to be solve. The reason for this is that the algorithm saves visited array size of nxn.

## Possible improvements

The ShowMazeController is somewhat long. It could be divided into seperate classes. 

Some of the algorithms could be implemented more elegantly for instance tremaux's algorithm.

#### Sources
- https://en.wikipedia.org/wiki/Maze_solving_algorithm#Tr%C3%A9maux's_algorithm
- https://blog.jamisbuck.org/2014/05/12/tremauxs-algorithm.html
- https://en.wikipedia.org/wiki/Depth-first_search
- https://en.wikipedia.org/wiki/Maze_solving_algorithm
- http://www.astrolog.org/labyrnth/algrithm.htm
- https://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_backtracker
