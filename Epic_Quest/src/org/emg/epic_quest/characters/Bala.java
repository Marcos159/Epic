package org.emg.epic_quest.characters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

public class Bala extends Character {
	float speed;
	public Bala(Animation animation, float x, float y, float speed) {
		super(animation, x, y);
		
		this.speed = speed;
	}
	
	@Override
	public void update(float dt){
		super.update(dt);
		
		position.add(new Vector2(0,dt * speed ));
		rect.x = position.x;
		rect.y = position.y;
		
		if(position.y < 0){
			//TODO ELIMINAR ENEMIGO
			
		}
	}
}
