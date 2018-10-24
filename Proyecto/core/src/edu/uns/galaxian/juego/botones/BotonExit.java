package edu.uns.galaxian.juego.botones;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.juego.menus.Menu;

public class BotonExit extends Boton {

	public BotonExit(int x, int y, Menu menu) {
		super(x, y, menu);
		textura= new Texture(Gdx.files.internal("menu/exit.png"));
	}

	@Override
	public void funcionamiento() {
		Gdx.app.exit();
	}

}
