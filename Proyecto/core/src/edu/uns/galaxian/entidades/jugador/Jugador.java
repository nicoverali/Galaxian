package edu.uns.galaxian.entidades.jugador;

import edu.uns.galaxian.controladores.ControladorDisparo;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.equipamiento.Arma;
import edu.uns.galaxian.entidades.equipamiento.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.Escudo;
import edu.uns.galaxian.util.enums.Color;

public abstract class Jugador extends EntidadViva {

	private static final int VIDA_MAXIMA = 100; // Debe ser reemplazado

	protected Arma arma;
	protected Escudo escudo;
	protected ProcesadorInput input;
	protected Color color;
	
	public Jugador(int xPos, int yPos, float factorEscala, int vidaMaxima) {
		super(xPos, yPos, factorEscala, vidaMaxima);
	}

	/**
	 * Setea el arma del jugador con la nueva pasada como parametro.
	 * @param nuevaArma Nueva arma que tendria el jugador.
	 */
	public void setArma (Arma nuevaArma) {
		arma = nuevaArma;
	}
	
	/**
	 * Devuelve el arma que el jugador posee actualmente.
	 * @return Arma que posee el jugador.
	 */
	public Arma getArma() {
		return arma;
	}
	
	/**
	 * Setea el escudo al jugador con el nuevo escudo pasado como parametro.
	 * @param nuevoEscudo nuevo escudo que tendria el jugado.
	 */
	public void setEscudo(Escudo nuevoEscudo) {
		escudo = nuevoEscudo;
	}
	
	/**
	 * Devuelve el escudo que el jugador posee actualmente.
	 * @return Escudo que posee el jugador.
	 */
	public Escudo getEscudo() {
		return escudo;
	}
	
	/**
	 * Cambia el procesador de input del jugador con el nuevo procesador pasado como parametro.
	 * @param procesadorInput Nuevo procesador que tendria el jugado.
	 */
	public void setProcesadorInput(ProcesadorInput procesadorInput) {
		input = procesadorInput;
	}
	
	public abstract void setControladorDisparo(ControladorDisparo c);
	
}
