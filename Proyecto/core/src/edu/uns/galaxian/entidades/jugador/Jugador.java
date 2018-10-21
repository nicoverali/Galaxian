package edu.uns.galaxian.entidades.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.*;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.input.*;
import edu.uns.galaxian.juego.Nivel;
import edu.uns.galaxian.nave.NaveJugador;


public class Jugador extends EntidadConNave<NaveJugador, DisparoJugador> {

	private ProcesadorInput input;
	private Nivel nivel;
	private ColisionadorJugador colisionador;
	private Controlador controlador;

	public Jugador(float xPos, float yPos, NaveJugador nave, Nivel nivel, Controlador controlador) {
		super(new Vector2(xPos, yPos), 90, nave, controlador.getTextureAtlas());
		this.nivel = nivel;
		this.controlador = controlador;
		colisionador = new ColisionadorJugador(this);
		input = new InputKeyboard();
	}

	public void disparar() {
		nave.getArma().disparar(posicion, rotacion, controlador);
	}

	public void actualizar(float delta){
		Vector2 nuevaPosicion = posicion.cpy().add(input.getXAxis() * nave.getVelocidadMax() * delta, 0);
		if(posicionDentroDePantalla(nuevaPosicion)){
			posicion = nuevaPosicion;
		}
 		if(input.sePresionoDisparar()){
			nave.getArma().disparar(posicion.cpy(), rotacion, controlador);
		}
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
		// TODO El radio antes era nave.getAncho()/2, ahora la nave no tiene ese metodo
		float radio = 30;
		return posicion.x - radio > 0 && posicion.x + radio < Gdx.graphics.getWidth();
	}
}
