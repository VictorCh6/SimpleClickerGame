package com.project.simpleclicker.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

public class ResetButton extends Button {

	public ResetButton(Stage stage){
		super(new ButtonStyle());
		
		init(stage);
		
		
	}

	private void init(Stage stage) {
		this.setWidth(60);
		this.setHeight(45);
		this.setX(20);
		this.setY(590);
		this.setDebug(true);
		stage.addActor(this);		
	}
}
