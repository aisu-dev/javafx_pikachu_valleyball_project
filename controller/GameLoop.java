package javafx_pikachu_valleyball_project.controller;

import javafx_pikachu_valleyball_project.view.Platform;

public class GameLoop implements Runnable{

    private boolean running;
    private Platform platform;
    private int frame_rate;
    private float interval;

    public GameLoop(Platform platform){
        this.platform = platform;
        this.frame_rate = 5;
        this.interval = 1000f;
        this.running = true;
    }

    @Override
    public void run() {
        while(running){
            float time = System.currentTimeMillis();

            time = System.currentTimeMillis()-time;
            if (time<interval){
                try{
                    Thread.sleep((long)(interval-time));
                }catch (InterruptedException err){ }
            }else{
                try{
                    Thread.sleep((long)(interval-(interval%time)));
                }catch(InterruptedException err){ }
            }
        }
    }
}
