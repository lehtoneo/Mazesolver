# Testing

## Unit testing



## Performance testing

### Prim maze generation algorithm

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
