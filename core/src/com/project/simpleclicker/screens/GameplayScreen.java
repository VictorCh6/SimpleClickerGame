package com.project.simpleclicker.screens;

import com.project.simpleclicker.SimpleClicker;
import com.project.simpleclicker.entities.Player;

public class GameplayScreen extends AbstractScreen {
	
	private Player player;
	
	public GameplayScreen(SimpleClicker game){
		super(game);
		init();
	}

	private void init() {
		initPlayer();
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
		stage.act();
	}
}
