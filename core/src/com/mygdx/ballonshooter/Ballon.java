package com.mygdx.ballonshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import javax.swing.Action;

public class Ballon extends BaseActor {

    private float speed;
    private float amplitude;
    private float ocillation;
    private float initY;
    private float time;
    private int offsetX;

    BallonLevel ballonLevel;

    public Ballon(BallonLevel ballonLevel) {

        this.ballonLevel = ballonLevel;

        speed = 50 * MathUtils.random(0.5f, 2.0f);
        amplitude = 50 * MathUtils.random(0.5f, 2.0f);
        ocillation = 0.01f * MathUtils.random(0.5f, 2.0f);
        initY = 15 * MathUtils.random(0.5f, 2.0f);
        time = 0;
        offsetX = -100;
        //setTexture(new Texture(Gdx.files.internal("ballon.png")));
        //setTexture(new Texture(Gdx.files.internal("blueballon.png")));
        //setTexture(new Texture(Gdx.files.internal("greenballon.png")));
        //setTexture(new Texture(Gdx.files.internal("pinkballon.png")));
        setTexture(new Texture(Gdx.files.internal("yelloballon.png")));
       //setTexture(new Texture(Gdx.files.internal("purpleballon.png")));
        setColor(MathUtils.random(),MathUtils.random(),MathUtils.random(),1);
        setX(offsetX);
    }

    @Override
    public void act(float dt) {

        super.act(dt);

        time += dt;
        float xPos = speed * time + offsetX;
        float yPos = amplitude * MathUtils.sin(ocillation * xPos) + initY;
        setPosition(xPos, yPos);


        if (getX() >ballonLevel.mapWidth){
            ballonLevel.escapedInc();
            remove();
        }

    }

    public void popBallon() {

        //isPopped = true;

        SequenceAction popped = Actions.sequence(
                Actions.parallel(
                        Actions.fadeOut(1),
                        Actions.scaleTo(0,0, 2)),
                Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        remove();
                    }
                })
        );

        addAction(popped);

    }
}
