package com.project.simpleclicker.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ActionButton extends Button {

	public ActionButton(final IClickCallback callback, int y){
		super(new ButtonStyle());
		init(callback, y);
		
	}

	
	private void init(final IClickCallback callback,int y) {
		this.setWidth(420);
		this.setHeight(50);
		this.setX(30);
		this.setY(y);
		this.setDebug(true);
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				callback.onClick();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
	}
}
