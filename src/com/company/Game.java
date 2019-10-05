package com.company;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    private int width,height;

    public Game(){

        new Window(1000,563,"Game",this);
    }

    public Game(int width,int height, String title){
        this.width = width;
        this.height = height;

        new Window(width,height,title,this);
    }

    public void tick(){

    }

    public void render(){

    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now ;
            while(delta >= 1){
                tick();
                delta--;

            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }

        }
        stop();
    }

    public void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
}
