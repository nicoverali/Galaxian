package edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class MejoraArma extends PowerUp{

	public MejoraArma(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura = controlador.getTextureAtlas().findRegion("powerup/mejoraArma");
		box = new HBCirculo(this,textura.getRegionWidth()/2);
	}

	public void efectoJugador(Jugador jugador) {
		final Jugador player = jugador;
		final Arma<DisparoJugador> anterior = jugador.getArma();
		new Thread(new Runnable() {
			public void run() {
				player.setArma(new ArmaDisparoDoble<>(new FabricaDisparoJugador(player)));
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) { 
					System.out.println("Error en ejecucion de Thread de powerUp");
					e.printStackTrace();
				}
				player.setArma(anterior);
			}
		}).start();
	}

}