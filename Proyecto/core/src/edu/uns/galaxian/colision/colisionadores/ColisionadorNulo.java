package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.ObstaculoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public abstract class ColisionadorNulo<T> implements Colisionador<T>{

	public void colisionarConJugador(Jugador jugador) {}

	public void colisionarConEnemigo(Enemigo enemigo) {}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {}

	public void colisionarConObstaculo(Obstaculo obstaculo) {}

	public void colisionarConPowerUp(PowerUp powerUp) {}

	public void colisionarConEscudo(Escudo escudo) {}

	public void colisionarConBarricada(ObstaculoEnemigo obstaculoEnemigo) {}

}
