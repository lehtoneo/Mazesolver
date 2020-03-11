# Project definition

The purpose of the project is to implement pathfinding algorithms for a maze which is made of two dimensional ASCII characters array. 
The program is implemented so that it is only possible to move left, right, up or down in the maze.
These mazes can be considered as graphs. Every (non-wall) element in the array is a graph node. For example, if an (non-wall) element 
in the maze is surrounded by walls, except from the left, the corresponding node has one edge. 

The user can create his/her own maze with start point, end point and walls or he/she can use hard coded 
mazes to test the algorithms.

The project is built with Java. 

## Algorithms

The algorithms that are used are [Breadth-first search](https://en.wikipedia.org/wiki/Breadth-first_search) (BFS)
and [A*](https://en.wikipedia.org/wiki/A*_search_algorithm). Manhattan distance will be used as a heuristic in A*.

## Datastructures

For BFS, a queue needs to be implemented which will be used by adjacency list and for BFS queue. 

For A*, a heap that supports updating of elements needs to be implemented for the open list.

There might be other datastructures that need to be implemented. They will be added here.



## Input and output

If the user chooses to create an own maze, first the user has to give the maze size as input. After that, he/she has to select start point 
and end point from the maze. If the user wants to, he/she can put walls to the maze. 

When the user starts clicks start, the shortest route from start to end is given and also the time it took for both algorithms 
to find the route.

## Time and space complexity goals


### BFS

#### Time

The goal for BFS time complexity is O(V + E), where V is the number of verticles (nodes) in the graph and E is the number of edges 
in the graph. 

#### Space

The goal for BFS space complexity is O(V), where V is the total number of verticles.


### A* 

#### Time

The goal for A* time complexity is O(E), where E is the number of edges in the graph.

#### Space

The goal for A* space complexity is O(V), where V is the total number of verticles.




#### Sources

- https://en.wikipedia.org/wiki/A*_search_algorithm
- https://en.wikipedia.org/wiki/Depth-first_search
- https://en.wikipedia.org/wiki/Maze_solving_algorithm
- https://www.geeksforgeeks.org/a-search-algorithm/
