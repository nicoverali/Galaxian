package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.ColisionadorBarricada;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.util.enums.Asset;

public class Fragmento extends Barricada {
	
	private static final String TEXTURA_DIR = "obstaculo/meteoro3";

	public Fragmento(Vector2 posicion, Vector2 direccion, Controlador controlador) {
		super(posicion.x, posicion.y, controlador);
		velocidad = direccion;
		vida.setValor(200);
		colisionador = new ColisionadorBarricada(this);
		textura = controlador.getTextureAtlas(Asset.ATLAS_OBSTACULOS.valor()).findRegion(TEXTURA_DIR);
		fuerzaDeColision = 20;
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

}
