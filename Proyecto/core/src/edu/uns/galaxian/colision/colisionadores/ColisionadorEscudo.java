package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.ObstaculoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class ColisionadorEscudo implements Colisionador<Escudo> {

	private Escudo objetoFuente;
	
	public ColisionadorEscudo(Escudo escudo){
		objetoFuente=escudo;
	}

	@Override
	public void colisionarConJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionarConEnemigo(Enemigo enemigo) {
		enemigo.eliminar();
		objetoFuente.eliminar();
	}

	@Override
	public void colisionarConDisparoJugador(DisparoJugador disparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionarConDisparoEnemigo(DisparoEnemigo disparo) {
		disparo.eliminar();
	}

	@Override
	public void colisionarConObstaculo(Obstaculo obstaculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionarConPowerUp(PowerUp powerUp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionarEscudo(Escudo escudo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionarObstaculoEnemigo(ObstaculoEnemigo obstaculoEnemigo) {
		// TODO Auto-generated method stub
		
	}
}
