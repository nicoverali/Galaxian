package edu.uns.galaxian.entidades.autonoma.enemigo.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.nave.NaveEnemigo;
import edu.uns.galaxian.nave.enemigo.*;
import edu.uns.galaxian.entidades.status.GameObject;

public class FabricaEstandar extends FabricaEnemigos {

	public Enemigo getKamikaze(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveKamikaze(150, 400,15, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getKamikazeAleatorio(Vector2 posicion, Controlador controlador) {
		NaveEnemigo nave = new NaveKamikazeAleatorio(150, 300,90, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getKamikazeMixto(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveKamikazeMixto(150, 200,90, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getArmado(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave =  new NaveArmado(150, 200,90, 100);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getArmadoDebil(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveEnemigo nave = new NaveArmadoDebil(150, 200,90, 100);
		return new Enemigo(posicion, nave, controlador);
	}
}
