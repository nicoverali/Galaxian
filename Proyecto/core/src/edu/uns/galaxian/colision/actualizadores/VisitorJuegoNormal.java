package edu.uns.galaxian.colision.actualizadores;

import edu.uns.galaxian.colision.colisionadores.VisitorAdapter;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class VisitorJuegoNormal extends VisitorAdapter {
	
	private float delta;
	
	public VisitorJuegoNormal(float delta) {
		this.delta = delta;
	}
	
	public void visitJugador(Jugador jugador) {
		jugador.actualizar(delta);
	}

	public void visitEnemigo(Enemigo enemigo) {
		enemigo.actualizar(delta);
	}

	public void visitDisparoJugador(DisparoJugador disparo) {
		disparo.actualizar(delta);
	}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {
		disparo.actualizar(delta);
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		obstaculo.actualizar(delta);
	}

	public void visitPowerUp(PowerUp powerUp) {
		powerUp.actualizar(delta);
	}

	public void visitEscudo(Escudo escudo) {
		escudo.actualizar(delta);
	}

	public void visitBarricada(Barricada barricada) {
		barricada.actualizar(delta);
	}
	
}