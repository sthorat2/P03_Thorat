package com.mygdx.ballon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.ballon.Ballon;

public class MainMenuScreen implements Screen {

    private static final int play_width = 330;
    private static final int play_height = 150;
    private static final int exit_width = 300;
    private static final int exit_height = 150;
    private static final int play_y = 100;
    private static final int exit_y = 100;
    private static final int play_x = 100;
    private static final int exit_x = 800;

    Ballon game;
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    public MainMenuScreen(Ballon game){
        this.game = game;
        playButtonActive = new Texture("play_button_active.png");
        playButtonInactive = new Texture("play_button_active.png");
        exitButtonActive = new Texture("exit_button_active.png");
        exitButtonInactive = new Texture("exit_button_active.png");


    }

    @Override
    public void show(){



    }

    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();


        game.batch.draw(playButtonActive, play_x, play_y, play_width, play_height);
        game.batch.draw(exitButtonActive, exit_x, exit_y, exit_width, exit_height);
        /*
        if(Gdx.input)
            game.batch.draw(playButtonActive, play_x, play_y, play_width, play_height);
        else
            game.batch.draw(playButtonInactive, play_x, play_y, play_width, play_height);

        if()
            game.batch.draw(exitButtonActive, exit_x, exit_y, exit_width, exit_height);
         else
            game.batch.draw(exitButtonInactive, exit_x, exit_y, exit_width, exit_height);
        */
        game.batch.end();






    }
    @Override
    public void resize(int width,int height){

    }
    @Override
    public void pause(){

    }
    @Override
    public void resume(){

    }
    @Override
    public void hide(){

    }
    @Override
    public void dispose(){


    }
}
