package org.emg.epic_quest.screens;



import org.emg.epic_quest.Epic_Quest;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;

public class MainMenuScreen implements Screen {

	Epic_Quest game;
	
	public MainMenuScreen(Epic_Quest game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		
		
	}
	
	@Override
	public void render(float dt) {
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		game.font.draw(game.batch, "Juego de EPIC QUEST", 
			100, 100);
		game.font.draw(game.batch, "Pulsa cualquier tecla para empezar", 
			100, 70);
		game.font.draw(game.batch, "Pulsa ESCAPE para salir", 
			100, 40);
		game.batch.end();
		
		handleInput();
	}
	
	private void handleInput() {
		
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			game.dispose();
			System.exit(0);
		}
		else if (Gdx.input.isKeyPressed(Keys.ANY_KEY)) {
			System.out.println("presiona");
			game.setScreen(new GameScreen(game));
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
