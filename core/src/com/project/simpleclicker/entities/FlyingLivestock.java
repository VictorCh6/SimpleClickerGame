package com.project.simpleclicker.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class FlyingLivestock extends Image {

	public final static String PIG = "pig.png";
	
	private final static int WIDHT = 150;
	private final static int HEIGHT = 150;
	
	private final static int STARTING_X = 0;
	private final static int STARTING_Y = -100;
	
	
	public FlyingLivestock(String texture){
		super(new Texture(texture));
		
		this.setOrigin(WIDHT/2, HEIGHT/2);
		this.setSize(WIDHT, HEIGHT);
		
		//Starting position
		this.setPosition(STARTING_X, STARTING_Y);
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				System.out.println("PIG");
				FlyingLivestock.this.remove();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}	
	
		public void fly(){
			
			Action a = Actions.parallel(
					Actions.moveBy(300, 200, 5),
					Actions.rotateBy(360, 5)
					);
			
			Action b = Actions.parallel(
					Actions.moveBy(-500, 900, 3),
					Actions.rotateBy(360, 3)
					);
			
			Action c = Actions.run(new Runnable() {
				
				@Override
				public void run() {
					FlyingLivestock.this.remove();
				}
			});
			
			
			this.addAction(Actions.sequence(a, b, c));		
		}	
}
