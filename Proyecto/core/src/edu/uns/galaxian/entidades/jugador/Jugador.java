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
import edu.uns.galaxian.juego.Nivel;
import edu.uns.galaxian.nave.jugador.NaveJugador;

public class Jugador extends EntidadViva {

	private NaveJugador nave;
	private ProcesadorInput input;
	private Nivel nivel;
	private ControladorDisparo controladorDisparo;
	private ColisionadorJugador colisionador;

	// Constructores	
	public Jugador(float xPos, float yPos, NaveJugador nave, Nivel nivel, ControladorDisparo controladorDisparo) {
		super(new Vector2(xPos, yPos), nave.getRotacionInicial(), nave.getVidaMax());
		this.nave = nave;
		this.nivel = nivel;
		this.controladorDisparo = controladorDisparo;

		colisionador = new ColisionadorJugador(this);
		input = new InputKeyboard();
	}

	/**
	 * Setea el arma del jugador con la nueva pasada como parametro.
	 * @param nuevaArma Nueva arma que tendra el jugador.
	 */
	public void setArma (Arma<DisparoJugador> nuevaArma) {
		nave.setArma(nuevaArma);
	}
	
	/**
	 * Devuelve el arma que el jugador posee actualmente.
	 * @return Arma que posee el jugador.
	 */
	public Arma<DisparoJugador> getArma() {
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

	public float getAlto(){
		return nave.getAlto();
	}
	
	public float getAncho(){
		return nave.getAncho();
	}

	public void setVidaAlMaximo(){
		vida.setValor(nave.getVidaMax());
	}


	public void actualizar(float delta){
		Vector2 nuevaPosicion = posicion.cpy().add(input.getXAxis() * nave.getVelocidadMax() * delta, 0);
		if(posicionDentroDePantalla(nuevaPosicion)){
			posicion = nuevaPosicion;
		}
 		if(input.sePresionoDisparar()){
			controladorDisparo.agregarDisparos(nave.getArma().disparar(posicion.cpy(), rotacion));
		}
 	}

	public void dibujar(SpriteBatch batch){
		nave.dibujar(batch, posicion);
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
