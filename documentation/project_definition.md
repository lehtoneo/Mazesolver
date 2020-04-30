# Project definition

The purpose of the project is to implement maze creation algorithms and maze solving algorithms for the created maze. The maze is a two dimensional ASCII characters array. 
The program is implemented so that it is only possible to move left, right, up or down in the maze.

The project is built with Java. 

## Algorithms

### Maze creation

The first algorithm to generate a maze is modified version of Prim's algorithm. (The description can be found [here](http://www.astrolog.org/labyrnth/algrithm.htm)).

The second algorithm is Recursive backtracker. I chose this algorithm, because it generates mazes which look a lot different compared to 
the Prim's algorithm. 

### Maze solving

An algorithm to find the shortest path is called [shortest path algorithm](https://en.wikipedia.org/wiki/Maze_solving_algorithm#Shortest_path_algorithm). I will implement it by using [Breadth-first search](https://en.wikipedia.org/wiki/Breadth-first_search) (BFS). Prim's algorithm for maze creation should create a 'perfect' maze, which means that every part of the maze should be reachable. BFS will also be used to test this.

Another algorithm to find a path in maze between two points is [Wall follower](https://en.wikipedia.org/wiki/Maze_solving_algorithm#Wall_follower).

Third algorithm to find paths between two points in maze is [Tremaux's algorithm](https://en.wikipedia.org/wiki/Maze_solving_algorithm#Tr%C3%A9maux's_algorithm).

If there is time, more algorithms will be added.

## Datastructures

For Prim's algorithm and wall follower, a list needs to be implemented.

For shortest path algorithm, a queue needs to be implemented. 

There might be other datastructures that need to be implemented. They will be added here.



## Input and output

User can select how big maze they want the prim's algorithm to create. After that they can select start and end points from the maze and see how different algorithm's solve the maze. The user can also remove walls from the maze.

## Time and space complexity goals


### Shortest path algorithm

#### Time

The goal for time complexity is O(V + E), where V is the number of verticles (path cells) in the maze and E is the number of edges (path cells connected)
in the graph. 



### Prim's algorithm (modified)

#### Time

The goal for time complexity is O(E + V), where E is the total number of edges and V is the total number of verticles.

#### Space

The goal for space complexity is O(E), where E is the total number of edges.


### Wall follower

#### Time

The goal for time complexity is O(E+V), where E is the total number of edges and V is the total number of verticles.

#### Space

The goal for space complexity is O(E), where E is the total number of edges.

### Tremaux's

#### Time

The goal for time complexity is O(V), where V is the total number of verticles (path cells) in the maze.

#### Space

The goal for space complexity is O(E), where E is the total number of edges.

#### Sources

- https://en.wikipedia.org/wiki/Maze_solving_algorithm#Tr%C3%A9maux's_algorithm
- https://en.wikipedia.org/wiki/Depth-first_search
- https://en.wikipedia.org/wiki/Maze_solving_algorithm
- http://www.astrolog.org/labyrnth/algrithm.htm
- https://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_backtracker
