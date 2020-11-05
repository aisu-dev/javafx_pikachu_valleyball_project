package javafx_pikachu_valleyball_project.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx_pikachu_valleyball_project.view.Platform;

public class Ball extends Pane {

    private AnimatedSprite imageView;
    private Image ballImg;
    private static final int WIDTH = 92,HEIGHT = 92;
    private static final float GRAVITY = .98f;

    private int x,y;
    private float power,px,py;
    private int max_yDistance;
    private boolean is_falling;
    private boolean is_wall;

    public Ball(int x,int y,float power){
        this.x = x;
        this.y = y;
        this.setTranslateX(this.x);
        this.setTranslateY(this.y);
        this.ballImg = new Image("/javafx_pikachu_valleyball_project/assets/ball_sprite.png");
        this.imageView = new AnimatedSprite(ballImg,5,5,0,0,42,40);
        this.imageView.setFitWidth(WIDTH);
        this.imageView.setFitHeight(HEIGHT);
        this.power = power;
        is_falling = true;
        is_wall = false;
        getChildren().add(imageView);
    }
    public void checkReachFloor() {
        if(y >= Platform.GROUND - HEIGHT) {
            y = Platform.GROUND - HEIGHT;
        }
    }

    public void check_hit_character(Character character){
        if(getBoundsInParent().intersects(character.getBoundsInParent())){
            float cx = (float)character.getBoundsInParent().getCenterX();
            float cy = (float)character.getBoundsInParent().getCenterY();
            float bx = (float)getBoundsInParent().getCenterX();
            float by = (float)getBoundsInParent().getCenterY();
            float h = Math.abs((float) Math.sqrt(Math.pow(bx-cx,2)+Math.pow(by-cy,2)));
            float a = Math.abs(bx-cx);
            float o = Math.abs(by-cy);
            if (bx-cx<0){
                px = -(power * a / h);
                py = power * o/h;
            }else{
                px = power * a / h;
                py = power * o/h;
            }
            py = py<8?8:py;
            System.out.println(py);
            max_yDistance = (int) (getY()-(Math.abs((Math.pow(py,2)/(2*GRAVITY)))));
            is_falling = false;
            is_wall = true;
        }
    }

    public void checkHitWall(Wall wall){
        System.out.println(px);
        if (getX()<0||getX()+WIDTH>=Platform.WIDTH){
            px *= -1;
        }
        if(getBoundsInParent().intersects(wall.getBoundsInParent())&&is_wall){
            if (px<0){
                px = Math.abs(px);
            }else if (px>0){
                px = -px;
            }
            is_wall = false;
        }
        if(getY()<=0){
            is_falling = true;
        }

    }

    public void checkReachHeight(){
        if(py<=0){
            py = 0;
            is_falling = true;
        }
    }

    public void moveX(){
        setTranslateX(x);
        x = (int)(x+px);
    }
    public void moveY(){
        checkReachHeight();
        setTranslateY(y);
        if(is_falling){
            py += GRAVITY/10;
            y+=py;
//              y+=GRAVITY;
        }else{
            y-=py;
            py-=GRAVITY;
        }
    }

    public void repaint(){
        imageView.ball_anim();
        moveX();
        moveY();
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
