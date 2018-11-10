package edu.uns.galaxian.juego.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.juego.botones.Boton;
import edu.uns.galaxian.juego.botones.BotonExit;
import edu.uns.galaxian.juego.botones.BotonStartGame;

public class MenuPrincipal extends Menu {

	private Boton start;
	private Boton exit;
	
	public MenuPrincipal(Juego juego){
		super(juego);
	}
	
	@Override
	public void show() {
		Texture texture= new Texture(Gdx.files.internal("menu/startGame2.png"));
		int centroX= Gdx.graphics.getWidth()/2- texture.getWidth()/2;
		int centroY= Gdx.graphics.getHeight()/2- texture.getHeight()/2;
		
		start= new BotonStartGame(centroX,centroY+50, this);
		exit= new BotonExit(centroX,centroY-50, this);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
        start.actualizar();
        exit.actualizar();
    
        batch.begin();
        start.draw(batch);
        exit.draw(batch);
        batch.end();
	}
}
