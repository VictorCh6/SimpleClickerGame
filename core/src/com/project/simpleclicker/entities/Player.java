package com.project.simpleclicker.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image {

	private static final int WIDHT = 150;
	private static final int HEIGTH = 147;
	
	private static final int STARTING_X = 300;
	private static final int STARTING_Y = 530;
	
	public Player(){
		super(new Texture("machete.png"));
		
		this.setOrigin(WIDHT / 2, HEIGTH / 2);
		this.setSize(WIDHT, HEIGTH);
		
		//starting position
		this.setPosition(STARTING_X, STARTING_Y);
	}

	public void reactOnClick(){
		//TO DO create react on click action 
	}
}
