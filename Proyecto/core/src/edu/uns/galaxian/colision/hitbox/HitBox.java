package edu.uns.galaxian.colision.hitbox;

import com.badlogic.gdx.math.Vector2;

public interface HitBox {

	/**
	 * Retorna la posicion del HitBox
	 * @return Posicion del HitBox
	 */
	Vector2 getPosicion();

	/**
	 * Verifica la interseccion con otro hitbox.
	 * Retorna verdadero si se produjo una interseccion,
	 * falso en caso contrario
	 * @param hitBox Otro hitbox con el que se verificara la interseccion
	 * @return Verdadero si se produjo interseccion
	 */
	boolean verificarInterseccion(HitBox hitBox);

	/**
	 * Verifica la interseccion con un rectangulo
	 * @param rectangulo Rectangulo
	 * @return Verdadero si se produjo una interseccion
	 */
	boolean intersectarConRectangulo(HBRectangulo rectangulo);

	/**
	 * Verifica la interseccion con un circulo
	 * @param circulo Circulo
	 * @return Verdadero si se produjo una interseccion
	 */
	boolean insersectarConCirculo(HBCirculo circulo);
	
}