package com.project.simpleclicker.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.project.simpleclicker.SimpleClicker;

public class FlyingLivestock extends Image {
	
	public enum FlyingLivestockType {
		PIG, COW, RABBIT, SHEEP, FOX, CRAZYPIG, BADCAT,
	}

	public final static String PIG = "pig.png";
	public final static String RABBIT = "rabbit.png";
	public final static String SHEEP = "sheep.png";
	public final static String CRAZYPIG = "crazypig.png";
	public final static String FOX = "fox.png";
	public final static String COW = "cow.png";
	public final static String BADCAT = "badcat.png";
	
	private final static int WIDHT = 150;
	private final static int HEIGHT = 150;
	
	private final static int STARTING_X = 0;
	private final static int STARTING_Y = -100;
	
	private SimpleClicker game;
	private FlyingLivestockType type;
	
	public FlyingLivestock(FlyingLivestockType type , SimpleClicker game){
		super(new Texture(getTexture(type)));
		
		this.type = type;
		this.game = game;
		
		this.setOrigin(WIDHT/2, HEIGHT/2);
		this.setSize(WIDHT, HEIGHT);
		
		//Starting position
		this.setPosition(STARTING_X, STARTING_Y);
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				reactOnClick();
				
				return super.touchDown(event, x, y, pointer, button);
			}

			
		});
	}	
	
	private void reactOnClick() {
		if(FlyingLivestockType.PIG.equals(type)){
			game.addPointsExtra(50); System.out.println("PIG");
		} else if (FlyingLivestockType.COW.equals(type)){
			System.out.println("COW");
		} else if(FlyingLivestockType.SHEEP.equals(type)){
			System.out.println("SHEEP");
		} else if(FlyingLivestockType.FOX.equals(type)){
			System.out.println("FOX");
		} else if(FlyingLivestockType.BADCAT.equals(type)){
		 	System.out.println("BADCAT");
		} else if(FlyingLivestockType.RABBIT.equals(type)){
			System.out.println("RABBIT");
		} else if(FlyingLivestockType.CRAZYPIG.equals(type)){
			System.out.println("CRAZYPIG");
		}
		FlyingLivestock.this.remove();
		
	}
	
		private static String getTexture(FlyingLivestockType type) {
			
			if(FlyingLivestockType.PIG.equals(type)){
				return PIG;
			} else if (FlyingLivestockType.COW.equals(type)) {
				return COW;
			} else if (FlyingLivestockType.RABBIT.equals(type)) {
				return RABBIT;
			} else if (FlyingLivestockType.SHEEP.equals(type)) {
				return SHEEP;
			} else if (FlyingLivestockType.FOX.equals(type)) {
				return FOX;
			} else if (FlyingLivestockType.CRAZYPIG.equals(type)) {
				return CRAZYPIG;
			} else if (FlyingLivestockType.BADCAT.equals(type)) {
				return BADCAT;
			} 
				return"";
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
