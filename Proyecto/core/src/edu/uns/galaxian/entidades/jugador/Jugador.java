package edu.uns.galaxian.entidades.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.EntidadColisionable;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.equipamiento.Arma;
import edu.uns.galaxian.entidades.equipamiento.Escudo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;
import edu.uns.galaxian.juego.Nivel;
import org.json.JSONObject;

public class Jugador extends EntidadViva {

	private static final int TAMANIO_NAVE = 64;
 
	private Disparo disparoJugador;
	private Arma arma;
	private Escudo escudo;
	private ProcesadorInput input;
	private int velocidadMaxima;
	private Nivel nivel;
	
	public Jugador(int xPos, int yPos, int tamano, JSONObject config, Nivel nivel){
	    super(xPos, yPos, tamano, tamano, config.getInt("vidaMaxima"));
		this.nivel = nivel;
		disparoJugador=null;
		// TODO Utilizar el objeto config para setear vida, velocidad maxima, arma, escudo, etc.
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
	public void setEsdcudo(Escudo nuevoEscudo) {
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
	 * Setea el procesador al jugador con el nuevo procesador pasado como parametro.
	 * @param procesadorInput nuevo procesador que tendria el jugado.
	 */
	public void setProcesadorInput(ProcesadorInput procesadorInput) {
		input = procesadorInput;
	}

	// Implementacion de metodos abstractos
	@Override
	public void actualizar() {
		posicion.add(velocidadMaxima * input.getXAxis() * Gdx.graphics.getDeltaTime(), 0);
	}

	@Override
	public void dibujar(SpriteBatch batch) {
		// TODO Dibujarse a si mismo utilizando una textura o similar
	}

	@Override
	public void eliminar() {
		// TODO Eliminar texturas
	}
}
