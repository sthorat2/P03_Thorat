package com.mygdx.ballon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.ballon.screens.MainMenuScreen;

public class Ballon extends Game {
	public SpriteBatch batch;

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));

	}

	@Override
	public void render () {

		super.render();



	}
	
	@Override
	public void dispose () {


	}
}
