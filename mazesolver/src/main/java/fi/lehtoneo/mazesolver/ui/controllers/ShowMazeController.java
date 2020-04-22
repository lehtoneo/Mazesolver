package fi.lehtoneo.mazesolver.ui.controllers;



import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.mazegeneration.Maze;
import fi.lehtoneo.mazesolver.mazegeneration.Prim;
import fi.lehtoneo.mazesolver.mazesolving.BFS;
import fi.lehtoneo.mazesolver.mazesolving.WallFollower;
import fi.lehtoneo.mazesolver.mazesolving.Tremauxs;
import fi.lehtoneo.mazesolver.mazegeneration.Backtracker;
import fi.lehtoneo.mazesolver.util.Cell;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/**
 * FXML Controller
 * class for showing maze and the solutions
 * @author lehtoneo
 */
public class ShowMazeController implements Initializable {
    private int i = 1;
    private boolean showingBFS = false;
    private boolean edited = false;
    private boolean showing = false;
    private double speed = 0.1;
    @FXML
    AnchorPane gridparent;
    
    @FXML
    Button solve;
    
    @FXML
    Button createNew;
    
    @FXML
    Button createNewBt;
    
    @FXML
    Button resetPath;
    
    @FXML
    Label selectPoints;
    
    @FXML
    Button showWfRoute;
    
    @FXML
    Button showBFSRoute;
    
    @FXML
    Button showTremRoute;
    
    @FXML
    GridPane mazegrid;
    
    @FXML
    AnchorPane timeTable;
    
    @FXML
    Label wfTime;
    @FXML
    Label bfsTime;
    @FXML
    Label tremTime;
    
    Maze m;
    
    ArrayList<Cell> wfRoute;
    ArrayList<Cell> bfsRoute;
    ArrayList<Cell> tremRoute;
    ArrayList<Cell> bfsGoBack;
    
    int[] start;
    int[] end;
    
