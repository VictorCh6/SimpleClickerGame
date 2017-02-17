package com.project.simpleclicker;

import com.badlogic.gdx.Game;
import com.project.simpleclicker.screens.SplashScreen;

public class SimpleClicker extends Game{
	
	public final static String GAME_NAME = "Simple Clicker";
		
	public static int WIDTH= 480;
	public static int HEIGHT= 700;
	
	private boolean paused;
	
	private int points;
	
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}
	
	public void addPoints(){
		points++;
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


	public int getPoints() {
		return points;
	}


	
}
