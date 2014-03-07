package org.emg.epic_quest.characters;


import org.emg.epic_quest.managers.ResourceManager;
import org.emg.epic_quest.util.Constants;
import org.emg.epic_quest.util.Posiciones;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player extends Character{
	public enum State{
		RIGHT, LEFT, UP, DOWN, IDLE
	}
	public State state;
	float speed = 300;
	
	Animation animationRight;
	Animation animationLeft;
	Animation animationUp;
	Animation animationDown;
	TextureRegion idleFrame;
	float posicionx;
	float posiciony;
	//Posiciones posiciones;
	
	public Player(TextureRegion texture, float x, float y) {
		super(texture, x, y);
		
		//posiciones =new Posiciones();
		
		idleFrame = texture;
		animationRight = ResourceManager.getAnimation("player_right");
		animationLeft = ResourceManager.getAnimation("player_left");
		animationUp = ResourceManager.getAnimation("player_up");
		animationDown = ResourceManager.getAnimation("player_down");
		
		state = State.IDLE;
	}
	
	public void move(Vector2 movement){
		movement.scl(speed);
		position.add(movement);
		
		Posiciones.posX=position.x;
		Posiciones.posY = position.y;
		
		rect.x = position.x;
		rect.y = position.y;
		
		if(position.x<0){
			position.x = 0;
		}
		if(position.x > Constants.SCREEN_WIDTH - idleFrame.getRegionWidth() ){
			idleFrame.getRegionWidth();
			position.x = Constants.SCREEN_WIDTH - currentFrame.getRegionWidth();
		}
		if(position.y < 0){
			position.y =0;
		}
		if(position.y + currentFrame.getRegionHeight() > Constants.SCREEN_HEIGHT){
			position.y = Constants.SCREEN_HEIGHT - currentFrame.getRegionHeight();
		}
		
	}
	
	@Override
	public void update(float dt) {
		
		stateTime += dt;
		switch (state) {
		case RIGHT:
			currentFrame = animationRight.getKeyFrame(stateTime, true);
			break;
		case LEFT:
			currentFrame = animationLeft.getKeyFrame(stateTime, true);
			break;
		case UP:
			currentFrame = animationUp.getKeyFrame(stateTime, true);
			break;
		case DOWN:
			currentFrame = animationDown.getKeyFrame(stateTime, true);
			break;
		case IDLE:
			currentFrame = idleFrame;
			break;
		default:
			currentFrame = idleFrame;
		}
	}

}
