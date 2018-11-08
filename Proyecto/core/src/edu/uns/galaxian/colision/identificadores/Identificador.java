package edu.uns.galaxian.colision.identificadores;

import java.util.LinkedList;
import java.util.List;

import edu.uns.galaxian.colision.colisionadores.VisitorAdapter;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public abstract class Identificador extends VisitorAdapter {
	
	protected List<Entidad> entidades;
	protected List<Entidad> resultado;
	
	public Identificador(List<Entidad> ent) {
		entidades = ent;
		resultado = new LinkedList<Entidad>();
	}
	
	public List<Entidad> realizarBusqueda() {
		for(Entidad ent : entidades) {
			ent.aceptarVisitor(this);
		}
		return resultado;
	}

	public void colisionarConJugador(Jugador jugador) {
		// El Identificador redefinira solo los metodos que necesite.
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		// El Identificador redefinira solo los metodos que necesite.
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// El Identificador redefinira solo los metodos que necesite.
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		// El Identificador redefinira solo los metodos que necesite.
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		// El Identificador redefinira solo los metodos que necesite.
	}

	public void colisionarConPowerUp(PowerUp powerUp) {
		// El Identificador redefinira solo los metodos que necesite.
	}

	public void colisionarConEscudo(Escudo escudo) {
		// El Identificador redefinira solo los metodos que necesite.
	}

	public void colisionarConBarricada(Barricada obstaculoEnemigo) {
		// El Identificador redefinira solo los metodos que necesite.
	}

}
