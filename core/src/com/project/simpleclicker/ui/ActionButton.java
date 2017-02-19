package com.project.simpleclicker.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ActionButton extends Button {

	public ActionButton(final IClickCallback callback, int x){
		super(prepareButtonStyle());
		init(callback, x);		
	}

	

	private static ButtonStyle prepareButtonStyle(){
			TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("ui-green.atlas"));
			Skin skin = new Skin(atlas);
			ButtonStyle buttonStyle = new ButtonStyle();
			buttonStyle.up = skin.getDrawable("button_05");
			buttonStyle.down = skin.getDrawable("button_06");
			
			return buttonStyle;
	}


	private void init(final IClickCallback callback,int x) {
		this.setWidth(140);
		this.setHeight(50);
		this.setX(x);
		this.setY(110);
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				callback.onClick();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
	}
	
	
}
