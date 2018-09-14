package edu.uns.galaxian.entidades;

public abstract class EntidadViva extends EntidadColisionable{

	private int vida;
	private int vidaMaximo;
	
	public EntidadViva(int xPos, int yPos, int alto, int ancho, int vidaMaxima){
		super(xPos, yPos, alto, ancho);
		this.vida= vidaMaxima;
		vidaMaximo=vidaMaxima;
	}
	
	public void setVida(int vida) throws IllegalArgumentException
	{
		
		if(vida < 0 || vida > vidaMaximo)
			throw new IllegalArgumentException("La nuevo valor de vida proveido es invalido.");
		this.vida = vida;
	}

	/**
	 * Devuelve la vida actual de la entidad.
	 * @return Cantidad de vida de la entidad.
	 */
	public int getVida(){
		return vida;
	}
	
	
	/**
	 * Setea la vida de la entidad al maximo permitido.
	 */
	public void setVidaAlMaximo(){
		vida = vidaMaximo;
	}
}
