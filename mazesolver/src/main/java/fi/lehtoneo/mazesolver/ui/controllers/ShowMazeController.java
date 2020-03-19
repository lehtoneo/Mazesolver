package fi.lehtoneo.mazesolver.ui.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.lehtoneo.mazesolver.domain.Maze;
import fi.lehtoneo.mazesolver.domain.Prim;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/**
 * FXML Controller class
 *
 * @author ossij
 */
public class ShowMazeController implements Initializable {
    
    @FXML
    AnchorPane gridparent;
    
    @FXML
    GridPane mazegrid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    
    public void initGridToPrimMaze(int height, int width) {
        
        Prim prim = new Prim(height, width);
        prim.generate();
        
        Maze m = new Maze(prim.getGrid());
        
        mazegrid.getRowConstraints().remove(0);
        mazegrid.getColumnConstraints().remove(0);
        
        
        
        for (int i = 0; i < height; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.00 / height);
            mazegrid.getRowConstraints().add(row);
        }
        
        for (int j = 0; j < width; j++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.00 / width);
            mazegrid.getColumnConstraints().add(col);
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                mazegrid.add(new Label(String.valueOf(m.getGrid()[i][j])), i, j);
            }
        }
    }
    
}
