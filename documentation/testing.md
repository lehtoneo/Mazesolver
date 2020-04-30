# Testing

## Unit testing

The UI is not tested with unit tests. It has only been tested manually. 

The test coverage is 95%, but it doesn't take the lack of UI tests into account. The unit tests can be found [here](https://github.com/lehtoneo/Mazesolver/tree/master/mazesolver/src/test/java/fi/lehtoneo/mazesolver). 


## Performance testing

### Maze creation

#### Prim maze generation algorithm

Performance tests were made so that 300 of each size maze were created. The time column shows the average time it took to create 
certain size maze. 

Results: 

| Maze size (n x n)  | (E + V)          | Time (ms)
| -------------    |:-------------:| ------------|
| 100x100          | 29800         | 0.01           |
| 127x127          | 48122         | 0.47           |
| 200x200          | 119600        | 2.12         |
| 500x500          | 749000        | 26.55      |
| 625x625          | 1561250       | 48.25      |
| 1000x1000        | 2998000       | 175.41    |
| 1222x1222        | 5970692       | 304.22    |

![Prim perf](https://github.com/lehtoneo/Mazesolver/blob/master/documentation/pictures/Primperf.png)

The growth seems to be exponential over n, as expected.

Re-run: 

```
mvn -Dtest=PrimPerformanceTest test
```

### Recursive backtracker 


Results: 

| Maze size (n x n)  | (E + V)          | Time (ms)
| -------------    |:-------------:| ------------|
| 100x100          | 29800         | 0.003           |
| 127x127          | 48122         | 0.13           |
| 200x200          | 119600        | 1.32         |
| 500x500          | 749000        | 9.8      |
| 625x625          | 1561250       | 14.2      |
| 1000x1000        | 2998000       | 37.99    |
| 1222x1222        | 5970692       | 57.87    |

![Backtracker](https://github.com/lehtoneo/Mazesolver/blob/master/documentation/pictures/Backtrackerperf.png)

The growth is exponential over n and linear over E + V, as expected.

Re-run: 

```
mvn -Dtest=BacktrackerPerformanceTest test
```

### Maze solving
For each maze solved by the algorithms below, performance tests were made so that 300 of each size maze were created by prim's algorithm. The time column shows the average time it took to solve the maze. The starting point for the algorithms were always the top-left path cell in the maze, and the ending point was the most right path cell in the last row. 

"V" in the tables below, is the estimate of path cells in the maze, which is calculated like this: V = (n * n)/2.  

The time column shows the average time it took to solve the maze. 

The length column shows the average length of the path that the algorithm found.

#### Tremaux's maze solving algorithm 



Results: 

| Maze size (n x n)  | V          | Time (ms) | Length |
| -------------    |:-------------:| ------------| :--------: |
| 100x100          | 5000         | 0.02           | 4899 |
| 200x200          | 20000         | 1.1          | 19357 |
| 300x300          | 45000        | 3.4        | 45429 |
| 400x400          | 80000       |  6.7      | 77876 |
| 500x500          | 125000      | 13.4      | 122672 |
| 600x600          | 180000      | 18.715    | 183658 |

![Trem](https://github.com/lehtoneo/Mazesolver/blob/master/documentation/pictures/Tremperf.png)

It seems that the time is increasing linearly over V, as expected.

Re-run: 

```
mvn -Dtest=TremauxsPerformanceTest test
```

#### Wall follower 


Results: 

| Maze size (n x n)  | V          | Time (ms)    | Length |  
| -------------    |:-------------:| ------------|:-------:|
| 100x100          | 5000         | 0.003        | 4959    |
| 200x200          | 20000         | 0.02        | 18955   |
| 300x300          | 45000        | 0.28        |  43514 |
| 400x400          | 80000       |  0.85      | 78831 |
| 500x500          | 125000      | 1.8      | 127102 |
| 600x600          | 180000      | 2.78    | 178981 |

![WallFollower](https://github.com/lehtoneo/Mazesolver/blob/master/documentation/pictures/WallFollowerperf.png)

It seems that the time is increasing linearly over V, as expected.


Re-run: 

```
mvn -Dtest=WallFollowerPerformanceTest test
```

#### Shortest path (using bfs)

Results: 

| Maze size (n x n)  | V          | Time (ms)    | Length |  
| -------------    |:-------------:| ------------|:-------:|
| 100x100          | 5000         | 0.006        | Shortest    |
| 200x200          | 20000         | 0.89        | Shortest   |
| 300x300          | 45000        | 2.69       |  Shortest |
| 400x400          | 80000       |  5.62     | Shortest |
| 500x500          | 125000      | 9.44      | Shortest |
| 600x600          | 180000      | 14.28    | Shortest |

![shortestpath](https://github.com/lehtoneo/Mazesolver/blob/master/documentation/pictures/Shortestpathperf.png)

It seems that the time is increasing linearly over V, as expected.

Re-run: 

```
mvn -Dtest=BFSPerformanceTest test
```

