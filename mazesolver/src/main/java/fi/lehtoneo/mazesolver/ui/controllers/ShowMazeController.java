package fi.lehtoneo.mazesolver.ui.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.lehtoneo.mazesolver.domain.Maze;
import fi.lehtoneo.mazesolver.domain.Prim;
import fi.lehtoneo.mazesolver.domain.Wallfollower;
import fi.lehtoneo.mazesolver.util.Cell;
import java.net.URL;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    private int i = 1;
    
    @FXML
    AnchorPane gridparent;
    
    @FXML
    Button runWf;
    
    @FXML
    Label selectPoints;
    
    @FXML
    Button showWfRoute;
    
    @FXML
    GridPane mazegrid;
    
    Maze m;
    
    List<Cell> wfRoute;
    
    int[] start;
    int[] end;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        start = null;
        end = null;
        wfRoute = new ArrayList<>();
        
        mazegrid.getRowConstraints().remove(0);
        mazegrid.getColumnConstraints().remove(0);
    }   
    
    
    public void initGridToPrimMaze(int height, int width) {
        
        Prim prim = new Prim(height, width);
        prim.generate();
        
        m = new Maze(prim.getGrid());
        
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
                addPane(i, j);
            }
        }
        
        
    }
    
    public void addPane(int i, int j) {
        
        
        AnchorPane pane = new AnchorPane();
        pane.setOnMouseClicked(e -> {
            if (m.getGrid()[i][j] == '.') {
                if (start == null) {
                    int[] newStart = new int[2];
                    newStart[0] = i;
                    newStart[1] = j;
                    start = newStart;
                    pane.setStyle("-fx-background-color:RED");
                    return;
                }
                if (end == null) {
                    int[] newEnd = new int[2];
                    newEnd[0] = i;
                    newEnd[1] = j;
                    pane.setStyle("-fx-background-color:BLUE");
                    end = newEnd;
                    runWf.setVisible(true);
                    selectPoints.setVisible(false);
                }
            }
        });
        if (String.valueOf(m.getGrid()[i][j]).equals("#")) {
            pane.setStyle("-fx-background-color:BLACK");
        } else {
            pane.setStyle("-fx-background-color:WHITE");
        }
        mazegrid.add(pane, j, i);
    }
    
    @FXML
    private void createNew(ActionEvent e) {
        
        int height = mazegrid.getColumnConstraints().size();
        int width = mazegrid.getRowConstraints().size();
        mazegrid.getChildren().removeAll(mazegrid.getChildren());
        
        
        start = null;
        end = null;
        
        showWfRoute.setVisible(false);
        selectPoints.setVisible(true);
        runWf.setVisible(false);
        
        while (mazegrid.getRowConstraints().size() > 0) {
            mazegrid.getRowConstraints().remove(0);
        }

        while (mazegrid.getColumnConstraints().size() > 0) {
            mazegrid.getColumnConstraints().remove(0);
        }
        
        initGridToPrimMaze(height, width);
        
    }
    
    
    @FXML
    private void solveWf(ActionEvent e) {
        Wallfollower wf = new Wallfollower(m.getGrid(), start, end);
        wf.solve();
        wfRoute = wf.getRouteList();
        showWfRoute.setVisible(true);
    }
    
    
    @FXML
    private void showRoute(ActionEvent e) throws InterruptedException {
        ObservableList<Node> children = mazegrid.getChildren();
        
        ArrayList<Pane> listOfPanes = new ArrayList<>();
        
        
        for (int i = 0; i < wfRoute.size() - 1; i++) {
            for (Node node : children) {
                if (mazegrid.getRowIndex(node) == wfRoute.get(i).getRow() && mazegrid.getColumnIndex(node) == wfRoute.get(i).getColumn()) {
                    Pane result = (Pane) node;
                    listOfPanes.add(result);
                    break;
                }
            }
        }
        
        
        helpRouteShow(listOfPanes);
        
        
    
    }
    
    
    private void helpRouteShow(ArrayList<Pane> panes) throws InterruptedException {
        i = 1;

        PauseTransition pause = new PauseTransition(Duration.millis(100));
        pause.setOnFinished(event -> {
        
        
            if (i < panes.size()) {
                
                panes.get(i).setStyle("-fx-background-color:PINK");

                if (i + 1 < panes.size()) {
                    if (panes.get(i + 1).getStyle().equals("-fx-background-color:PINK")) {
                        panes.get(i).setStyle("-fx-background-color:GREY");
                    }
                }
                
                i++;
                pause.play();
                
            }

        });
    
        pause.play();
    }
    
}
