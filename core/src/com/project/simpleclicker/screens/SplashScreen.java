package com.project.simpleclicker.screens;

import com.badlogic.gdx.graphics.Texture;
import com.project.simpleclicker.SimpleClicker;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg;
	
	public SplashScreen(SimpleClicker game) {
		super(game);
		init();
	}

	private void init() {	
		splashImg = new Texture("badlogic.jpg");
		
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		spriteBatch.end();
	}

	
}
