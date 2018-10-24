package edu.uns.galaxian.juego.botones;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import edu.uns.galaxian.juego.menus.Menu;

public abstract class Boton {
	
	protected Menu menu;
	protected Texture textura;
	protected Rectangle bordes;
	
	protected float xMinima;
	protected float xMaxima;
	
	protected float yMinima;
	protected float yMaxima;
	
	public Boton(int x, int y,Menu menu){
		this.menu=menu;
		//Como los botones tienen la misma longitud, cargo uno cualquiera y le saco los bordes, en este caso Star
		Texture texture= new Texture(Gdx.files.internal("menu/startGame2.png"));
		bordes= new Rectangle(x,y,texture.getWidth(),texture.getHeight());
		
		xMinima=x;
		xMaxima=x+bordes.width;
		
		yMinima=Gdx.graphics.getHeight()- (y+bordes.height);
		yMaxima=Gdx.graphics.getHeight()-y;
			
	}

	public void actualizar() {
		if(sePulso()) {funcionamiento();}
	}

	public boolean sePulso(){
		boolean toReturn= (Gdx.input.isTouched() && Gdx.input.getX()>=xMinima && Gdx.input.getX()<=xMaxima) && 
				   		  (Gdx.input.getY()>=yMinima && Gdx.input.getY()<=yMaxima) ;
		return toReturn;
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(textura, bordes.x, bordes.y, bordes.width, bordes.height);
	}

	public abstract void funcionamiento();
}
