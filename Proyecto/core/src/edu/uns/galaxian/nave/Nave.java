package edu.uns.galaxian.nave;

import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;

public abstract class Nave<T extends Disparo> {

	protected Arma<T> arma;
	protected Escudo escudo;
	protected String texturaDir;

	public Nave(Arma<T> arma, Escudo escudo, String texturaDir){
		this.arma = arma;
		this.escudo = escudo;
		this.texturaDir = texturaDir;
	}

	/**
	 * Retorna la vida maxima de la nave.
	 * @return Vida maxima de la nave
	 */
	public abstract int getVidaMax();

	/**
	 * Retorna la velocidad maxima de la nave.
	 * @return Velocidad maxima de la nave
	 */
	public abstract float getVelocidadMax();

	/**
	 * Retorna la direccion de la textura correspondiente
	 * @return Direccion de la textura
	 */
	public String getTexturaDir(){
		return texturaDir;
	}

	/**
	 * Retorna el arma de la nave.
	 * @return Arma de la nave
	 */
	public Arma<T> getArma(){
		return arma;
	}

	/**
	 * Reemplaza el arma actual de la nave por una nueva.
	 * @param nuevaArma Nueva arma de la nave
	 */
	public void setArma(Arma<T> nuevaArma){
		arma = nuevaArma;
	}

	/**
	 * Retorna el escudo de la nave.
	 * @return Escudo de la nave
	 */
	public Escudo getEscudo(){
		return escudo;
	}

	/**
	 * Reemplaza el escudo actual de la nave por uno nuevo.
	 * @param nuevoEscudo Nuevo escudo de la nave
	 */
	public void setEscudo(Escudo nuevoEscudo){
		escudo = nuevoEscudo;
	}

	// TODO public void dibujarEquipamiento(EntidadBatch batch);
}
