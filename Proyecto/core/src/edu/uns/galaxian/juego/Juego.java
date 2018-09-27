package edu.uns.galaxian.juego;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.juego.config.AdministradorDatos;
import edu.uns.galaxian.juego.config.ConfigNivel;

public class Juego extends Game {

	private SpriteBatch batch;
	private AdministradorDatos adminDatos;

	@Override
	public void create () {
		batch = new SpriteBatch();
		adminDatos = new AdministradorDatos();

		ConfigNivel configNivel = adminDatos.getConfiguracionNivel(adminDatos.getNivelAlcanzado());
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
	 * Devuelve el SpriteBatch del juego.
	 * @return SpriteBatch del juego
	 */
	public SpriteBatch getBatch(){
		return batch;
	}

	/**
	 * Carga el nivel siguiente al actual.
	 * @param nivelActual Nivel actual
	 */
	public void cargarSiguienteNivel(Nivel nivelActual){
		// TODO Implementar metodo
	}
}
