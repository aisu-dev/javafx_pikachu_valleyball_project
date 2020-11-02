package javafx_pikachu_valleyball_project.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx_pikachu_valleyball_project.model.Character;
import java.util.ArrayList;

public class Platform extends Pane {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 600;
    public static final int GROUND = 500;

    private ArrayList<Character> character_list = new ArrayList<>();

    public Platform(){
        ImageView bg_img = new ImageView(new Image("/javafx_pikachu_valleyball_project/assets/background.png"));
        bg_img.setFitWidth(WIDTH);
        bg_img.setFitHeight(HEIGHT);
        character_list.add(new Character(0,GROUND,0,0, KeyCode.LEFT,KeyCode.RIGHT,KeyCode.UP));
        getChildren().add(bg_img);
        getChildren().addAll(character_list);
    }

}
