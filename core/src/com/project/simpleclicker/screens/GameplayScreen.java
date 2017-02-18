package com.project.simpleclicker.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.project.simpleclicker.SimpleClicker;
import com.project.simpleclicker.controllers.ActionButtonController;
import com.project.simpleclicker.entities.FlyingLivestock;
import com.project.simpleclicker.entities.Player;
import com.project.simpleclicker.ui.ResetButton;
import com.project.simpleclicker.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen {
	
	private Image background;
	private Player player;
	private ScoreLabel scoreLabel;
	private FlyingLivestock flyingLivestock;

	
	public GameplayScreen(SimpleClicker game){
		super(game);
		init();
	}

	protected void init() {
		
		initBackground();
		initPlayer();
		initActionController();
		initScoreLabel();
		initResetButton();
		initFlyingLivestock();
	}

		
	private void initFlyingLivestock() {
		flyingLivestock = new FlyingLivestock();
		stage.addActor(flyingLivestock);
		flyingLivestock.fly();
	}

	private void initBackground() {
		background = new Image(new Texture("background.png"));
		stage.addActor(background);
	}

	private void initResetButton() {
		new ResetButton(stage, game);
	}
	
	private void initScoreLabel() {
		scoreLabel =  new ScoreLabel();	
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
