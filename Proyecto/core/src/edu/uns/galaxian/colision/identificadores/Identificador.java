package edu.uns.galaxian.colision.identificadores;

import java.util.LinkedList;
import java.util.List;

import edu.uns.galaxian.colision.colisionadores.ColisionadorAdapter;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public abstract class Identificador extends ColisionadorAdapter {
	
	protected List<Entidad> entidades;
	protected List<Entidad> resultado;
	
	public Identificador(List<Entidad> ent) {
		entidades = ent;
		resultado = new LinkedList<Entidad>();
	}
	
	public List<Entidad> realizarBusqueda() {
		for(Entidad ent : entidades) {
			ent.aceptarColision(this);
		}
		return resultado;
	}

	public void visitJugador(Jugador jugador) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

	public void visitEnemigo(Enemigo enemigo) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

	public void visitDisparoJugador(DisparoJugador disparo) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

	public void visitPowerUp(PowerUp powerUp) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

	public void visitEscudo(Escudo escudo) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

	public void visitBarricada(Barricada obstaculoEnemigo) {
		// El Identificador redefinirá solo los métodos que necesite.
	}

}
