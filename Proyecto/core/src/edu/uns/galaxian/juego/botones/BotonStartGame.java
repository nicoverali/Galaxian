package edu.uns.galaxian.juego.botones;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.juego.menus.Menu;

public class BotonStartGame extends Boton {

	public BotonStartGame(int x, int y, Menu menu) {
		super(x, y,  menu);
		textura= new Texture(Gdx.files.internal("menu/startGame2.png"));
	}
	
	@Override
	public void funcionamiento() {
		menu.getJuego().iniciarNivelActual();
	}

}
