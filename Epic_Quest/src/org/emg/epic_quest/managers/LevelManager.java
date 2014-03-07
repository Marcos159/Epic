package org.emg.epic_quest.managers;

import org.emg.epic_quest.characters.Enemy;
import org.emg.epic_quest.util.Constants;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.files.FileHandle;



public class LevelManager {

	SpriteManager spriteManager;
	public static int currentLevel;
	
	public LevelManager(SpriteManager spriteManager) {
		this.spriteManager = spriteManager;
		currentLevel =1;
	}
	

	public void loadCurrentLevel() {
		
		FileHandle file = Gdx.files.internal("levels/level" + currentLevel + ".txt");

		String levelInfo = file.readString();
		
		
		int x = 0, y = Constants.SCREEN_HEIGHT+1216 - Constants.BRICK_HEIGHT;
		
		String[] rows = levelInfo.split("\n");
		
		for (String row : rows) {
			String[] brickIds = row.split(",");
			
			for (String brickId : brickIds) {
	
				if (brickId.trim().equals("-")) {
					x += Constants.BRICK_WIDTH;
					continue;
				}
				
				if (brickId.trim().equals("f")) {
					Enemy enemy = new Enemy(ResourceManager.getAnimation("fantasma"), x , y, 90, "fantasma");
					spriteManager.enemies.add(enemy);
					x += Constants.BRICK_WIDTH;
					continue;
				}
				
				if (brickId.trim().equals("p")) {
					Enemy enemy = new Enemy(ResourceManager.getAnimation("pirata"), x , y, 100, "pirata");
					spriteManager.enemies.add(enemy);
					x += Constants.BRICK_WIDTH;
					continue;
				}
				
				if (brickId.trim().equals("n")) {
					Enemy enemy = new Enemy(ResourceManager.getAnimation("npc"), x , y, 80, "npc");
					spriteManager.enemies.add(enemy);
					x += Constants.BRICK_WIDTH;
					continue;
				}
				
			}		
			x = 0;
			y -= Constants.BRICK_HEIGHT;
		}
		
		
	}
	
	/**
	 * Pasa al siguiente nivel
	 */
	public void passLevel() {
		
		currentLevel++;
		resetLevel();
		loadCurrentLevel();
		
	}
	/**
	 * Resetea el nivel actual
	 */
	private void resetLevel() {
		
		spriteManager.enemies.clear();
		
	}
}
