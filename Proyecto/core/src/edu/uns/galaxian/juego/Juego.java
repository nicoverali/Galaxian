package edu.uns.galaxian.juego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import edu.uns.galaxian.juego.nivel.DirectorNivel;
import edu.uns.galaxian.juego.nivel.Nivel;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.juego.config.GameData;
import edu.uns.galaxian.juego.config.SaveData;
import edu.uns.galaxian.juego.menus.Menu;
import edu.uns.galaxian.juego.menus.MenuGameOver;
import edu.uns.galaxian.juego.menus.MenuPrincipal;

public class Juego extends Game {

	private static final String TEXTURE_ATLAS_DIR = "spritesheet.atlas";

	private TextureAtlas textureAtlas;
	private EntidadBatch batch;
	private GameData gameData;
	private SaveData saveData;
	private Menu menuPrincipal;
	private MenuGameOver menuG;

	@Override
	public void create () {
		batch = new EntidadBatch();
		gameData = new GameData();
		saveData = new SaveData();
		textureAtlas = new TextureAtlas(TEXTURE_ATLAS_DIR);

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
	
	/**
	 * Muestra la pantalla cuando el jugador pierde
	 */
	public void pantallaGameOver(int score){
		menuG = new MenuGameOver(this, score);
		setScreen(menuG);
	}
}
