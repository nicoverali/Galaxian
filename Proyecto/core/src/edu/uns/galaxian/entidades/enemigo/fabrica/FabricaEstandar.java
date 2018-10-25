package edu.uns.galaxian.entidades.enemigo.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.nave.NaveEnemigo;
import edu.uns.galaxian.nave.enemigo.*;
import edu.uns.galaxian.juego.GameObject;

public class FabricaEstandar extends FabricaEnemigos {

	public Enemigo getKamikaze(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveKamikaze(150, 400,15, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getKamikazeAleatorio(Vector2 posicion, Controlador controlador) {
		NaveEnemigo nave = new NaveKamikazeAleatorio(150, 300,5, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getKamikazeMixto(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveKamikazeMixto(150, 350,15, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getArmado(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave =  new NaveArmado(150, 200,20, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getArmadoDebil(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveArmadoDebil(150, 200,10, 100);
		return new Enemigo(posicion, nave, controlador);
	}
}
