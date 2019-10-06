package com.mygdx.ballon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ballons {

    public static final int SPEED = 100;
    public static final int width = 150;
    public static final int height = 150;

    private static Texture texture;
    float x,y;
    public boolean remove = false;

    public Ballons (float x){

        this.x = x;
        this.y = Gdx.graphics.getHeight();

        if(texture == null)
            texture = new Texture("ballon1.png");

    }

    public void update(float deltaTime){
        y -= SPEED * deltaTime;
        if(y < - height)
            remove = true;

    }

    public  void render(SpriteBatch batch){
        batch.draw(texture,x,y);
    }


}
