package fi.lehtoneo.mazesolver.ui;

import fi.lehtoneo.mazesolver.domain.Maze;

import javafx.application.Application;
import javafx.stage.Stage;

public class MazesolverUi extends Application {
    
    
    
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("test");
        stage.show();
    }
    
    public static void main(String[] args) {
        Maze m = new Maze();
        System.out.println(m.toString());
        launch(args);
    }
}
