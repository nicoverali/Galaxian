package edu.uns.galaxian.entidades.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorJugador;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.equipamiento.Arma;
import edu.uns.galaxian.entidades.equipamiento.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.Escudo;
import edu.uns.galaxian.entidades.equipamiento.EscudoNulo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;

public class Jugador extends EntidadViva {

	private NaveJugador nave;
	private Arma arma;
	private Escudo escudo;
	private ProcesadorInput input;
	private ColisionadorJugador colisionador;

	
	public Jugador(int xPos, int yPos, float factorEscala, NaveJugador nave, Arma arma, Escudo escudo, ProcesadorInput input) {
		super(xPos, yPos, factorEscala, nave.getVidaMax());
		this.nave = nave;
		this.arma = arma;
		this.escudo = escudo;
		this.input = input;
		colisionador = new ColisionadorJugador(this);
	}

	public Jugador(int xPos, int yPos, float factorEscala, NaveJugador nave, ProcesadorInput input){
		this(xPos, yPos, factorEscala, nave, new ArmaComun(new DisparoJugador()), new EscudoNulo(), input);
	}

	public Jugador(int xPos, int yPos, NaveJugador nave, ProcesadorInput input){
		this(xPos, yPos, 1, nave, new ArmaComun(new DisparoJugador()), new EscudoNulo(), input);
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
	
	// Implementacion de metodos
	public int getAlto(){
		return (int) Math.ceil(nave.getAlto() * factorEscala);
	}
	
	public int getAncho(){
		return (int) Math.ceil(nave.getAncho() * factorEscala);
	}

	public void restarVida(int vidaARestar) throws IllegalArgumentException{
		if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida a restar no puede ser negativa.");
		}
		int nuevaVida = Math.max(0, this.getVida() - vidaARestar);
		this.setVida(nuevaVida);
	}

	public ColisionadorJugador getColisionador(){
		return colisionador;
	}

	public void aceptarColision(Colisionador col){
		col.colisionarConJugador(this);
	}

	public void actualizar(){
		int nuevaPosEnX = (int) (getPosicion().x + nave.getVelocidad() * Gdx.graphics.getDeltaTime());
		if(jugadorEstaDentroDePantalla(nuevaPosEnX)){
			setPosicion(nuevaPosEnX, (int)getPosicion().y);
		}
	}

	public void dibujar(SpriteBatch batch){
		Vector2 pos = getPosicion();
		batch.draw(nave.getTextura(), pos.x, pos.y, getAncho(), getAlto());
	}

	public void eliminar(){
		// TODO
	}

	private boolean jugadorEstaDentroDePantalla(int xPos){
		int radio = getAncho()/2;
		int extremoIzquierdo = 0;
		int extremoDerecho = Gdx.graphics.getWidth();
		return xPos - radio > extremoIzquierdo && xPos + radio < extremoDerecho;
	}
}
