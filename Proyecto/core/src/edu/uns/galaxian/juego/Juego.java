package edu.uns.galaxian.juego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import edu.uns.galaxian.juego.menus.MenuPrincipal;
import edu.uns.galaxian.juego.nivel.DirectorNivel;
import edu.uns.galaxian.juego.nivel.NivelDesarrollo;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.juego.config.GameData;
import edu.uns.galaxian.juego.config.SaveData;

public class Juego extends Game {

	public static final String ATLAS_OBSTACULOS = "spritesheets/obstaculos.atlas";
	public static final String ATLAS_NAVES = "spritesheets/naves.atlas";
	public static final String ATLAS_DISPAROS = "spritesheets/disparos.atlas";
	public static final String ATLAS_POWERUP = "spritesheets/powerups.atlas";

	private AssetManager assetManager;
	private EntidadBatch batch;
	private GameData gameData;
	private SaveData saveData;
	private int nivelActual;
	private MenuPrincipal menuPrincipal;

	@Override
	public void create () {
		batch = new EntidadBatch();
		gameData = new GameData();
		saveData = new SaveData();
		nivelActual = saveData.getNivelAlcanzado();
		cargarAssets();

		menuPrincipal= new MenuPrincipal(this);
		setScreen(menuPrincipal);
	}

	/**
	 * Finaliza el juego luego de haber completado
	 * todos los niveles
	 */
	public void finalizarJuego(){
		// TODO Mostrar alguna pantalla de finalizacion
	}

	/**
	 * Verifica si el nivel actual es el ultimo del
	 * juego, en cuyo caso retorna verdadero.
	 * @return Verdadero si el nivel actual es el ultimo
	 */
	public boolean seAlcanzoUltimoNivel(){
		return nivelActual == gameData.getCantidadNiveles();
	}

	/**
	 * Carga el nivel siguiente al actual.
	 * @throws IllegalStateException Si no hay mas nivel
	 */
	public void cargarSiguienteNivel() throws IllegalStateException{
		if(nivelActual == gameData.getCantidadNiveles()){
			throw new IllegalStateException("No hay mas niveles para cargar.");
		}
		new DirectorNivel(this, gameData.getNivel(nivelActual), saveData.getNaveJugador());
	}

	/**
	 * Inicia el nivel actual.
	 */
	public void iniciarNivelActual(){
		new DirectorNivel(this, gameData.getNivel(nivelActual), saveData.getNaveJugador());
	}

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

	private void cargarAssets(){
		assetManager = new AssetManager();
		assetManager.load(ATLAS_NAVES, TextureAtlas.class);
		assetManager.load(ATLAS_OBSTACULOS, TextureAtlas.class);
		assetManager.load(ATLAS_DISPAROS, TextureAtlas.class);
		assetManager.load(ATLAS_POWERUP, TextureAtlas.class);
		assetManager.finishLoading();
	}
}
