package org.emg.epic_quest.screens;

import org.emg.epic_quest.Epic_Quest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class GameOverScreen implements Screen {
	
	final Epic_Quest juego;
	
	Stage menu;
	Table tablaMenu;
	TextField tfNombre;
	
	OrthographicCamera camara;
	
	public GameOverScreen(Epic_Quest juego) {
		this.juego = juego;
		
		camara = new OrthographicCamera();
		camara.setToOrtho(false, 1024, 768);
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0.3f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camara.update();
		
		
		/*
		 * Si el usuario toca la pantalla se inicia la partida
		 */
		if (Gdx.input.isKeyPressed(Keys.N)) {
			/*
			 * Aquí habrá que reiniciar algunos aspectos del
			 * juego de cara a empezar una nueva partida
			 */

			juego.setScreen(new GameScreen(juego));
		}
		/*
		 * El usuario pulsa la tecla ESCAPE, se sale del juego
		 */
		else if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			dispose();
			System.exit(0);
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		juego.dispose();
	}
}

