package edu.uns.galaxian.entidades.equipamiento.escudos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.Colisionable;
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
	
	public Escudo(Jugador jugador, Controlador controlador){
		super(jugador.getPosicion(),jugador.getVelocidad(),jugador.getRotacion());
		this.jugador=jugador;		
		this.controlador=controlador;
		colisionador= new ColisionadorEscudo(this);
	}
	
	public HitBox getHitBox() {
		return new HBCirculo(this,40);
	}

	public Colisionador getColisionador() {
		return colisionador;
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarEscudo(this);
	}

	@Override
	public void dibujar(EntidadBatch batch) {
	}

	@Override
	public void actualizar(float delta) {
		this.posicion=jugador.getPosicion();		
	}

	@Override
	public void eliminar() {
		controlador.eliminarEntidad(this);
	}

}
