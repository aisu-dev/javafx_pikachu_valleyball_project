package javafx_pikachu_valleyball_project.controller;


import javafx_pikachu_valleyball_project.model.Ball;
import javafx_pikachu_valleyball_project.model.Character;
import javafx_pikachu_valleyball_project.model.Wall;
import javafx_pikachu_valleyball_project.view.Platform;

import java.util.ArrayList;

public class DrawingLoop implements Runnable {

    private Platform platform;
    private int frameRate;
    private float interval;
    private boolean running;

    public DrawingLoop(Platform platform) {
        this.platform = platform;
        frameRate = 60;
        interval = 1000.0f / frameRate; // 1000 ms = 1 second
        running = true;
    }

    private void check_character_collision(ArrayList<Character> characterList) {
        for (Character character : characterList ) {
            character.checkReachGameWall();
            character.checkReachHighest();
            character.checkReachFloor();
        }
        for (Character cA : characterList) {
            for (Character cB : characterList) {
                if (cA != cB) {
                    if (cA.getBoundsInParent().intersects(cB.getBoundsInParent())) {
                        cA.collided(cB);
                        cB.collided(cA);
                        return;
                    }
                }
            }
        }
    }
    private void check_ball_collision(Ball ball, ArrayList<Character> characterList, Wall wall){
        ball.checkReachFloor(characterList);
        ball.checkHitWall(wall);
        for (Character c:characterList) {
            ball.check_hit_character(c);
        }
    }

    private void paint_character(ArrayList<Character> characterList) {
        for (Character character : characterList ) {
            character.repaint();
        }
    }
    private void paint_ball(Ball ball){
        ball.repaint();
    }

    @Override
    public void run() {
        while (running) {

            float time = System.currentTimeMillis();

            check_character_collision(platform.getCharacterList());
            paint_character(platform.getCharacterList());

            check_ball_collision(platform.getBall(), platform.getCharacterList(), platform.getWall());
            paint_ball(platform.getBall());

            time = System.currentTimeMillis() - time;

            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                } catch (InterruptedException ignore) {
                }
            } else {
                try {
                    Thread.sleep((long) (interval - (interval % time)));
                } catch (InterruptedException ignore) {
                }
            }
        }
    }
}
