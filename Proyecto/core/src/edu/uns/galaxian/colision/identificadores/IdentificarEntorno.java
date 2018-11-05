package edu.uns.galaxian.colision.identificadores;

import java.util.List;

import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.juego.GameObject;

public class IdentificarEntorno extends Identificador {
	
	private GameObject objetoFuente;
	private HitBox boxEntorno;

	public IdentificarEntorno(List<Entidad> ent, GameObject gameObject) {
		super(ent);
		objetoFuente = gameObject;
		boxEntorno = new HBRectangulo(objetoFuente,35,35);
	}
	
	public List<Entidad> realizarBusqueda() {
		for(Entidad ent : entidades) {
			if(boxEntorno.verificarInterseccion(ent.getHitBox())) {
			   ent.aceptarColision(this);
			}
		}
		return resultado;
	}
	
	public void colisionarConJugador(Jugador jugador) {
		resultado.add(jugador);
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		resultado.add(enemigo);
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		resultado.add(disparo);
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		resultado.add(disparo);
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		resultado.add(obstaculo);
	}

	public void colisionarConBarricada(Barricada obstaculoEnemigo) {
		resultado.add(obstaculoEnemigo);
	}

}
