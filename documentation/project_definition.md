# Project definition

The purpose of the project is to implement maze creation algorithms and maze solving algorithms for the created maze. The maze is a two dimensional ASCII characters array. 
The program is implemented so that it is only possible to move left, right, up or down in the maze.

The project is built with Java. 

## Algorithms

The algorithm that generates the maze is modified version of Prim's algorithm. (The description can be found [here](http://www.astrolog.org/labyrnth/algrithm.htm)).

The algorithm to find the shortest path is called [shortest path algorithm](https://en.wikipedia.org/wiki/Maze_solving_algorithm#Shortest_path_algorithm). I will implement it by using [Breadth-first search](https://en.wikipedia.org/wiki/Breadth-first_search) (BFS).

Prim's algorithm for maze creation should create a 'perfect' maze, which means that every part of the maze should be reachable. To test this, a [Depth-first search](https://en.wikipedia.org/wiki/Depth-first_search) needs to be implemented.

If there is time, more algorithms will be added.

## Datastructures

For Prim's algorithm, atleast a linkedlist needs to be implemented. 

For shortest path algorithm, a queue needs to be implemented which will be used for BFS queue. 

There might be other datastructures that need to be implemented. They will be added here.



## Input and output

If the user chooses to create an own maze, first the user has to give the maze size as input. After that, he/she has to select start point 
and end point from the maze. If the user wants to, he/she can put walls to the maze. 

If the user chooses that the maze creation algorithm should create the maze, the user should only give the maze size as an input.

When the user starts clicks start, the shortest route from start to end is given and also the time it took for algorithm(s) 
to find the route.

## Time and space complexity goals


### Shortest path algorithm

#### Time

The goal for time complexity is O(V + E), where V is the number of verticles (path cells) in the maze and E is the number of edges (path cells connected)
in the graph. 

#### Space

The goal for space complexity is O(V), where V is the total number of verticles.


### Prim's algorithm (modified)

#### Time

The goal for time complexity is O(E + V), where E is the total number of edges and V is the total number of verticles.

#### Space

The goal for space complexity is O(E), where E is the total number of edges.

### Depth-first search

### Time

The goal for time complexity is O(E + V), where E is the total number of edges and V is the total number of verticles.

### Space

The goal for space complexity is O(V), where V is the total number of edges.

#### Sources

- https://en.wikipedia.org/wiki/A*_search_algorithm
- https://en.wikipedia.org/wiki/Depth-first_search
- https://en.wikipedia.org/wiki/Maze_solving_algorithm
- https://www.geeksforgeeks.org/a-search-algorithm/
- http://www.astrolog.org/labyrnth/algrithm.htm
