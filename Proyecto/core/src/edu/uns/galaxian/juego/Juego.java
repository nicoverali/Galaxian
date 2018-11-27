package edu.uns.galaxian.juego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.*;
import edu.uns.galaxian.juego.screen.nivel.DirectorNivel;
import edu.uns.galaxian.juego.screen.Principal.Principal;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.juego.config.GameData;
import edu.uns.galaxian.juego.config.SaveData;

public class Juego extends Game {

	public static final String ATLAS_OBSTACULOS = "spritesheets/obstaculos.atlas";
	public static final String ATLAS_NAVES = "spritesheets/naves.atlas";
	public static final String ATLAS_DISPAROS = "spritesheets/disparos.atlas";
	public static final String ATLAS_POWERUP = "spritesheets/powerups.atlas";
	public static final String ATLAS_UI = "spritesheets/ui.atlas";

	private AssetManager assetManager;
	private EntidadBatch batch;
	private GameData gameData;
	private SaveData saveData;
	private int nivelActual;

	@Override
	public void create () {
		batch = new EntidadBatch();
		gameData = new GameData();
		saveData = new SaveData();
		nivelActual = saveData.getNivelAlcanzado();
		cargarAssets();

		setScreen(new Principal(this));
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

	/**
	 * Vuelve al menu principal del juego
	 */
	public void volverAlMenuPrincipal(){
		setScreen(new Principal(this));
	}

	public void dispose () {
		batch.dispose();
		assetManager.dispose();
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

		// Carga de texturas
		assetManager.load(ATLAS_NAVES, TextureAtlas.class);
		assetManager.load(ATLAS_OBSTACULOS, TextureAtlas.class);
		assetManager.load(ATLAS_DISPAROS, TextureAtlas.class);
		assetManager.load(ATLAS_POWERUP, TextureAtlas.class);
		assetManager.load(ATLAS_UI, TextureAtlas.class);
		assetManager.load("menu/logo.png", Texture.class);

		// Carga de fuentes
		FileHandleResolver resolver = new InternalFileHandleResolver();
		assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		FreeTypeFontLoaderParameter normalFont = new FreeTypeFontLoaderParameter();
		normalFont.fontFileName = "fonts/PressStart2P.ttf";
		normalFont.fontParameters.size = 16;
		assetManager.load("fonts/PressStart2P.ttf", BitmapFont.class, normalFont);

		// Carga de audio
		assetManager.load("audio/start.wav", Sound.class);
		assetManager.load("audio/menuFocus.wav", Sound.class);
		assetManager.load("audio/mainTheme.mp3", Music.class);
		assetManager.finishLoading();
	}
}
