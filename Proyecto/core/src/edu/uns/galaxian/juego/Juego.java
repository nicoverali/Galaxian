package edu.uns.galaxian.juego;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.juego.config.ConfigNivel;
import edu.uns.galaxian.juego.config.GameData;
import edu.uns.galaxian.juego.config.SaveData;

public class Juego extends Game {

	private static final String TEXTURE_ATLAS_DIR = "spritesheet.atlas";

	private TextureAtlas textureAtlas;
	private EntidadBatch batch;
	private GameData gameData;
	private SaveData saveData;

	@Override
	public void create () {
		batch = new EntidadBatch();
		gameData = new GameData();
		saveData = new SaveData();
		textureAtlas = new TextureAtlas(TEXTURE_ATLAS_DIR);

		ConfigNivel configNivel = gameData.getConfiguracionNivel(saveData.getNivelAlcanzado(), saveData.getNaveJugador());
		setScreen(new Nivel(configNivel,this));
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
	 * Devuelve el TextureAtlas del juego
	 * @return TextureAtlas del juego
	 */
	public TextureAtlas getTextureAtlas(){
		return textureAtlas;
	}

	/**
	 * Carga el nivel siguiente al actual.
	 * @param nivelActual Nivel actual
	 */
	public void cargarSiguienteNivel(Nivel nivelActual){
		// TODO Implementar metodo
	}
}
