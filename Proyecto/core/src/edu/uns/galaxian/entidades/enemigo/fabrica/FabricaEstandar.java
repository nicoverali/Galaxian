package edu.uns.galaxian.entidades.enemigo.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.powerups.fabricaPowerUp.FabricaPowerUp;
import edu.uns.galaxian.entidades.inanimadas.powerups.fabricaPowerUp.FabricaPowerUpConvencional;
import edu.uns.galaxian.nave.NaveEnemigo;
import edu.uns.galaxian.nave.enemigo.*;
import edu.uns.galaxian.juego.GameObject;

public class FabricaEstandar extends FabricaEnemigos {
	
	private FabricaPowerUp fabricaPowerUp;
	
	/**
	 * La fabrica de enemigos estandar crea enemigos que tiene la posibilidad de generar powerUps convencionales.
	 */
	public FabricaEstandar() {
		fabricaPowerUp = new FabricaPowerUpConvencional();
	}

	public Enemigo getKamikaze(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveKamikaze(150, 400,15, 30);
		return new Enemigo(posicion, nave, controlador, fabricaPowerUp);
	}

	public Enemigo getKamikazeAleatorio(Vector2 posicion, Controlador controlador) {
		NaveEnemigo nave = new NaveKamikazeAleatorio(150, 300,5, 60);
		return new Enemigo(posicion, nave, controlador, fabricaPowerUp);
	}

	public Enemigo getKamikazeMixto(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveKamikazeMixto(150, 350,15, 60);
		return new Enemigo(posicion, nave, controlador, fabricaPowerUp);
	}

	public Enemigo getArmado(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave =  new NaveArmado(150, 200,20, 90);
		return new Enemigo(posicion, nave, controlador, fabricaPowerUp);
	}

	public Enemigo getArmadoDebil(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveArmadoDebil(150, 200,10, 90);
		return new Enemigo(posicion, nave, controlador, fabricaPowerUp);
	}
}
