package edu.uns.galaxian.entidades.jugador;

import java.util.List;

import edu.uns.galaxian.entidades.EntidadColisionable;
import edu.uns.galaxian.entidades.equipamiento.Arma;
import edu.uns.galaxian.entidades.equipamiento.Escudo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class Jugador {
 
	private Arma arma;
	private Escudo escudo;
	private ProcesadorInput input;
	private float velocidadMaxima;
	private CargadorNivel nivel;
	
	public Jugador(){}
	
	/**
	 * Devuelve un nuevo disparo realizado por el jugador.
	 * @return Disparo realizado por el jugador.
	 */
	public List<Disparo> disparar() {
		return arma.disparar();
	}
	
	/**
	 * Setea el arma del jugador con la nueva pasada como parametro.
	 * @param nuevaArma Nueva arma que tendria el jugador.
	 */
	public void setArma (Arma nuevaArma) {
		arma=nuevaArma;
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
	 * @param nuevaEscudo nuevo escudo que tendria el jugado.
	 */
	public void setEsdcudo(Escudo nuevoEscudo) {
		escudo=nuevoEscudo;
	}
	
	/**
	 * Devuelve el escudo que el jugador posee actualmente.
	 * @return Escudo que posee el jugador.
	 */
	public Escudo getEscudo() {
		return escudo;
	}
	
	/**
	 * Setea el procesador al jugador con el nuevo procesador pasado como parametro.
	 * @param ProcesadorInput nuevo procesador que tendria el jugado.
	 */
	public void setProcesadorInput(ProcesadorInput procesadorInput) {
		input=procesadorInput;
	}
	
}
