package com.project.simpleclicker.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.project.simpleclicker.SimpleClicker;
import com.project.simpleclicker.entities.FlyingLivestock;
import com.project.simpleclicker.entities.FlyingLivestock.FlyingLivestockType;

public class FlyingLivestockController {

	private int spawnTime;
	
	public FlyingLivestockController(SimpleClicker game, Stage stage){
		init(game, stage);
	}

	private void init(final SimpleClicker game,final Stage stage) {
		randomizeSpawnTime();
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				addNewLivestock(game, stage);
				randomizeSpawnTime();
				Timer.schedule(new Task() {
					
					@Override
					public void run() {
						addNewLivestock(game, stage);
						randomizeSpawnTime();
						
					}
				}, spawnTime);
			}
		}, 0, 5);
	}

	private void addNewLivestock(SimpleClicker game, Stage stage) {
		FlyingLivestock flyingLivestock = null;
		
		switch(MathUtils.random(1, 7)){
		case 1:{	flyingLivestock = new FlyingLivestock(FlyingLivestockType.PIG, game); break;}
		case 2:{	flyingLivestock = new FlyingLivestock(FlyingLivestockType.COW, game); break;}
		case 3:{	flyingLivestock = new FlyingLivestock(FlyingLivestockType.RABBIT, game); break;}
		case 4:{	flyingLivestock = new FlyingLivestock(FlyingLivestockType.SHEEP, game); break;}
		case 5:{	flyingLivestock = new FlyingLivestock(FlyingLivestockType.FOX, game); break;}
		case 6:{	flyingLivestock = new FlyingLivestock(FlyingLivestockType.CRAZYPIG, game); break;}
		case 7:{	flyingLivestock = new FlyingLivestock(FlyingLivestockType.BADCAT, game); break;}
		default: break;
		}
		stage.addActor(flyingLivestock);
		flyingLivestock.fly();		
	}

	private void randomizeSpawnTime() {
		spawnTime = MathUtils.random(5, 10);
	}
}
