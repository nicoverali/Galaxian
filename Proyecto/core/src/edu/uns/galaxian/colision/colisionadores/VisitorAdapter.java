package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public abstract class VisitorAdapter implements Visitor {

	public void visitJugador(Jugador jugador) {}

	public void visitEnemigo(Enemigo enemigo) {}

	public void visitDisparoJugador(DisparoJugador disparo) {}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {}

	public void visitObstaculo(Obstaculo obstaculo) {}

	public void visitPowerUp(PowerUp powerUp) {}

	public void visitEscudo(Escudo escudo) {}

	public void visitBarricada(Barricada barricada) {}

}