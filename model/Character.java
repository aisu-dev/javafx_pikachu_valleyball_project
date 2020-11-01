package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Character extends Pane {

    public static final int WIDTH = 48;
    public static final int HEIGHT = 96;

    private Image img;
    private ImageView imgView;
    private KeyCode left,right,up;

    int x,y;
    int offsetX,offsetY;

    public Character(int x,int y,int offX,int offY,KeyCode left,KeyCode right,KeyCode up){
        this.x = x;
        this.y = y;
        this.offsetX = offX;
        this.offsetY = offY;
        this.left = left;
        this.right = right;
        this.up = up;
        this.img = new Image(getClass().getResourceAsStream("/assets/pikachu_sprite.png"));
        this.imgView = new AnimateSprite(img,5,5,offsetX,offsetY,64,64);
        this.imgView.setFitHeight(HEIGHT);
        this.imgView.setFitWidth(WIDTH);
        this.getChildren().addAll(this.imgView);
    }

}
