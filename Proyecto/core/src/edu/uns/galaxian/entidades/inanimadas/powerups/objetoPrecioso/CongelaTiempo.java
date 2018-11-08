package edu.uns.galaxian.entidades.inanimadas.powerups.objetoPrecioso;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.actualizadores.VisitorJuegoCongelado;
import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class CongelaTiempo extends PowerUp {

	public CongelaTiempo(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura = controlador.getTextureAtlas().findRegion("powerup/congelaTiempo");
		box = new HBRectangulo(this,textura.getRegionHeight(),textura.getRegionWidth());
	}

	public void efectoJugador(Jugador jugador) {
		final Controlador ctrl = controlador;
		new Thread(new Runnable() {
			public void run() {
				Visitor congelador = new VisitorJuegoCongelado(Gdx.graphics.getDeltaTime());
				ctrl.setActualizacion(congelador);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) { 
					System.out.println("Error en ejecucion de Thread de powerUp");
					e.printStackTrace();
				}
				ctrl.restaurar();
			}
		}).start();
	}

}