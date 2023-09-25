package PoolGame;

import PoolGame.config.*;

import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import PoolGame.objects.Table;
// import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
// import javafx.scene.layout.HBox;

/** Main application entry point. */
public class App extends Application {
    private Level lv ;
    private String config ;
    private boolean levelChosen = false;
    public static GameManager gm;
    private GraphicsContext gc;
    private int track = 0;

    private Canvas c;
    private Pane p;
    Button easy;
    Button normal;
    Button hard;

    /**
     * @param args First argument is the path to the config file
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    /**
     * Starts the application.
     * 
     * @param primaryStage The primary stage for the application.
     */
    public void start(Stage primaryStage) {
        // READ IN CONFIG
        GameManager gameManager = new GameManager();
        gm = gameManager;

        List<String> args = getParameters().getRaw();
        String configPath = checkConfig(args);
        
        easy   = new Button("Easy");
        normal = new Button("Normal");
        hard   = new Button("Hard");
        // gameManager.buildManager();

        easy.setOnAction (event -> {
            easyButton(primaryStage, gm);
            levelChosen = true;
        });

        normal.setOnAction (event -> {
            normalButton(primaryStage, gm);
            levelChosen = true;
        });

        hard.setOnAction (event -> {
            hardButton(primaryStage, gm);
            levelChosen = true;

        });

        // display difficulty button
        if (levelChosen == false) {
            Pane pa = new Pane();
            ReaderFactory tableFactory = new TableReaderFactory();
            Reader tableReader = tableFactory.buildReader();
            tableReader.parse("src/main/resources/config_easy.json", gameManager);
            Table table = gameManager.getTable();

            Scene scene = new Scene(pa, table.getxLength() + gameManager.getTableBuffer() * 2, table.getyLength() + gameManager.getTableBuffer() * 2);
            
            Canvas canvas = new Canvas(table.getxLength() + gameManager.getTableBuffer() * 2, table.getyLength() + gameManager.getTableBuffer() * 2);

            pa.getChildren().add(canvas);

            buttonDesign(easy, normal, hard, gameManager);

            pa.getChildren().addAll(easy, normal, hard);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        startGameManager(primaryStage, gm);

    }

    /**
     * giving the level buttons x and y positions
     * 
     * @param easy
     * @param normal
     * @param hard
     * @param gameManager 
     */
    private void buttonDesign(Button easy, Button normal, Button hard, GameManager gameManager) {
        Double tb = gameManager.getTableBuffer();
        Table t = gameManager.getTable();

        easy.setLayoutX((t.getxLength() + tb * 2) / 6 - 20);
        easy.setLayoutY((t.getyLength() + tb * 2) / 2);

        normal.setLayoutX((t.getxLength() + tb * 2) / 6 + 180);
        normal.setLayoutY((t.getyLength() + tb * 2) / 2);

        hard.setLayoutX((t.getxLength() + tb * 2) / 6 + 380);
        hard.setLayoutY((t.getyLength() + tb * 2) / 2);

        easy.setPrefHeight(50);
        easy.setPrefWidth(100);

        normal.setPrefHeight(50);
        normal.setPrefWidth(100);

        hard.setPrefHeight(50);
        hard.setPrefWidth(100);
    }

    /**
     * handle reading config file process
     * 
     * @param config path to config file
     */
    private void readerHandle(String config) {
        ReaderFactory tableFactory = new TableReaderFactory();
        Reader tableReader = tableFactory.buildReader();
        tableReader.parse(config, gm);

        ReaderFactory ballFactory = new BallReaderFactory();
        Reader ballReader = ballFactory.buildReader();
        ballReader.parse(config, gm);
        // gameManager.buildManager();

        ReaderFactory pocketFactory = new PocketReaderFactory();
        Reader pocketReader = pocketFactory.buildReader();
        pocketReader.parse(config, gm);
    }

    /**
     * where to calling buildManager and run to start game
     * 
     * @param primaryStage
     * @param gm gameManager object
     */
    private void startGameManager(Stage primaryStage, GameManager gm) {
        
        gm.buildManager();
        p = gm.getPane();
        c = gm.getCanvas();
        Button u = gm.getUndoButton();


        easy.setLayoutX(50);
        easy.setLayoutY(470);

        normal.setLayoutX(300);
        normal.setLayoutY(470);

        hard.setLayoutX(550);
        hard.setLayoutY(470);

        easy.setPrefHeight(20);
        easy.setPrefWidth(100);

        normal.setPrefHeight(20);
        normal.setPrefWidth(100);

        hard.setPrefHeight(20);
        hard.setPrefWidth(100);

        p.getChildren().add(c);
        p.getChildren().add(u);
        p.getChildren().addAll(easy, normal, hard);
        
        gm.run();
        primaryStage.setTitle("Pool");
        primaryStage.setScene(gm.getScene());
        primaryStage.show();
        gm.run();
    }

    /**
     * called when easy button is clicked
     * changing the config file, load the reader to read in
     * corresponding information for new level
     *
     * @param primaryStage
     * @param gm gameManager object
     */
    private void easyButton(Stage primaryStage, GameManager gm) {
        lv = new Easy("src/main/resources/config_easy.json");
        config = lv.handle();
        readerHandle(config);
        gm.notifi();
    }

    /**
     * called when normal button is clicked
     * changing the config file, load the reader to read in
     * corresponding information for new level
     *
     * @param primaryStage
     * @param gm gameManager object
     */
    private void normalButton(Stage primaryStage, GameManager gm) {
        lv = new Normal("src/main/resources/config_normal.json");
        config = lv.handle();
        readerHandle(config);
        gm.notifi();
    }

    /**
     * called when hard button is clicked
     * changing the config file, load the reader to read in
     * corresponding information for new level
     *
     * @param primaryStage
     * @param gm gameManager object
     */
    private void hardButton(Stage primaryStage, GameManager gm) {
        lv = new Hard("src/main/resources/config_hard.json");
        config = lv.handle();
        readerHandle(config);
        gm.notifi();
    }

    /**
     * Checks if the config file path is given as an argument.
     * 
     * @param args
     * @return config path.
     */
    private static String checkConfig(List<String> args) {
        String configPath;
        if (args.size() > 0) {
            configPath = args.get(0);
        } else {
            configPath = "src/main/resources/config_easy.json";
        }
        return configPath;
    }
}
