package com.project.simpleclicker.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;


public class SoundService {
		
	private Music gameMusic;
		
	public SoundService(){
		init();
	}

	private void init(){
		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/caketown.mp3"));
	}	
	
	public void playGameMusic(boolean looped){
		gameMusic.play();
		gameMusic.setLooping(looped);
	}
	
}