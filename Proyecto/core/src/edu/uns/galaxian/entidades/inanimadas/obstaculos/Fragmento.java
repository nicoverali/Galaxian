package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorBarricada;
import edu.uns.galaxian.controlador.Controlador;

public class Fragmento extends Barricada {
	
	private static final String TEXTURA_DIR = "obstaculo/meteoro3";

	public Fragmento(Vector2 posicion, Vector2 direccion, Controlador controlador) {
		super(posicion.x, posicion.y, controlador);
		velocidad = direccion;
		vida.setValor(1000);
		colisionador = new ColisionadorBarricada(this);
		textura = controlador.getTextureAtlas().findRegion(TEXTURA_DIR);
	}
	
	public void actualizar(float d) {
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0) || posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
			restarVida(getVida().getValor());
		}
		else {
			float nuevaPosX = posicion.x + velocidad.x;
			float nuevaPosY = posicion.y + velocidad.y;
			posicion.set(nuevaPosX,nuevaPosY);
		}
	}
	
	public void eliminar() {
		controlador.eliminarEntidad(this);
	}

}
