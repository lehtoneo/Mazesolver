# User guide


To run the following commands, navigate to the folder which has pom.xml file under it [(this folder)](https://github.com/lehtoneo/Mazesolver/tree/master/mazesolver). 

I recommend to NOT run tests like this: 

```
mvn test
```

In addition to unit tests, all of the performance tests are run with the command, which might take a while. To run tests, see "Testing" from below.

## Program

To run the program, run the following command: 
```
mvn compile exec:java  -Dexec.mainClass=fi.lehtoneo.mazesolver.ui.MazesolverUi
```
## Testing

First run:

```
mvn compile
```

To run the unit tests, use the following command: 

```
mvn -Dtest=fi.lehtoneo.mazesolver.** test 
``` 

To run all of  the performance tests, use the following command:

``` 
mvn -Dtest=fi.lehtoneo.performance.* test 
```

To run certain performance tests, take a look at [testing](https://github.com/lehtoneo/Mazesolver/blob/master/documentation/testing.md).
