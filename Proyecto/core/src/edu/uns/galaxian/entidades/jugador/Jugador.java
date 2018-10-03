package edu.uns.galaxian.entidades.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorJugador;
import edu.uns.galaxian.controladores.ControladorDisparo;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.input.InputKeyboard;
import edu.uns.galaxian.entidades.jugador.input.ProcesadorInput;
import edu.uns.galaxian.entidades.status.StatusMutableVida;
import edu.uns.galaxian.entidades.status.StatusVida;
import edu.uns.galaxian.juego.Nivel;
import edu.uns.galaxian.nave.jugador.NaveJugador;

public class Jugador implements EntidadViva {

	private StatusMutableVida status;
	private NaveJugador nave;
	private ProcesadorInput input;
	private Nivel nivel;
	private ControladorDisparo controladorDisparo;
	private ColisionadorJugador colisionador;

	// Constructores	
	public Jugador(float xPos, float yPos, NaveJugador nave, Nivel nivel, ControladorDisparo controladorDisparo) {
		this.nave = nave;
		this.nivel = nivel;
		this.controladorDisparo = controladorDisparo;

		status = new StatusMutableVida(new Vector2(xPos, yPos), nave.getRotacionInicial(), nave.getVidaMax());
		colisionador = new ColisionadorJugador(this);
		input = new InputKeyboard();
	}

	/**
	 * Setea el arma del jugador con la nueva pasada como parametro.
	 * @param nuevaArma Nueva arma que tendra el jugador.
	 */
	public void setArma (Arma nuevaArma) {
		nuevaArma.setDisparoModelo(new DisparoJugador());
		nave.setArma(nuevaArma);
	}
	
	/**
	 * Devuelve el arma que el jugador posee actualmente.
	 * @return Arma que posee el jugador.
	 */
	public Arma getArma() {
		return nave.getArma();
	}
	
	/**
	 * Setea el escudo al jugador con el nuevo escudo pasado como parametro.
	 * @param nuevoEscudo Nuevo escudo que tendra el jugado.
	 */
	public void setEscudo(Escudo nuevoEscudo) {
		nave.setEscudo(nuevoEscudo);
	}
	
	/**
	 * Devuelve el escudo que el jugador posee actualmente.
	 * @return Escudo que posee el jugador.
	 */
	public Escudo getEscudo() {
		return nave.getEscudo();
	}

	public StatusVida getStatus(){
		return status;
	}

	public float getAlto(){
		return nave.getAlto();
	}
	
	public float getAncho(){
		return nave.getAncho();
	}

	public void restarVida(int vidaARestar) throws IllegalArgumentException{
		if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida a restar no puede ser negativa.");
		}
		int nuevaVida = status.getVida() - vidaARestar;
		status.setVida(Math.max(0, nuevaVida));
	}

	public void setVidaAlMaximo(){
		status.setVida(nave.getVidaMax());
	}


	public void actualizar(float delta){
		Vector2 nuevaPosicion = status.getPosicion().add(input.getXAxis() * nave.getVelocidadMax() * delta, 0);
		if(posicionDentroDePantalla(nuevaPosicion)){
			status.setPosicion(nuevaPosicion);
		}
		if(input.sePresionoDisparar()){
			Vector2 posicion = status.getPosicion();
			float rotacion = status.getRotacion();
			controladorDisparo.agregarDisparos(nave.getArma().disparar(posicion, rotacion));
		}
	}

	public void dibujar(SpriteBatch batch){
		nave.dibujar(batch, status.getPosicion());
	}

	public void eliminar(){
		// TODO Una posibilidad es indicarle al nivel que debe finalizar
	}

	public ColisionadorJugador getColisionador(){
		return colisionador;
	}

	public void aceptarColision(Colisionador col){
		col.colisionarConJugador(this);
	}

	private boolean posicionDentroDePantalla(Vector2 posicion){
		float radio = nave.getAncho()/2;
		return posicion.x - radio > 0 && posicion.x + radio < Gdx.graphics.getWidth();
	}
}
