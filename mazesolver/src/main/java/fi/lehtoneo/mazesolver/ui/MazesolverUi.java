package fi.lehtoneo.mazesolver.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MazesolverUi extends Application {
    
    
    /*
    * Loads and shows the starting screen for user
    */
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/start.fxml"));
        
        stage.setTitle("Mazesolver");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
