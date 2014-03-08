package org.emg.epic_quest.screens;


import org.emg.epic_quest.Epic_Quest;
import org.emg.epic_quest.managers.LevelManager;
import org.emg.epic_quest.managers.ResourceManager;
import org.emg.epic_quest.managers.SpriteManager;
import org.emg.epic_quest.util.Constants;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen implements Screen {
	
	Epic_Quest game;
	LevelManager levelManager;
	SpriteManager spriteManager;
	float tiempoJuego;
	Music musicaTheme;
	
	public GameScreen(Epic_Quest game) {
		this.game = game;
		tiempoJuego = 43;
		ResourceManager.loadAllResources();
		
		Texture.setEnforcePotImages(false);
		
		spriteManager = new SpriteManager(game);
		levelManager = new LevelManager(spriteManager);
		levelManager.loadCurrentLevel();
		
		musicaTheme = Gdx.audio.newMusic(Gdx.files.internal("sounds/zelda.mp3"));
		
		// Inicia la música de fondo del juego en modo bucle
		musicaTheme.setLooping(true);
				
		/*musicaTheme= ResourceManager.getMusic("theme");
		musicaTheme.setLooping(true);*/
	}
	
	@Override
	public void show() {
		
		musicaTheme.play();
	}
	
	@Override
	public void render(float dt) {
		spriteManager.update(dt);
		spriteManager.render(game.batch);
		
		// Actualiza el tiempo de juego
		tiempoJuego -= Gdx.graphics.getDeltaTime();
		
			
		if (tiempoJuego < 0) {
			dispose();
			tiempoJuego = 43;
			if(levelManager.currentLevel == 4){
				musicaTheme.stop();
				spriteManager.enemies.clear();
				game.setScreen(new GameOverScreen(game));
				
			}else{
				levelManager.passLevel();
			}
			
		}
	}
	
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}
