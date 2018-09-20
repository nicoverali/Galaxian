package edu.uns.galaxian.entidades;
import edu.uns.galaxian.colision.Colisionable;

public abstract class EntidadColisionable extends Entidad implements Colisionable{

	/**
	 * Crea una nueva entidad colisionable con la posicion y el factor de escala dados.
	 * @param xPos Posicion en X de la entidad colisionable
	 * @param yPos Posicion en Y de la entidad colisionable
	 * @param factorEscala Factor de escala de la entidad colisionable
	 */
	public EntidadColisionable(int xPos, int yPos, float factorEscala){
		super(xPos, yPos, factorEscala);
	}

	/**
	 * Crea una nueva entidad colisionable con la posicion dada. El factor de escala sera 1.
	 * @param xPos Posicion en X de la entidad colisionable
	 * @param yPos Posicion en Y de la entidad colisionable
	 */
	public EntidadColisionable(int xPos, int yPos){
		super(xPos, yPos);
	}

	/**
	 * Crea una nueva entidad colisionable con una posicion por defecto y el factor de escala asignado a 1.
	 */
	public EntidadColisionable(){
		super();
	}

	/**
	 * Devuelve la altura de la entidad en pixeles.
	 * @return Altura de la entidad en pixeles.
	 */
	public abstract int getAlto();

	/**
	 * Devuelve el ancho de la entidad en pixeles
	 * @return Ancho de la entidad en pixeles.
	 */
	public abstract int getAncho();
}