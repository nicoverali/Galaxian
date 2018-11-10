package edu.uns.galaxian.juego.menus;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.juego.Juego;

public abstract class Menu extends ScreenAdapter {

	protected Juego juego;
	protected SpriteBatch batch;
	
	public Menu(Juego juego){
		this.juego=juego;	
		batch= juego.getBatch();
	}
	
	//chequear idea de iniciar juego, en operacion funcionamiento en la clase BotonStarGame
	public Juego getJuego() {
		return juego;
	}
}


