package com.project.simpleclicker.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.project.simpleclicker.SimpleClicker;
import com.project.simpleclicker.controllers.ActionButtonController;
import com.project.simpleclicker.entities.Player;

public class GameplayScreen extends AbstractScreen {
	
	private Player player;
	private ActionButtonController actionController;
	private Label scoreLabel;
	
	public GameplayScreen(SimpleClicker game){
		super(game);
		init();
	}

	protected void init() {
		initPlayer();
		initActionController();
		initScoreLabel();
	}

	
private void initScoreLabel() {
	LabelStyle labelStyle = new LabelStyle();
	labelStyle.font = new BitmapFont();
	scoreLabel = new Label((""), labelStyle);
	scoreLabel.setX(20);
	scoreLabel.setY(659);
	stage.addActor(scoreLabel);
	}

private void initActionController() {
		actionController = new ActionButtonController(game, stage);
	}
	
	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
	}
		
	@Override
	public void render(float delta) {
		super.render(delta);
		update();
		
		System.out.println("Points: "+game.getPoints());
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}
}
