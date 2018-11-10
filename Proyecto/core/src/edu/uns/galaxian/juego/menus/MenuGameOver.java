package edu.uns.galaxian.juego.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.juego.botones.Boton;
import edu.uns.galaxian.juego.botones.BotonExit;
import edu.uns.galaxian.juego.botones.BotonRestart;
import edu.uns.galaxian.juego.botones.BotonStartGame;

public class MenuGameOver extends Menu{

	private Boton botonRestart;
	private Boton botonExit;
	
	private BitmapFont score;
	private int finalScore;
	
	public MenuGameOver(Juego juego, int score){
		super(juego);
		finalScore=score;
		this.score= new BitmapFont();
	}
	@Override
	
	public void show() {
		Texture texture= new Texture(Gdx.files.internal("menu/startGame2.png"));
		int centroX= Gdx.graphics.getWidth()/2- texture.getWidth()/2;
		int centroY= Gdx.graphics.getHeight()/2- texture.getHeight()/2;
		
		botonRestart=new BotonRestart(centroX,centroY+50, this);
		botonExit= new BotonExit(centroX,centroY-50, this);
				
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        botonRestart.actualizar();
        botonExit.actualizar();
        batch.begin();
		score.draw(batch,"GAME OVER. Final score= "+Integer.toString(finalScore),(Gdx.graphics.getWidth()/2)-80,Gdx.graphics.getHeight()/4);
        botonRestart.draw(batch);
        botonExit.draw(batch);
        batch.end();
	}
}
