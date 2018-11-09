package edu.uns.galaxian.juego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import edu.uns.galaxian.juego.menus.MenuPrincipal;
import edu.uns.galaxian.juego.nivel.DirectorNivel;
import edu.uns.galaxian.juego.nivel.Nivel;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.juego.config.GameData;
import edu.uns.galaxian.juego.config.SaveData;
import edu.uns.galaxian.juego.menus.MenuGameOver;

public class Juego extends Game {

	public static final String ATLAS_OBSTACULOS = "spritesheets/obstaculos.atlas";
	public static final String ATLAS_NAVES = "spritesheets/naves.atlas";
	public static final String ATLAS_DISPAROS = "spritesheets/disparos.atlas";
	public static final String ATLAS_POWERUP = "spritesheets/powerups.atlas";

	private AssetManager assetManager;
	private EntidadBatch batch;
	private GameData gameData;
	private SaveData saveData;
	private MenuPrincipal menuPrincipal;
	private MenuGameOver menuG;

	@Override
	public void create () {
		batch = new EntidadBatch();
		gameData = new GameData();
		saveData = new SaveData();
		cargarAssets();

		menuPrincipal= new MenuPrincipal(this);
		setScreen(menuPrincipal);
	}

	public void iniciarNivel(){
		new DirectorNivel(this, gameData.getNivel(saveData.getNivelAlcanzado()), saveData.getNaveJugador());
	}
	
	//TODO para el boton restart, por ahora hacer que se inicie nuevamente el nivel, esta mal
	// haces 3 veces restart y te anda todo lento
	public void reiniciarNivel(){
		
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	/**
	 * Devuelve el EntidadBatch del juego.
	 * @return EntidadBatch del juego
	 */
	public EntidadBatch getBatch(){
		return batch;
	}

	/**
	 * Devuelve el AssetManager del juego
	 * @return AssetManager del juego
	 */
	public AssetManager getAssetManager(){
		return assetManager;
	}

	/**
	 * Carga el nivel siguiente al actual.
	 * @param nivelActual Nivel actual
	 */
	public void cargarSiguienteNivel(Nivel nivelActual){
		// TODO Implementar metodo
	}
	
	/**
	 * Muestra la pantalla cuando el jugador pierde
	 */
	public void pantallaGameOver(int score){
		menuG = new MenuGameOver(this, score);
		setScreen(menuG);
	}

	private void cargarAssets(){
		assetManager = new AssetManager();
		assetManager.load(ATLAS_NAVES, TextureAtlas.class);
		assetManager.load(ATLAS_OBSTACULOS, TextureAtlas.class);
		assetManager.load(ATLAS_DISPAROS, TextureAtlas.class);
		assetManager.load(ATLAS_POWERUP, TextureAtlas.class);
		assetManager.finishLoading();
	}
}