    /**
    * Initializes the controller
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    /**
    * Makes the gridpane look like a prim maze
    * @param height - the height of the maze, also the number of rows to be put to the gridpane
    * @param width - the width of the maze, also the number of columns to be put to the gridpane
    */
    public void createPrimMaze(int height, int width) {
        init();
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
    
    public void createBacktrackerMaze(int height, int width) {
        init();
        Backtracker bt = new Backtracker(height, width);
        bt.generate();
        
        m = new Maze(bt.getGrid());
        
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
    /**
    * Adds Pane objects to grid cells
    * @param i - row number of the cell
    * @param j - column number of the cell
    */
    public void addPane(int i, int j) {
        
        
        AnchorPane pane = new AnchorPane();
        
        if(i != 0 && i != m.getGrid().length - 1 && j != 0 && j != m.getGrid().length - 1) {
        //adds event listener to each cell, this makes it possible to select start and endpoints, and delete walls
        pane.setOnMouseClicked(e -> {
            onPaneClick(i, j, pane);
        });
        }
        if (m.getGrid()[i][j] == '#') {
            pane.setStyle("-fx-background-color:BLACK");
        } else {
            pane.setStyle("-fx-background-color:WHITE");
        }
        mazegrid.add(pane, j, i);
    }
    
    /**
    * Handles pane click
    * @param i - row number of the pane
    * @param j - columnd number of the pane
    * @param pane - the pane of which state is to be changed
    */
    private void onPaneClick(int i, int j, Pane pane) {
        if(showing) {
            return;
        }
        if (m.getGrid()[i][j] == '.') {
                if (start == null) {
                    start = new int[2];
                    start[0] = i;
                    start[1] = j;
                    pane.setStyle("-fx-background-color:RED");
                    return;
                }
                if (end == null) {
                    pane.setStyle("-fx-background-color:BLUE");
                    end = new int[2];
                    end[0] = i;
                    end[1] = j;
                    selectPoints.setVisible(false);
                    solve.setVisible(true);
                }
            } else {
                if(end != null) {
                pane.setStyle("-fx-background-color:WHITE");
                m.getGrid()[i][j] = '.';
                edited = true;
                showSolveAndHideRoutes();
                }
            }
    }
    
    
    
    /*
    * Creates a new maze
    */
    @FXML
    private void createNewPrim(ActionEvent e) {
        
        createPrimMaze(m.getGrid().length, m.getGrid().length);
        
    }
    
    @FXML
    private void createNewBt(ActionEvent e) {
        createBacktrackerMaze(m.getGrid().length, m.getGrid().length);
    }
    
    public void init() {
        
        mazegrid.getChildren().removeAll(mazegrid.getChildren());
        
        
        start = null;
        end = null;
        edited = false;
        solve.setVisible(false);
        showWfRoute.setVisible(false);
        selectPoints.setVisible(true);
        showBFSRoute.setVisible(false);
        showTremRoute.setVisible(false);
        
        while (mazegrid.getRowConstraints().size() > 0) {
            mazegrid.getRowConstraints().remove(0);
        }

        while (mazegrid.getColumnConstraints().size() > 0) {
            mazegrid.getColumnConstraints().remove(0);
        }
    }
    
    /**
    * Solves the maze from the start to finish
    * If user has put wall to the maze, it does'not solve with wallfollower, since it may end up in infinite loop
    */
    @FXML
    private void solve(ActionEvent e) {
        if(!edited) {
        showWfRoute.setVisible(true);
        long start3 = System.nanoTime();
        solveWf();
        long end3 = System.nanoTime();
        wfTime.setText((end3-start3) + "");
        }
        long start = System.nanoTime();
        solveBFS();
        long end = System.nanoTime();
        long start2 = System.nanoTime();
        solveTrem();
        long end2 = System.nanoTime();
        showBFSRoute.setVisible(true);
        
        
        showTremRoute.setVisible(true);
        
        tremTime.setText((end2-start2) + "");
        bfsTime.setText((end-start) + "");
    }
    
    /**
     * Solves the maze with wall follower
     */
    private void solveWf() {
        WallFollower wf = new WallFollower(m.getGrid(), start, end);
        wf.solve();
        wfRoute = wf.getRouteList();
    }
    
    /*
    * Solves the maze with BFS
    */
    
    private void solveBFS() {
        BFS bfs = new BFS(m.getGrid(), start, end);
        bfs.solveRoute();
        bfsRoute = bfs.getRouteList();
        bfsGoBack = bfs.getGoBackList();
    }
    
    /*
    * Solves the maze with trem
    */
    private void solveTrem() {
        Tremauxs t = new Tremauxs(m.getGrid(), start, end);
        t.solve();
        tremRoute = t.getRouteList();
        
    }
    
    
   
    
    @FXML
    private void showWfRoute(ActionEvent e) throws InterruptedException {
        
        hideButtons();
        showRoute(wfRoute);
        
        
    }
    
    
    @FXML
    private void showBFSRoute(ActionEvent e) throws InterruptedException {
        
        showingBFS = true;
        hideButtons();
        showRoute(bfsRoute);
    }
    
    @FXML
    private void showTremRoute(ActionEvent e) throws InterruptedException {
        
        hideButtons();
        showRoute(tremRoute);
        
    }
    
    
    
    /*
    * Finds the panes from the grid that corresponds to each cell in the route
    */
    public void showRoute(ArrayList<Cell> route) throws InterruptedException {
        showing = true;
        ObservableList<Node> children = mazegrid.getChildren();
        int n = m.getGrid().length;
        ArrayList<Pane> listOfPanes = new ArrayList();
        
        
        for (int i = 0; i < route.size() - 1; i++) {
            Cell c = route.get(i);
            Pane p = (Pane) (children.get(c.getRow()*n+c.getColumn()));
            listOfPanes.add(p);
        }
        
        
        animateRoute(listOfPanes);
        
        
    }
    
    private void animateRoute(ArrayList<Pane> panes) throws InterruptedException {
        i = 1;

        PauseTransition pause = new PauseTransition(Duration.millis(speed));
        
        pause.setOnFinished(event -> {
            
        
            if (i < panes.size()) {
             boolean isStart = panes.get(i).getStyle().equals("-fx-background-color:RED");
                panes.get(i).setStyle("-fx-background-color:PINK");
                
                if (i + 1 < panes.size()) {
                    if (panes.get(i + 1).getStyle().equals("-fx-background-color:PINK") || panes.get(i + 1).getStyle().equals("-fx-background-color:RED")) {
                        panes.get(i).setStyle("-fx-background-color:GREY");
                    }
                } 
                
                if(isStart) {
                    panes.get(i).setStyle("-fx-background-color:RED");
                }
                
                i++;
                pause.play();
                
            } else {
                if(showingBFS) {
                    try {
                        animateTheRouteBFSFound();
                    } catch (InterruptedException ex) {
                       
                    }
                } else {
                    
                    resetPath.setVisible(true);
                }
            }

        });
        
        pause.play();
    }
    
    private void animateTheRouteBFSFound() throws InterruptedException {
        i = 1;
        ArrayList<Pane> panes = new ArrayList();
        int n = m.getGrid().length;
        ObservableList<Node> children = mazegrid.getChildren();
        for (int i = 0; i < bfsGoBack.size() - 1; i++) {
            Cell c = bfsGoBack.get(i);
            Pane p = (Pane) (children.get(c.getRow()*n+c.getColumn()));
            panes.add(p);
        }

        PauseTransition pause = new PauseTransition(Duration.millis(speed));
        
        pause.setOnFinished(event -> {
            
        
            if (i < panes.size()) {
                panes.get(i).setStyle("-fx-background-color:GREEN");
                i++;
                pause.play();
                
            } else {
                resetPath.setVisible(true);
                
            }

        });
        
        pause.play();
    }
    
    /*
    * Resets the path after some route is shown
    */
    @FXML
    private void resetPath() {
        ObservableList<Node> children = mazegrid.getChildren();
        int n = m.getGrid().length;
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
            Node p = (Pane) (children.get(i*n+j));
            if(!p.getStyle().equals("-fx-background-color:RED") && !p.getStyle().equals("-fx-background-color:BLUE"))
            if(m.getGrid()[i][j] == '.') {
                p.setStyle("-fx-background-color:WHITE");
            }
            }
        }
        showing = false;
        showingBFS = false;
        resetPath.setVisible(false);
        showBFSRoute.setVisible(true);
        if(!edited) {
        showWfRoute.setVisible(true);
        }
        showTremRoute.setVisible(true);
        createNew.setVisible(true);
        createNewBt.setVisible(true);
        solve.setVisible(true);
    }
    
   
    public void hideButtons() {
        showBFSRoute.setVisible(false);
        showWfRoute.setVisible(false);
        showTremRoute.setVisible(false);
        createNew.setVisible(false);
        createNewBt.setVisible(false);
        solve.setVisible(false);
    }
    
    public void showSolveAndHideRoutes() {
        solve.setVisible(true);
        showBFSRoute.setVisible(false);
        showWfRoute.setVisible(false);
        showTremRoute.setVisible(false);
    }
    
    
}
