package com.mygdx.ballon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.ballon.screens.MainMenuScreen;
import com.mygdx.ballon.screens.MainGameScreen;

public class BallonShooter extends Game {
	public SpriteBatch batch;

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		this.setScreen(new MainGameScreen(this));

	}

	@Override
	public void render () {

		super.render();



	}
	
	@Override
	public void dispose () {


	}
}
