package com.project.simpleclicker.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.project.simpleclicker.SimpleClicker;
import com.project.simpleclicker.controllers.ActionButtonController;
import com.project.simpleclicker.entities.Player;
import com.project.simpleclicker.ui.ResetButton;

public class GameplayScreen extends AbstractScreen {
	
	private Player player;
	private Label scoreLabel;

	
	public GameplayScreen(SimpleClicker game){
		super(game);
		init();
	}

	protected void init() {
		initPlayer();
		initActionController();
		initScoreLabel();
		initResetButton();
	}

	
private void initResetButton() {
	new ResetButton(stage, game);
}

private void initScoreLabel() {
	LabelStyle labelStyle = new LabelStyle();
	labelStyle.font = new BitmapFont();
	scoreLabel = new Label((""), labelStyle);
	scoreLabel.setX(20);
	scoreLabel.setY(660);
	stage.addActor(scoreLabel);
	}

private void initActionController() {
	  new ActionButtonController(game, stage);
	}
	
	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
	}
		
	@Override
	public void render(float delta) {
		super.render(delta);
		update();
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}
}
