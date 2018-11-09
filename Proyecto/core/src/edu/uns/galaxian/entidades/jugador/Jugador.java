package edu.uns.galaxian.entidades.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.*;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.entidades.jugador.input.*;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.juego.nivel.Nivel;
import edu.uns.galaxian.nave.NaveJugador;


public class Jugador extends EntidadConNave<NaveJugador, DisparoJugador> {

	private ProcesadorInput input;
	private Nivel nivel;
	private ColisionadorJugador colisionador;
	private Controlador controlador;
	private int puntaje;
	

	public Jugador(Vector2 posicion, NaveJugador nave, Nivel nivel, Controlador controlador) {
		super(posicion, 90, nave, controlador.getTextureAtlas(Juego.ATLAS_NAVES));
		this.nivel = nivel;
		this.controlador = controlador;
		colisionador = new ColisionadorJugador(this);
		input = new InputKeyboard();
		nave.setArma(new ArmaComun<>(new FabricaDisparoJugador(this)));
	}

	/**
	 * Suma al puntaje actual del jugador, parte del bonus
	 * recibido. La suma total dependera del tiempo actual del nivel
	 * @param bonus Bonus que recibe el jugador
	 */
	public void sumarPuntaje(int bonus) {
		puntaje += (Math.pow(Math.E,-(nivel.getTiempoActual()-0.7))+1)*bonus;
	}

	/**
	 * Retorna el puntaje actual de jugador
	 * @return Puntaje del jugador
	 */
	public int getPuntaje() {
		return puntaje;
	}

	public void disparar() {
		nave.getArma().disparar(posicion, rotacion, controlador);
	}

	public void actualizar(float delta){
		this.setVelocidad(Vector2.X.cpy().scl(input.getXAxis() * nave.getVelocidadMax()));
		Vector2 nuevaPosicion = posicion.cpy().add(getVelocidad().scl(delta));
		if(posicionDentroDePantalla(nuevaPosicion)){
			posicion = nuevaPosicion;
		}
 		if(input.sePresionoDisparar()){
			nave.getArma().disparar(posicion.cpy(), rotacion, controlador);
		}
 	}

	public void eliminar(){
		nivel.perderNivel();
	}

	public ColisionadorJugador getColisionador(){
		return colisionador;
	}

	public void aceptarVisitor(Visitor col){
		col.visitJugador(this);
	}

	private boolean posicionDentroDePantalla(Vector2 posicion){
		float radio = textura.getRegionWidth()/2;
		return posicion.x - radio > 0 && posicion.x + radio < Gdx.graphics.getWidth();
	}
}
