package edu.uns.galaxian.colision.hitbox;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.juego.GameObject;

public class HBCirculo implements HitBox {
	
	GameObject objeto;
	float radio;
	
	public HBCirculo(GameObject objeto, float radio) {
		this.objeto = objeto;
		this.radio = radio;
	}

	/**
	 * Retorna el radio del circulo
	 * @return Radio del circulo
	 */
	public float getRadio() {
		return radio;
	}

	public Vector2 getPosicion(){
		return objeto.getPosicion();
	}

	public boolean verificarInterseccion(HitBox hitBox) {
		return hitBox.insersectarConCirculo(this);
	}

	public boolean insersectarConCirculo(HBCirculo circulo) {
		return Intersector.interseccionCirculoCirculo(this, circulo);
	}

	public boolean intersectarConRectangulo(HBRectangulo rectangulo) {
		return Intersector.interseccionRectCirculo(rectangulo, this);
	}
}
