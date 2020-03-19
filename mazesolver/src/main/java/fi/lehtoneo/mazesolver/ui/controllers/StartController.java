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
    private TextField height;
    
    @FXML
    private TextField width;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void onOkClick() throws Exception {
        
        
        
        try {
            Integer.valueOf(height.getText());
            Integer.valueOf(width.getText());

            
        } catch (Exception e) {
            System.out.println("Please provide number");
            return;
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/showMaze.fxml"));
        Parent root = loader.load();
        
        ShowMazeController controller = loader.<ShowMazeController>getController();
        
        controller.initGridToPrimMaze(Integer.valueOf(height.getText()), Integer.valueOf(height.getText()));
        
        Stage stage = (Stage) height.getScene().getWindow();
        
        stage.setScene(new Scene(root));
        
        
        
        
        
    }
    
    
}
