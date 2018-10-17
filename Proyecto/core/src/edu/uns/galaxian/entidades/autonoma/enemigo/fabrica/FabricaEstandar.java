package edu.uns.galaxian.entidades.autonoma.enemigo.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.status.GameObject;
import edu.uns.galaxian.nave.enemigo.NaveKamikaze;

public class FabricaEstandar extends FabricaEnemigos {

	public Enemigo getKamikaze(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(60, 200, 20, jugador);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getKamikazeAleatorio(Vector2 posicion, Controlador controlador) {
		NaveKamikaze nave = new NaveKamikaze(80, 200, 20, null);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getKamikazeMixto(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(70, 200, 20, jugador);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getArmado(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(60, 200, 20, jugador);
		return new Enemigo(posicion, nave, controlador);
	}

	public Enemigo getArmadoDebil(Vector2 posicion, Controlador controlador, GameObject jugador) {
		NaveKamikaze nave = new NaveKamikaze(80, 200, 20, jugador);
		return new Enemigo(posicion, nave, controlador);
	}
}
