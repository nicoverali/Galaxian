package edu.uns.galaxian.colision.hitbox;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.juego.GameObject;

public class HBRectangulo implements HitBox {
	
	private GameObject objeto;
	private float alto;
	private float ancho;
	
	public HBRectangulo(GameObject objeto, float alto, float ancho){
		this.objeto = objeto;
		this.alto = alto;
		this.ancho = ancho;
	}

	/**
	 * Retorna el ancho del rectangulo
	 * @return Ancho del rectangulo
	 */
	public float getAncho() {
		return ancho;
	}

	/**
	 * Retorna el alto del rectangulo
	 * @return Alto del rectangulo
	 */
	public float getAlto() {
		return alto;
	}

	public Vector2 getPosicion(){
		return objeto.getPosicion();
	}

	public boolean verificarInterseccion(HitBox hitBox) {
		return hitBox.intersectarConRectangulo(this);
	}

	public boolean intersectarConRectangulo(HBRectangulo rectangulo) {
		return Intersector.interseccionRectRect(this, rectangulo);
	}

	public boolean insersectarConCirculo(HBCirculo circulo) {
		return Intersector.interseccionRectCirculo(this, circulo);
	}
	
}