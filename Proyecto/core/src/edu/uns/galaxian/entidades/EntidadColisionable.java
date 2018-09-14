package edu.uns.galaxian.entidades;
import edu.uns.galaxian.colision.Colisionable;

public abstract class EntidadColisionable extends Entidad implements Colisionable{

	private int alto;
	private int ancho;
	

	public EntidadColisionable(int xPos, int yPos, int alto, int ancho){
		super(xPos, yPos);
		this.alto = alto;
		this.ancho = ancho;
	}

	/**
	 * Devuelve la altura de la entidad en pixeles.
	 * @return Altura de la entidad en pixeles.
	 */
	public int getAlto(){
		return alto;
	}
	
	/**
	 * Devuelve el ancho de la entidad en pixeles
	 * @return Ancho de la entidad en pixeles.
	 */
	public int getAncho(){
		return ancho;
	}
	
	
	
}
