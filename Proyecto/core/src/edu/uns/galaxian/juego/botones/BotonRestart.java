package edu.uns.galaxian.juego.botones;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.juego.menus.Menu;

public class BotonRestart extends Boton {

	private int finalScore;
	
	public BotonRestart(int x, int y, Menu menu) {
		super(x, y, menu);
		textura= new Texture(Gdx.files.internal("menu/restart2.png"));
		this.finalScore=finalScore;
	}

	@Override
	public void funcionamiento() {
		menu.getJuego().iniciarNivel();
	}


}
