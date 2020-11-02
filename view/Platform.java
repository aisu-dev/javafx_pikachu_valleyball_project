package javafx_pikachu_valleyball_project.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx_pikachu_valleyball_project.model.Character;
import javafx_pikachu_valleyball_project.model.Keys;


import java.util.ArrayList;

public class Platform extends Pane {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 600;
    public static final int GROUND = 400;

    private Image platformImg;
    private ArrayList<Character> characterList = new ArrayList();

    private Keys keys;

    public Platform() {
        keys = new Keys();
        platformImg = new Image(getClass().getResourceAsStream("/javafx_pikachu_valleyball_project/assets/background.png"));
        ImageView backgroundImg = new ImageView(platformImg);
        backgroundImg.setFitHeight(HEIGHT);
        backgroundImg.setFitWidth(WIDTH);
        characterList.add(new Character(30, 30,0,0, KeyCode.A,KeyCode.D,KeyCode.W));
        characterList.add(new Character(Platform.WIDTH-30, 30,0,0, KeyCode.LEFT,KeyCode.RIGHT,KeyCode.UP));
        getChildren().add(backgroundImg);
        getChildren().addAll(characterList);
    }

    public ArrayList<Character> getCharacterList() {
        return characterList;
    }

    public Keys getKeys() {
        return keys;
    }
}

