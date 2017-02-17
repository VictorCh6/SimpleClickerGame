package com.project.simpleclicker.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.project.simpleclicker.SimpleClicker;

public class ResetButton extends Button {

	public ResetButton(Stage stage, SimpleClicker game){
		super(new ButtonStyle());
		
		init(stage, game);	
	}

	private void init(Stage stage, final SimpleClicker game) {
		this.setWidth(60);
		this.setHeight(45);
		this.setX(20);
		this.setY(590);
		this.setDebug(true);
		stage.addActor(this);		
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				game.resetScore();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
	}
}
