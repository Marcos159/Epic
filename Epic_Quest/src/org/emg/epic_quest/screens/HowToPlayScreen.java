package org.emg.epic_quest.screens;

import org.emg.epic_quest.Epic_Quest;
import org.emg.epic_quest.util.Constants;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class HowToPlayScreen implements Screen {
	Epic_Quest game;
	Stage stage;
	
	public HowToPlayScreen(Epic_Quest game) {
		this.game = game;
	}
	
private void loadScreen() {
		
		// Grafo de escena que contendrá todo el menú
		stage = new Stage();
					
		// Crea una tabla, donde añadiremos los elementos de menú
		Table table = new Table();
		table.setPosition(Constants.SCREEN_WIDTH / 2.5f, Constants.SCREEN_HEIGHT / 1.5f);
		// La tabla ocupa toda la pantalla
	    table.setFillParent(true);
	    table.setHeight(500);
	    stage.addActor(table);
		
	    // Etiqueta de texto
		Label label = new Label("INSTRUCCIONES", game.getSkin());
		table.addActor(label);
		
		Label label2 = new Label("El juego trata de sobrevivir 4 rondas de enemigos. \n " +
				"Una vez terminadas las 4 rondas podemos ver nuestra puntuacion \n y meterla a una base de datos.\n" +
				"La mecanica del juego es muy simple: Se maneja con las flechas \n y se dispara con la barra espaciadora.\n" +
				" Los enemigos suelen variar en funcion de la velocidad e intentan\n entrar a la aldea pero hay uno especial \n" +
				" que intentará atraparte", game.getSkin());
		
		table.addActor(label2);
		
		label2.setPosition(label.getOriginX()-190, label.getOriginY() - 170);
		// Botón
		TextButton buttonQuit = new TextButton("Volver", game.getSkin());
		buttonQuit.setPosition(label.getOriginX(), label.getOriginY() - 270);
		buttonQuit.setWidth(200);
		buttonQuit.setHeight(40);
		buttonQuit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;	
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				
				game.setScreen(new MainMenuScreen(game));
			}
		});
		table.addActor(buttonQuit);
		
		Gdx.input.setInputProcessor(stage);
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
	public void render(float dt) {
		Gdx.gl.glClearColor(0, 0.2f, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(dt);
		stage.draw();
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		loadScreen();
		
	}

}
