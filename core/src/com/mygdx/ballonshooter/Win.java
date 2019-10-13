package com.mygdx.ballonshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class Win extends BaseScreen {

    private BaseActor bg;
    private BaseActor title;

    private Label text;

    public Win(Game game) {
        super(game);
    }

    @Override
    protected void init() {

        bg = ActionManager.createActor(mainStage,"sky1.jpg",viewWidth/2,viewHeight/2);
        title = ActionManager.createActor(mainStage,"win.png",viewWidth/2,viewHeight/2);

        BitmapFont font = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle(font, Color.GOLD);


        text = new Label("touch to start again", style);
        text.setPosition(viewWidth / 2 - text.getWidth() /2, 100);
        text.setFontScale(2);
        text.setAlignment(Align.center);

        uiStage.addActor(text);

    }

    @Override
    protected void update(float delta) {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        game.setScreen(new BallonLevel(game));
        return false;
    }
}
