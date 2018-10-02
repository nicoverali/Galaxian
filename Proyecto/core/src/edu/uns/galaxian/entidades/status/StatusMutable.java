package edu.uns.galaxian.entidades.status;

import com.badlogic.gdx.math.Vector2;

public class StatusMutable implements Status {
	
	private Vector2 posicion;
	private Vector2 velocidad;
	private float rotacion;

	/**
	 * Inicializa el estado actual con todos sus valores por defectos.
	 * La posicion y la velocidad seran vectores nulos, la rotacion sera de 0 grados.
	 */
	public StatusMutable(){
		posicion = Vector2.Zero;
		velocidad = Vector2.Zero;
		rotacion = 0;
	}

	/**
	 * Incializa el estado actual con la informacion provida y la velocidad como vector nulo.
	 * @param posicion Posicion actual
	 * @param rotacion Rotacion actual
	 */
	public StatusMutable(Vector2 posicion, float rotacion){
		this.posicion = posicion;
		this.velocidad = Vector2.Zero;
		this.rotacion = rotacion;
	}

	/**
	 * Incializa el estado actual con la informacion provida.
	 * @param posicion Posicion actual
	 * @param velocidad Velocidad actual
	 * @param rotacion Rotacion actual
	 */
	public StatusMutable( Vector2 posicion, Vector2 velocidad, float rotacion){
		this.posicion = posicion;
		this.velocidad = velocidad;
		this.rotacion = rotacion;
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

	/**
	 * Setea un nuevo valor en la posicion.
	 * @param nuevaPosicion Nuevo valor de la posicion
	 */
	public void setPosicion(Vector2 nuevaPosicion)
	{
		posicion = nuevaPosicion;
	}

	/**
	 * Setea un nuevo valor de velocidad
	 * @param nuevaVelocidad Nuevo valor de velocidad
	 */
	public void setVelocidad(Vector2 nuevaVelocidad)
	{
		velocidad = nuevaVelocidad;
	}

	/**
	 * Setea un nuevo valor de rotacion
	 * @param nuevaRotacion
	 */
	public void setRotacion(float nuevaRotacion)
	{
		rotacion = nuevaRotacion;
	}
}
