package com.mygdx.ballonshooter;

import com.badlogic.gdx.Game;


public class BallonBuster extends Game {


    @Override
    public void create() {

        setScreen(new BallonMainMenu(this));

    }
}