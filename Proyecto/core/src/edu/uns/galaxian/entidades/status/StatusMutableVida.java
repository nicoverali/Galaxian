package edu.uns.galaxian.entidades.status;

import com.badlogic.gdx.math.Vector2;

public class StatusMutableVida extends StatusMutable implements StatusVida {

	private int vida;

	/**
	 * Inicializa el estado actual con todos sus valores por defectos.
	 * La posicion y la velocidad seran vectores nulos, la rotacion sera de 0 grados y la vida valdra 1.
	 */
	public StatusMutableVida()
	{
		super();
		vida = 1;
	}

	/**
	 * Incializa el estado actual con la informacion provida y la velocidad como vector nulo.
	 * @param posicion Posicion actual
	 * @param rotacion Rotacion actual
	 * @param vida Vida actual
	 */
	public StatusMutableVida(Vector2 posicion, float rotacion, int vida){
		super(posicion, rotacion);
		this.vida = vida;
	}

	/**
	 * Incializa el estado actual con la informacion provida.
	 * @param posicion Posicion actual
	 * @param velocidad Velocidad actual
	 * @param rotacion Rotacion actual
	 * @param vida Vida actual
	 */
	public StatusMutableVida(Vector2 posicion, Vector2 velocidad, float rotacion, int vida)
	{
		super(posicion, velocidad, rotacion);
		this.vida = vida;
	}

	public int getVida()
	{
		return vida;
	}

	/**
	 * Setea un nuevo valor de vida
	 * @param nuevaVida Nuevo valor de vida
	 */
	public void setVida(int nuevaVida) throws IllegalArgumentException{
		if(nuevaVida < 0){
			throw new IllegalArgumentException("La vida no puede ser negativa.");
		}
		vida = nuevaVida;
	}
}
