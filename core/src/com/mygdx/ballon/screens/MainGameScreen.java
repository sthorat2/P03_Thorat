package com.mygdx.ballon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.ballon.Ballon;

public class MainGameScreen implements Screen {

    Texture img;
    float x;
    float y;
    public static final float SPEED = 100;
    Ballon game;

    public MainGameScreen(Ballon game){
        this.game = game;

    }

    @Override
    public void show(){

        img = new Texture("badlogic.jpg");

    }

    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            y += SPEED * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            y -= SPEED * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            x += SPEED * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            x -= SPEED * Gdx.graphics.getDeltaTime();
        game.batch.begin();
        game.batch.draw(img, x, y);
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
        game.batch.dispose();
        img.dispose();

    }

}
