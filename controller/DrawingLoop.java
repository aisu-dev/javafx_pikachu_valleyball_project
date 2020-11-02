package javafx_pikachu_valleyball_project.controller;

import javafx_pikachu_valleyball_project.view.Platform;

public class DrawingLoop implements Runnable{

    private Platform platform;
    private int frameRate;
    private float interval;
    private boolean running;

    public DrawingLoop(Platform platform) {
        this.platform = platform;
        frameRate = 60;
        interval = 1000.0f / frameRate;
        running = true;
    }
    @Override
    public void run() {
        while (running) {

            float time = System.currentTimeMillis();



            time = System.currentTimeMillis() - time;

            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                } catch (InterruptedException ignore) { }
            } else {
                try {
                    Thread.sleep((long) (interval - (interval % time)));
                } catch (InterruptedException ignore) { }
            }
        }
    }

}
