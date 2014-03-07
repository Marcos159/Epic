package org.emg.epic_quest;



import org.emg.epic_quest.screens.MainMenuScreen;
import org.emg.epic_quest.util.Constants;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Epic_Quest  extends Game{

	public SpriteBatch batch;
	public BitmapFont font;
	OrthographicCamera camera;
	public int enemigosMatados;
	
	
	@Override
	public void create() {
	
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(true, Constants.SCREEN_WIDTH, 
			Constants.SCREEN_HEIGHT);
		camera.update();
		
		setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
