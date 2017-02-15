package com.project.simpleclicker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.project.simpleclicker.SimpleClicker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = SimpleClicker.GAME_NAME;
		config.width = SimpleClicker.WIDTH;
		config.height = SimpleClicker.HEIGHT;
		config.resizable = false;
		
		
		new LwjglApplication(new SimpleClicker(), config);
	}
}
