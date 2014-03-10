package org.emg.epic_quest.managers;

import java.util.HashMap;
import java.util.Map;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ResourceManager {
	private static Map<String, Texture> textures = new HashMap<String, Texture>();
	private static Map<String, Animation> animations =
			new HashMap<String, Animation>();
		private static Map<String, TextureAtlas> atlas =
			new HashMap<String, TextureAtlas>();
		private static Map<String, Sound> sounds =
			new HashMap<String, Sound>();
		
		private static Map<String, Music> musics =
				new HashMap<String, Music>();
		
		public static void loadAllResources() {		
			/*
			 * Cargamos las animaciones
			 */
			loadResource("characters", new TextureAtlas(
					Gdx.files.internal("characters/Characters.pack")));
			
			
			
			animations.put("player_up",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("pj_up1"),
					getAtlas("characters").findRegion("pj_up2"),
					getAtlas("characters").findRegion("pj_up3")));
			
			animations.put("player_down",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("pj_down1"),
					getAtlas("characters").findRegion("pj_down2"),
					getAtlas("characters").findRegion("pj_down3")));
			
			animations.put("player_left",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("pj_left1"),
					getAtlas("characters").findRegion("pj_left2"),
					getAtlas("characters").findRegion("pj_left3")));
			
			animations.put("player_left",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("pj_left1"),
					getAtlas("characters").findRegion("pj_left2"),
					getAtlas("characters").findRegion("pj_left3")));
			
			animations.put("player_right",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("pj_right1"),
					getAtlas("characters").findRegion("pj_right2"),
					getAtlas("characters").findRegion("pj_right3")));
			
			animations.put("npc",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("npc_down1"),
					getAtlas("characters").findRegion("npc_down2"),
					getAtlas("characters").findRegion("npc_down3")));
			
			animations.put("fantasma",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("fantasma_down1"),
					getAtlas("characters").findRegion("fantasma_down2"),
					getAtlas("characters").findRegion("fantasma_down3")));
			
			animations.put("pirata",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("pirata_down1"),
					getAtlas("characters").findRegion("pirata_down2"),
					getAtlas("characters").findRegion("pirata_down3")));
			
			animations.put("bala",
					new Animation(0.25f, 
					getAtlas("characters").findRegion("pelota")));
			//Cargamos sonidos
			
			ResourceManager.loadResource("theme", Gdx.audio.newMusic(Gdx.files.internal("sounds/zelda.mp3")));
			ResourceManager.loadResource("bala", Gdx.audio.newSound(Gdx.files.internal("sounds/bala.wav")));
			
			
		
		}

		
		
		private static void loadResource(String name, TextureAtlas textureAtlas) {
				
				atlas.put(name, textureAtlas);
			}
		
		
		public static TextureAtlas getAtlas(String name) {
			
			return atlas.get(name);
		}

		public static Map<String, Sound> getSounds() {
			return sounds;
		}
		
		public static Animation getAnimation(String name) {
			
			return animations.get(name);
		}
		/**
		 * Carga un recurso de imagen en memoria
		 * @param name
		 * @param resource
		 */
		public static void loadResource(String name, Texture resource) {
			
			textures.put(name, resource);
		}
		/**
		 * Obtiene un recurso de imagen de memoria
		 * @param name
		 * @return
		 */
		public static Texture getTexture(String name) {
			
			return textures.get(name);
		}
		/**
		 * Carga un recurso de sonido en memoria
		 * @param name
		 * @param sound
		 */
		public static void loadResource(String name, Music music) {
			
			musics.put(name, music);
		}
		/**
		 * Obtiene un recurso de sonido de memoria
		 * @param name
		 * @return
		 */
		public static Music getMusic(String name) {
			
			return  musics.get(name);
		}
		
		/**
		 * Carga un recurso de sonido en memoria
		 * @param name
		 * @param sound
		 */
		public static void loadResource(String name, Sound sound) {
			
			sounds.put(name, sound);
		}
		/**
		 * Obtiene un recurso de sonido de memoria
		 * @param name
		 * @return
		 */
		public static Sound getSound(String name) {
			
			return sounds.get(name);
		}
	
}
