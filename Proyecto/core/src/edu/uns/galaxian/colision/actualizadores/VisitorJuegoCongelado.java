package edu.uns.galaxian.colision.actualizadores;

import edu.uns.galaxian.colision.colisionadores.VisitorAdapter;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class VisitorJuegoCongelado extends VisitorAdapter {
	
	private float delta;
	
	public VisitorJuegoCongelado(float delta) {
		this.delta = delta;
	}
	
	public void visitJugador(Jugador jugador) {
		jugador.actualizar(delta);
	}
	
	public void visitDisparoJugador(DisparoJugador disparo) {
		disparo.actualizar(delta);
	}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {
		disparo.actualizar(delta);
	}
	
	public void visitPowerUp(PowerUp powerUp) {
		powerUp.actualizar(delta);
	}
	
	public void visitEscudo(Escudo escudo) {
		escudo.actualizar(delta);
	}

}