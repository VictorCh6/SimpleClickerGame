package com.project.simpleclicker.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
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

	public final static String PIG = "img/pig.png";
	public final static String RABBIT = "img/rabbit.png";
	public final static String SHEEP = "img/sheep.png";
	public final static String CRAZYPIG = "img/crazypig.png";
	public final static String FOX = "img/fox.png";
	public final static String COW = "img/cow.png";
	public final static String BADCAT = "img/badcat.png";
	
	private final static int WIDHT = 150;
	private final static int HEIGHT = 150;
	
	private final static int STARTING_X_1 = 0;
	private final static int STARTING_X_2 = SimpleClicker.WIDTH;
	private final static int STARTING_Y_1 = -100;
	private final static int STARTING_Y_2 = SimpleClicker.HEIGHT;
	private int startingX;
	private int startingY;
	
	private SimpleClicker game;
	private FlyingLivestockType type;
	
	public FlyingLivestock(FlyingLivestockType type , SimpleClicker game){
		super(new Texture(getTexture(type)));
		
		this.type = type;
		this.game = game;
		
		this.setOrigin(WIDHT/2, HEIGHT/2);
		this.setSize(WIDHT, HEIGHT);
		
		//Starting position
		startingX = MathUtils.randomBoolean() ? STARTING_X_1 : STARTING_X_2;
		startingY = MathUtils.randomBoolean() ? STARTING_Y_1 : STARTING_Y_2;
		this.setPosition(startingX, startingY);
		
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
			game.addPointsExtra(100); System.out.println("COW");
		} else if(FlyingLivestockType.SHEEP.equals(type)){
			game.addPointsExtra(40); System.out.println("SHEEP");
		} else if(FlyingLivestockType.FOX.equals(type)){
			game.addPointsExtra(-100); System.out.println("FOX");
		} else if(FlyingLivestockType.BADCAT.equals(type)){
			game.addPointsExtra(-20); System.out.println("BADCAT");
		} else if(FlyingLivestockType.RABBIT.equals(type)){
			game.addPointsExtra(20); System.out.println("RABBIT");
		} else if(FlyingLivestockType.CRAZYPIG.equals(type)){
			game.addPointsExtra(-50); System.out.println("CRAZYPIG");
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
			
			int xSign = 0;
			if(startingX == STARTING_X_1){
				xSign = 1;
			} else {
				xSign = -1;
			}
			
			int time1 = MathUtils.random(1, 6);
			int time2 = MathUtils.random(1, 6);
			
			int randomYEffect = MathUtils.random(-100, 500);
			
			Action a = Actions.parallel(
					Actions.moveBy(xSign * 300 + (MathUtils.random(-200, 200)), 200 + randomYEffect, time1),
					Actions.rotateBy(360, time1)
					);
			
			Action b = Actions.parallel(
					Actions.moveBy(xSign * -500 + (MathUtils.random(-200, 200)), 900, time2),
					Actions.rotateBy(360, time2)
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
