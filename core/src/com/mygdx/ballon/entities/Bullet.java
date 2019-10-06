package com.mygdx.ballon.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {

    public static final int SPEED = 400;
    public static final int default_y = 0;
    private static Texture texture;
    float x,y;
    public boolean remove = false;

    public Bullet (float x){

        this.x = x;
        this.y = default_y;

        if(texture == null)
            texture = new Texture("bullet.png");

    }

    public void update(float deltaTime){
        y += SPEED * deltaTime;
        if(y > Gdx.graphics.getHeight())
            remove = true;

    }

    public  void render(SpriteBatch batch){
        batch.draw(texture,x,y);
    }

}
