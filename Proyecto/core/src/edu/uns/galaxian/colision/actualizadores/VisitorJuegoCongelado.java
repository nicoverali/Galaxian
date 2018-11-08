package edu.uns.galaxian.colision.actualizadores;

import com.badlogic.gdx.Gdx;
import edu.uns.galaxian.colision.colisionadores.VisitorAdapter;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class VisitorJuegoCongelado extends VisitorAdapter {
	
	public void visitJugador(Jugador jugador) {
		jugador.actualizar(Gdx.graphics.getDeltaTime());
	}
	
	public void visitDisparoJugador(DisparoJugador disparo) {
		disparo.actualizar(Gdx.graphics.getDeltaTime());
	}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {
		disparo.actualizar(Gdx.graphics.getDeltaTime());
	}
	
	public void visitPowerUp(PowerUp powerUp) {
		powerUp.actualizar(Gdx.graphics.getDeltaTime());
	}
	
	public void visitEscudo(Escudo escudo) {
		escudo.actualizar(Gdx.graphics.getDeltaTime());
	}

}