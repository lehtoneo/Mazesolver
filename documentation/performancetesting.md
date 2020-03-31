# Performance testing


## Prim maze generation algorithm

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

The maximum number of verticles in the frontier list is (n*n)/2. The time complexity
 of removing a cell from the list is O(n). Hence the time complexity is O(n*(n*n)/2) = O(n^3). 

Performance tests were made so that 300 of each size maze were created. The time column shows the average time it took to create 
certain size maze. 

Results: 

| Maze size (n x n)  | (E + V)          | Time (ms)
| -------------    |:-------------:| ------------|
| 100x100          | 29800         | 1.04           |
| 127x127          | 48122         | 2.20           |
| 200x200          | 119600        | 8.4         |
| 500x500          | 749000        |  121.00      |
| 625x625          | 1561250       |  243.00      |
| 1000x1000        | 2998000       | 930.00    |
| 1222x1222        | 5970692       | 1802.00    |

( (E + V) = 2n^2-2n + n^2 )
