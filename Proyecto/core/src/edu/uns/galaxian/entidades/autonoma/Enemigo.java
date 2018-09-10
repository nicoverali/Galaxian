package edu.uns.galaxian.entidades.autonoma;

import java.util.List;
import edu.uns.galaxian.entidades.equipamiento.*;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.controladores.ControladorEnemigo;
// TODO Implementar metodos heredados
public class Enemigo implements EntidadAutonoma{

	private ControladorEnemigo controlador;
	private Arma arma;
	
	/**
	 * Setea el arma del enemigo con la nueva pasada como par�metro.
	 * @param nuevaArma Nueva arma que tendr� el enemigo.
	 */
	public void setArma(Arma nuevaArma) {
		arma = nuevaArma;
	}
	
	/**
	 * Devuelve el arma que el enemigo posee actualmente.
	 * @return Arma que posee el enemigo.
	 */
	public Arma getArma() {
		return arma;
	}
	
	/**
	 * Devuelve un nuevo disparo realizado por el enemigo.
	 * @return Disparo realizado por el enemigo.
	 */
	public List<Disparo> disparar() {
		return arma.disparar();
	}

	// Implementacion de metodos abstractos

	public
}
