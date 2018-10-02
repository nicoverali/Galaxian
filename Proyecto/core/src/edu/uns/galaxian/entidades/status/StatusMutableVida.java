package edu.uns.galaxian.entidades.status;

import com.badlogic.gdx.math.Vector2;

public class StatusMutableVida implements StatusVida {

	private Vector2 posicion;
	private Vector2 velocidad;
	private float rotacion;
	private int vida;

	/**
	 * Inicializa el estado actual con todos sus valores por defectos.
	 * La posicion y la velocidad seran vectores nulos, la rotacion sera de 0 grados y la vida valdra 1.
	 */
	public StatusMutableVida()
	{
		posicion = Vector2.Zero;
		velocidad = Vector2.Zero;
		rotacion = 0;
		vida = 1;
	}

	/**
	 * Incializa el estado actual con la informacion provida y la velocidad como vector nulo.
	 * @param posicion Posicion actual
	 * @param rotacion Rotacion actual
	 * @param vida Vida actual
	 */
	public StatusMutableVida(Vector2 posicion, float rotacion, int vida){
		this.posicion = posicion;
		this.velocidad = Vector2.Zero;
		this.rotacion = rotacion;
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
		this.posicion = posicion;
		this.velocidad = velocidad;
		this.rotacion = rotacion;
		this.vida = vida;
	}
	
	public Vector2 getPosicion() {
		return posicion.cpy();
	}

	public Vector2 getVelocidad() {
		return velocidad.cpy();
	}

	public float getRotacion() {
		return rotacion;
	}

	public int getVida()
	{
		return vida;
	}

	/**
	 * Setea un nuevo valor en la posicion.
	 * @param nuevaPosicion Nuevo valor de la posicion
	 */
	public void setPosicion(Vector2 nuevaPosicion)
	{
		posicion = nuevaPosicion;
	}

	/**
	 * Setea un nuevo valor de velocidad.
	 * @param nuevaVelocidad Nuevo valor de velocidad
	 */
	public void setVelocidad(Vector2 nuevaVelocidad)
	{
		velocidad = nuevaVelocidad;
	}

	/**
	 * Setea un nuevo valor de rotacion.
	 * @param nuevaRotacion Nuevo valor de rotacion en grados
	 */
	public void setRotacion(float nuevaRotacion)
	{
		rotacion = nuevaRotacion;
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
