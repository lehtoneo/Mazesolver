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
mvn compile exec:java -Dexec.mainClass=fi.lehtoneo.mazesolver.ui.MazesolverUi
```

To generate a jar package, run the following command: 

```
mvn -Dmaven.test.skip=true package
```
The jar file can be found from the target folder.

### How to use the program

When the program starts, you have to choose the size of the maze(s) you want to generate. There is no upper limit for the maze size, however, huge mazes can cause crash of the program. There is no upperlimit, because it depends on the computer specs, how big of a maze can be handled. The lower limit of n is 11. 

Once you have decided the maze size and pressed ok, a prim maze is generated. After that you can select start and end points from the maze by clicking path cells (white cells). Then the solve button shows up and by clicking the button, the maze is solved by all of the three algorithms. By clicking some of the 3 show route buttons, a route which the algorithm found is displayed.

You can remove walls from the maze by clicking a wall character after you have chosen start and end points. Then, you can solve the maze again and see the routes after the change. 

When the create new buttons are shown, you can create a new maze by clicking them. After that you have to choose start and end points again.



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
