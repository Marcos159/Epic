package org.emg.epic_quest;

import org.emg.epic_quest.util.Constants;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopEpic_Quest {
	public static void main(String[] args) {
		
		LwjglApplicationConfiguration configuracion = new LwjglApplicationConfiguration();
		configuracion.title = "Epic Quest";
		configuracion.width = Constants.SCREEN_WIDTH;
		configuracion.height = Constants.SCREEN_HEIGHT;
		
		
				
		new LwjglApplication(new Epic_Quest(), configuracion);
	}
}
