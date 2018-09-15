package edu.uns.galaxian.entidades.jugador;

import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.equipamiento.Arma;
import edu.uns.galaxian.entidades.equipamiento.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.Escudo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.util.enums.Color;

/**
 * Esta clase representa a una entidad controlable por el usuario.
 * Posee distintos equipamientos que utilizara para combatir. Debido a la cantidad
 * de configuraciones que posee, se utiliza una clase JugadorAbstractBuilder a partir de la cual
 * se puede instanciar esta clase.
 */
public abstract class Jugador extends EntidadViva {

	protected static final DisparoJugador DISPARO_JUGADOR = new DisparoJugador();
	private static final int VIDA_MAXIMA = 100; // Debe ser reemplazado

	protected Arma arma;
	protected Escudo escudo;
	protected ProcesadorInput input;
	protected Color color;

	/**
	 * Crea un nuevo jugador obteniendo todos sus atributos a partir del builder recibido.
	 */
	protected Jugador(JugadorAbstractBuilder builder) {
		super(builder.xPos, builder.yPos, builder.factorEscala, VIDA_MAXIMA);
		arma = builder.arma;
		escudo = builder.escudo;
		input = builder.input;
		color = builder.color;
	}

	/**
	 * Posee metodos de configuracion que permiten crear un Jugador con distintos atributos
	 */
	public static abstract class JugadorAbstractBuilder {
		// Configuracion por defecto
		int xPos = 0;
		int yPos = 0;
		float factorEscala = 1;
		Arma arma = new ArmaComun();
		Escudo escudo;
		ProcesadorInput input;
		Color color = Color.AZUL;

		// Build abstracto
		public abstract Jugador build();

		// Metodos
		public JugadorAbstractBuilder setArma(Arma arma){
			this.arma = arma;
			return this;
		}

		public JugadorAbstractBuilder setEscudo(Escudo escudo){
			this.escudo = escudo;
			return this;
		}

		public JugadorAbstractBuilder setProcesadorInput(ProcesadorInput input){
			this.input = input;
			return this;
		}

		public JugadorAbstractBuilder setPosicion(int xPos, int yPos){
			this.xPos = xPos;
			this.yPos = yPos;
			return this;
		}

		public JugadorAbstractBuilder setFactorEscala(float factorEscala){
			this.factorEscala = factorEscala;
			return this;
		}

		public JugadorAbstractBuilder setColor(Color color){
			this.color = color;
			return this;
		}
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
}
