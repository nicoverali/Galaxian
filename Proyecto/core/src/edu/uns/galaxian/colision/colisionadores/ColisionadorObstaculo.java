package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.ObstaculoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorObstaculo implements Colisionador<Obstaculo> {
	
	private Obstaculo objetoFuente;
	
	public ColisionadorObstaculo(Obstaculo obstaculo) {
		objetoFuente = obstaculo;
	}

	public void colisionarConJugador(Jugador jugador) {
		// El obstaculo no se encarga de quitarle vida al jugador.
	}

	public void colisionarConEnemigo(Enemigo enemigo) {
		objetoFuente.restarVida(enemigo.getFuerzaDeColision());
	}

	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}

	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		objetoFuente.restarVida(disparo.getFuerzaDeDisparo());
	}

	public void colisionarConObstaculo(Obstaculo obstaculo) {
		objetoFuente.restarVida(obstaculo.getFuerzaDeColision());
	}

	public void colisionarConPowerUp(PowerUp powerUp) {
		// Un obstaculo no afecta a un powerUp.
	}

	@Override
	public void colisionarEscudo(Escudo escudo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionarObstaculoEnemigo(ObstaculoEnemigo obstaculoEnemigo) {
		objetoFuente.restarVida(obstaculoEnemigo.getFuerzaDeColision());		
	}

}
