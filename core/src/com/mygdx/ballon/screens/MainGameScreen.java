package com.mygdx.ballon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.ballon.BallonShooter;
import com.mygdx.ballon.entities.Ballons;
import com.mygdx.ballon.entities.Bullet;

import java.util.ArrayList;
import java.util.Random;

public class MainGameScreen implements Screen {

    Texture img;
    float x;
    float y;
    public static final float SPEED = 400;
    BallonShooter game;
    public static final int star_width = 150;
    public static final int star_height = 150;
    // ArrayList<Bullet> bullets;
    ArrayList<Ballons> ballons;

    float ballonspawnTimer;
    public static final float min_ballon_spawn_timer = 0.1f;
    public static final float max_ballon_spawn_timer = 5f;
    Random random;

    public MainGameScreen(BallonShooter game) {
        this.game = game;
        // bullets =  new ArrayList<Bullet>();
        random = new Random();
        ballonspawnTimer = random.nextFloat() * (max_ballon_spawn_timer - min_ballon_spawn_timer) + min_ballon_spawn_timer;

        ballons = new ArrayList<Ballons>();

    }

    @Override
    public void show() {

        img = new Texture("myship.png");

    }

    @Override
    public void render(float delta) {

      /*  if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(x + 4));
            bullets.add(new Bullet(x + star_width - 4));
        }*/

        ballonspawnTimer -= delta;

        if (ballonspawnTimer <= 0) {
            ballonspawnTimer = random.nextFloat() * (max_ballon_spawn_timer - min_ballon_spawn_timer) + min_ballon_spawn_timer;
            ballons.add(new Ballons(random.nextInt(Gdx.graphics.getWidth() - Ballons.width)));
        }

        ArrayList<Ballons> ballonsToRemove = new ArrayList<Ballons>();
        for (Ballons ballon : ballons) {
            ballon.update(delta);
            if (ballon.remove)
                ballonsToRemove.add(ballon);
        }

         /*   ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
            for (Bullet bullet : bullets) {
                bullet.update(delta);
                if (bullet.remove)
                    bulletsToRemove.add(bullet);

            }
            bullets.removeAll(bulletsToRemove);*/

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                x += SPEED * Gdx.graphics.getDeltaTime();
                if (x + star_width > Gdx.graphics.getWidth())
                    x = Gdx.graphics.getWidth() - star_width;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                x -= SPEED * Gdx.graphics.getDeltaTime();
                if (x < 0)
                    x = 0;
            }
            game.batch.begin();

            // for (Bullet bullet : bullets)
            //   bullet.render(game.batch);

            for (Ballons ballon : ballons)
                ballon.render(game.batch);

            game.batch.draw(img, x, y, star_width, star_height);
            game.batch.end();


        }
        @Override
        public void resize ( int width, int height){

        }
        @Override
        public void pause () {

        }
        @Override
        public void resume () {

        }
        @Override
        public void hide () {

        }

        @Override
        public void dispose () {
            game.batch.dispose();
            img.dispose();

        }

    }
