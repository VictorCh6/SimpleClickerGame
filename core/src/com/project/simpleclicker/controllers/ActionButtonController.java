package com.project.simpleclicker.controllers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.project.simpleclicker.SimpleClicker;
import com.project.simpleclicker.ui.ActionButton;
import com.project.simpleclicker.ui.IClickCallback;

public class ActionButtonController {

	private ActionButton actionButton;
	private ActionButton actionButton2;

	
	public ActionButtonController(SimpleClicker game, Stage stage) {
		init(game, stage );
	
	}
	

	private void init(SimpleClicker game, Stage stage) {
		initActionButton(game, stage);	
		
	}

	private void initActionButton(final SimpleClicker game, Stage stage){
		
		/*
		 * ACTION BUTTON 1 Action
		 */
		actionButton = new ActionButton(new IClickCallback() {
			
			@Override
			public void onClick() {
			   
				game.addPoints();
				System.out.println("Action Button1");
			}
		}, 290);
		stage.addActor(actionButton);
		/*
		 * ACTION BUTTON 2 Action
		 */
		actionButton2 = new ActionButton(new IClickCallback() {
		
			@Override
			public void onClick() {
			
				game.addPoints();
				System.out.println("Action Button2");
			}
		}, 50);
		stage.addActor(actionButton2);

	}		
}
