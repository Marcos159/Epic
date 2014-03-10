package org.emg.epic_quest.managers;




import java.util.Iterator;

import org.emg.epic_quest.Epic_Quest;
import org.emg.epic_quest.characters.Bala;
import org.emg.epic_quest.characters.Enemy;
import org.emg.epic_quest.characters.Player;
import org.emg.epic_quest.screens.GameOverScreen;
import org.emg.epic_quest.util.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class SpriteManager {
	
	private Texture background1;
	private Texture background2;
	private Texture background3;
	private Texture background4;
	Player player;
	public Array<Enemy> enemies;
	Iterator<Enemy> iterEnemy;
	Array<Bala> balas;
	Iterator<Bala> iterBala;
	
	Epic_Quest game;
	public static int vidasJugador=2;
	long momentoUltimaBala;
	
	public SpriteManager(Epic_Quest game) {
		player = new Player(ResourceManager.getAtlas("characters")
				.findRegion("pj_up1"), 100, 0);
			enemies = new Array<Enemy>();
			balas = new Array<Bala>();
			
			this.game=game;
			
			background1 = new Texture("backGrounds/mapa1.png");
		
			background2 = new Texture("backGrounds/mapa2.png");
			
			background3 = new Texture("backGrounds/mapa3.png");
			
			background4 = new Texture("backGrounds/mapa4.png");
			
	}
	
	public void render(SpriteBatch batch) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		if(LevelManager.currentLevel ==1)
		batch.draw(background1, 0, 0);
		if(LevelManager.currentLevel ==2)
			batch.draw(background2, 0, 0);
		if(LevelManager.currentLevel ==3)
			batch.draw(background3, 0, 0);
		if(LevelManager.currentLevel ==4)
			batch.draw(background4, 0, 0);
		
		player.render(batch);
		for (Enemy enemy : enemies)
			enemy.render(batch);
		
		
		for (Bala bala : balas)
			bala.render(batch);
		
		game.font.draw(game.batch, "PUNTOS: "+Epic_Quest.puntosTotales , 15, 20);
		game.font.draw(game.batch, "VIDAS: "+vidasJugador , 15, 50);
		batch.end();
				
	}
	
	
	
	public void update(float dt) {
		handleInput(dt);
		checkCollisions();
		
		player.update(dt);
		for (Enemy enemy : enemies)
			enemy.update(dt);
		for (Bala bala : balas)
			bala.update(dt);
		
	}
	
	private void handleInput(float dt) {
		if(Gdx.input.isKeyPressed(Keys.UP)){
			player.state = Player.State.UP;
			player.move(new Vector2(0,dt));
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN)){
			player.state = Player.State.DOWN;
			player.move(new Vector2(0,-dt));
		}
		else if(Gdx.input.isKeyPressed(Keys.LEFT)){
			player.state = Player.State.LEFT;
			player.move(new Vector2(-dt,0));
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			player.state = Player.State.RIGHT;
			player.move(new Vector2(dt,0));
		}
		if (TimeUtils.nanoTime() - momentoUltimaBala > 250000000){
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				Bala bala = new Bala(ResourceManager.getAnimation("bala"), player.position.x , player.position.y , 130);
				balas.add(bala);
				momentoUltimaBala = TimeUtils.nanoTime();
				ResourceManager.getSound("bala").play();
			}
		}
		
	}
	
	
	private void checkCollisions() {
		iterEnemy = enemies.iterator();
		while (iterEnemy.hasNext()) {
			Enemy enemigo = iterEnemy.next();
			
			if (Intersector.overlaps(enemigo.rect, player.rect)) {
				iterEnemy.remove();	
				vidasJugador--;
				
			}
			if(enemigo.position.y < 0){
				iterEnemy.remove();
				Epic_Quest.puntosTotales = Epic_Quest.puntosTotales - 1;
			}
			
			iterBala = balas.iterator();
			while(iterBala.hasNext()){
				Bala bala = iterBala.next();
				
				if(Intersector.overlaps(enemigo.rect, bala.rect)){
					iterEnemy.remove();
					iterBala.remove();
				}
			}
		}
		
		iterBala = balas.iterator();
		while(iterBala.hasNext()){
			Bala bala = iterBala.next();
			
			if(bala.position.y > Constants.SCREEN_HEIGHT){
				iterBala.remove();
				System.out.println("BALA");
			}
		}
		
	}
}
