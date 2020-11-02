package javafx_pikachu_valleyball_project.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx_pikachu_valleyball_project.view.Platform;

public class Launcher extends Application {

    private Stage main_stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.main_stage = stage;
        Platform main_platform = new Platform();
        GameLoop game_loop = new GameLoop(main_platform);
        DrawingLoop drawing_loop = new DrawingLoop(main_platform);
        Scene scene = new Scene(main_platform,main_platform.WIDTH,main_platform.HEIGHT);
        this.main_stage.setTitle("622115014");
        this.main_stage.setScene(scene);
        this.main_stage.show();
        (new Thread(game_loop)).start();
        (new Thread(drawing_loop)).start();
    }
    public static void main(String[] args){
        launch(args);
    }
}
