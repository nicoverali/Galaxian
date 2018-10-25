package edu.uns.galaxian.entidades.equipamiento.escudos;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEscudo;
import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.util.EntidadBatch;

public class Escudo extends Entidad {

	private Jugador jugador;
	private ColisionadorEscudo colisionador;
	private Controlador controlador;
	private HBCirculo hitbox;
	
	public Escudo(Jugador jugador, Controlador controlador){
		super(jugador.getPosicion(),jugador.getVelocidad(),jugador.getRotacion());
		this.jugador=jugador;		
		this.controlador=controlador;
		colisionador= new ColisionadorEscudo(this);
		hitbox = new HBCirculo(this,50);
	}
	
	public HitBox getHitBox() {
		return hitbox;
	}

	public Colisionador getColisionador() {
		return colisionador;
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConEscudo(this);
	}

	public void dibujar(EntidadBatch batch) {
	}

	public void actualizar(float delta) {
		posicion = jugador.getPosicion();		
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
	}

}
