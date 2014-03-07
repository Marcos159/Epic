package org.emg.epic_quest.characters;



import org.emg.epic_quest.util.Constants;
import org.emg.epic_quest.util.Posiciones;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

/**
 * Clase que representa a todos los enemigos
 * que me pueden atropellar y matar:
 * Coches, gruas y camiones
 * @author Santiago Faci
 *
 */
public class Enemy extends Character {
	float speed;
	String tipo;

	public Enemy(Animation animation, float x, float y, float speed, String tipo) {
		super(animation, x, y);
		
		this.tipo=tipo;
		this.speed = speed;
	}
	
	@Override
	public void update(float dt){
		super.update(dt);
		if(tipo.equals("pirata")){
			
			if(position.x > Posiciones.posX){
				position.add(new Vector2(-dt * speed,-dt * speed ));
				rect.x = position.x;
				rect.y = position.y;
			}
			if(position.x< Posiciones.posX){
				position.add(new Vector2(dt * speed,-dt * speed ));
				rect.x = position.x;
				rect.y = position.y;
			}
			
		}else{
			position.add(new Vector2(0,-dt * speed ));
			rect.x = position.x;
			rect.y = position.y;
		}
		
		if(position.y < 0){
			
			
		}
	}
}
