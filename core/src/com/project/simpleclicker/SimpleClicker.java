package com.project.simpleclicker;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project.simpleclicker.screens.SplashScreen;

public class SimpleClicker extends Game{
	
	public final static String GAME_NAME = "Simple Clicker";
	//public final static String GAME_NAME = "";
	
	public static int WIDTH= 480;
	public static int HEIGHT= 700;
	
	private boolean paused;
	
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}


	/**
	 * ---------------------
	 * getters and setters
	 * 
	 */
	
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
