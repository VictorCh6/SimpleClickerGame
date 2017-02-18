package com.project.simpleclicker.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ActionButton extends Button {

	public ActionButton(final IClickCallback callback, int x){
		super(new ButtonStyle());
		init(callback, x);		
	}

	
	private void init(final IClickCallback callback,int x) {
		this.setWidth(140);
		this.setHeight(50);
		this.setX(x);
		this.setY(110);
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
