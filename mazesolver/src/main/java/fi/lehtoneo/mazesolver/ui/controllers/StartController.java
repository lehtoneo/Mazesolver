package fi.lehtoneo.mazesolver.ui.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Controls the first scene user sees
 * @author ossij
 */
public class StartController implements Initializable {
    
    
    @FXML
    private TextField n;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    /*
    * Handles ok click
    */
    @FXML
    public void onOkClick() throws Exception {
        
        
        
        try {
            Integer.valueOf(n.getText());

            
        } catch (Exception e) {
            System.out.println("Please provide number");
            return;
        }
        if(Integer.valueOf(n.getText()) < 11) {
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/showMaze.fxml"));
        Parent root = loader.load();
        
        ShowMazeController controller = loader.<ShowMazeController>getController();
        
        controller.createPrimMaze(Integer.valueOf(n.getText()), Integer.valueOf(n.getText()));
        
        Stage stage = (Stage) n.getScene().getWindow();
        
        stage.setScene(new Scene(root));
        
        
        
        
        
    }
    
    
}
