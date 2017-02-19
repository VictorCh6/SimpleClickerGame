package com.project.simpleclicker;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.project.simpleclicker.screens.SplashScreen;
import com.project.simpleclicker.service.SoundService;

public class SimpleClicker extends Game{
	
	public final static String GAME_PREFERENCES = "com.project.simpleclicker.preferences";
	public final static String GAME_SCORE = "com.project.simpleclicker.preferences.score";
	
	public final static String GAME_NAME = "Simple Clicker";
		
	public static int WIDTH= 480;
	public static int HEIGHT= 700;
	
	private SoundService soundService;
	
	private boolean paused;
	
	private Preferences prefs;
	
	private int points;
	
	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}
	
	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFERENCES);
		loadScore();
		initSoundService();
	}

	private void initSoundService() {
		soundService = new SoundService();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
		
	}

	public void addPoints(){
		points++;
		updateSavedScore();
	}
	
	public void addPointsExtra(int toAdd){
		points += toAdd;
		updateSavedScore();
	}

	
	public void resetScore() {
		points = 0;
		updateSavedScore();
		
	}
	
	private void updateSavedScore() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
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

	public SoundService getSoundService() {
		return soundService;
	}

	
}
