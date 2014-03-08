package org.emg.epic_quest.screens;

import java.util.List;

import org.emg.epic_quest.Epic_Quest;
import org.emg.epic_quest.managers.ConfigurationManager;
import org.emg.epic_quest.managers.ConfigurationManager.Score;
import org.emg.epic_quest.util.Constants;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class GameOverScreen implements Screen {
	
	
	
	Epic_Quest game;
	Stage stage;

	private boolean done;
	
	public GameOverScreen(Epic_Quest juego) {
		this.game = juego;
		
		
		done = false;
	}
	
private void loadScreen() {
		
	// Grafo de escena que contendr� todo el men�
			stage = new Stage();
						
			// Crea una tabla, donde a�adiremos los elementos de men�
			final Table table = new Table();
			table.setPosition(Constants.SCREEN_WIDTH / 2.5f, Constants.SCREEN_HEIGHT / 1.5f);
			// La tabla ocupa toda la pantalla
		    table.setFillParent(true);
		    table.setHeight(500);
		    stage.addActor(table);
			
			final Label label = new Label("Mejores puntuaciones EPIC QUEST", game.getSkin());
			table.addActor(label);
			
			// Carga la lista de puntuaciones (top 10)
			loadScores(table, stage, label.getOriginX(), -50);
			
			Label labelScore = new Label("Tu puntuacion: " + Epic_Quest.puntosTotales, game.getSkin());
			labelScore.setPosition(label.getOriginX(), label.getOriginY() - 300);
			table.addActor(labelScore);
			
			// El usuario ya ha rellenado su nombre
			if (done) {
				TextButton buttonQuit = new TextButton("Volver", game.getSkin());
				buttonQuit.setPosition(label.getOriginX(), label.getOriginY() - 350);
				buttonQuit.setWidth(200);
				buttonQuit.setHeight(40);
				buttonQuit.addListener(new InputListener() {
					public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
						return true;	
					}
					public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
						Epic_Quest.puntosTotales=0;
						game.setScreen(new MainMenuScreen(game));
					}
				});
				table.addActor(buttonQuit);
			}
			else {
			// El usuario a�n no he escrito su nombre
				final TextField textName = new TextField("Introduce tu nombre", game.getSkin());
				textName.setPosition(label.getOriginX(), label.getOriginY() - 350);
				textName.setWidth(200);
				textName.setHeight(40);
				table.addActor(textName);
				
				TextButton buttonQuit = new TextButton("Ok", game.getSkin());
				buttonQuit.setPosition(label.getOriginX(), label.getOriginY() - 400);
				buttonQuit.setWidth(200);
				buttonQuit.setHeight(40);
				buttonQuit.addListener(new InputListener() {
					public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
						return true;	
					}
					public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
						
						ConfigurationManager.addScores(textName.getText(),  Epic_Quest.puntosTotales);
						stage.clear();
						done = true;
						loadScreen();
					}
				});
				table.addActor(buttonQuit);
			}
			
			
			Gdx.input.setInputProcessor(stage);
}

private void loadScores(Table table, Stage stage, float x, float y) {
	
	// Lee las puntuaciones
	List<Score> scores = ConfigurationManager.getTopScores();
	
	Label labelList = null;
	for (Score score : scores) {
		labelList = new Label(score.name + " - " + score.score, game.getSkin());
		labelList.setPosition(x, y);
		table.addActor(labelList);
		y -= 20;
	}
}
	
	@Override
	public void render(float dt) {
		
		Gdx.gl.glClearColor(0, 0.3f, 0.6f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		/*if (Gdx.input.isKeyPressed(Keys.N)) {
			

			game.setScreen(new GameScreen(game));
		}
		
		else if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			dispose();
			System.exit(0);
		}
		*/
		// Pinta el men�
				stage.act(dt);
				stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		loadScreen();
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
		game.dispose();
	}
}

