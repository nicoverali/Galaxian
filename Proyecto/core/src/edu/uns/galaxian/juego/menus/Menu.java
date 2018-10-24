package edu.uns.galaxian.juego.menus;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.juego.botones.Boton;
import edu.uns.galaxian.juego.botones.BotonExit;
import edu.uns.galaxian.juego.botones.BotonStartGame;

public abstract class Menu implements Screen {

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
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}


