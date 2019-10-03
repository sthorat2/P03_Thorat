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
    public static final float SPEED = 400;
    Ballon game;
    public static final int star_width = 150;
    public static final int star_height = 150;

    public MainGameScreen(Ballon game){
        this.game = game;

    }

    @Override
    public void show(){

        img = new Texture("star.jpg");

    }

    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += SPEED * Gdx.graphics.getDeltaTime();
            if(x + star_width > Gdx.graphics.getWidth())
                x = Gdx.graphics.getWidth() - star_width;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= SPEED * Gdx.graphics.getDeltaTime();
            if(x<0)
               x = 0;
        }
        game.batch.begin();
        game.batch.draw(img, x,y,star_width,star_height);
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
