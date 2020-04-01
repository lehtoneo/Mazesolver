# User guide

## Program

To run the program, run the following command: 
```
mvn exec:java  -Dexec.mainClass=fi.lehtoneo.mazesolver.ui.MazesolverUi
```
## Testing

To run the unit tests, use the following command: 

```
mvn -Dtest=fi.lehtoneo.mazesolver.** test 
``` 

To run all of  the performance tests, use the following command:

``` 
mvn -Dtest=fi.lehtoneo.performance.* test 
```
