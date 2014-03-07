package org.emg.epic_quest;



import org.emg.epic_quest.screens.MainMenuScreen;
import org.emg.epic_quest.util.Constants;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Epic_Quest  extends Game{

	public SpriteBatch batch;
	public BitmapFont font;
	OrthographicCamera camera;
	public int enemigosMatados;
	
	private Skin skin;
	
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
	
	public Skin getSkin() {
        if(skin == null ) {
            skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        }
        return skin;
    }	

}
