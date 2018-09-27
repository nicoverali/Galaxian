package edu.uns.galaxian.entidades.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorJugador;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.equipamiento.escudos.EscudoNulo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.input.InputKeyboard;
import edu.uns.galaxian.entidades.jugador.input.ProcesadorInput;
import edu.uns.galaxian.entidades.jugador.nave.NaveJugador;
import edu.uns.galaxian.juego.Nivel;

public class Jugador extends EntidadViva {

	private NaveJugador nave;
	private Arma arma;
	private Escudo escudo;
	private ProcesadorInput input;
	private ColisionadorJugador colisionador;
	private Nivel nivel;

	// Constructores	
	public Jugador(int xPos, int yPos, float factorEscala, Nivel nivel, NaveJugador nave, Arma arma, Escudo escudo) {
		super(xPos, yPos, factorEscala, nave.getVidaMax());
		this.nivel = nivel;
		this.nave = nave;
		this.arma = arma;
		this.arma.setDisparoModelo(new DisparoJugador());
		this.escudo = escudo;
		colisionador = new ColisionadorJugador(this);
		input = new InputKeyboard();
	}

	public Jugador(int xPos, int yPos, float factorEscala, Nivel nivel, NaveJugador nave){
		this(xPos, yPos, factorEscala, nivel, nave, new ArmaComun(new DisparoJugador()), new EscudoNulo());
	}

	public Jugador(int xPos, int yPos, Nivel nivel, NaveJugador nave){
		this(xPos, yPos, 1, nivel, nave, new ArmaComun(new DisparoJugador()), new EscudoNulo());
	}

	// Metodos

	/**
	 * Setea el arma del jugador con la nueva pasada como parametro.
	 * @param nuevaArma Nueva arma que tendria el jugador.
	 */
	public void setArma (Arma nuevaArma) {
		arma = nuevaArma;
		arma.setDisparoModelo(new DisparoJugador());
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
		posicion.add((int)(input.getXAxis() * nave.getVelocidad() * Gdx.graphics.getDeltaTime()), 0);
		// Evitar que se salga de la pantalla
		int radio = this.getAncho()/2;
		if(posicion.x + radio > Gdx.graphics.getWidth()) posicion.x = Gdx.graphics.getWidth();
		if(posicion.x - radio < 0) posicion.x = 0;

		if(input.sePresionoDisparar()){
			nivel.agregarDisparo(arma.disparar((int)posicion.x, (int)posicion.y, new Vector2(0,1)));
		}
	}

	public void dibujar(SpriteBatch batch){
		Vector2 pos = getPosicion();
		batch.draw(nave.getTextura(), pos.x - getAncho()/2, pos.y - getAlto()/2, getAncho(), getAlto());
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
