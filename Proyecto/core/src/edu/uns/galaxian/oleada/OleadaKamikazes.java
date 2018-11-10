package edu.uns.galaxian.oleada;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.juego.nivel.Nivel;

public class OleadaKamikazes extends OleadaBonus {

	public OleadaKamikazes(int cantKamikazes, FabricaEnemigos fabrica, Controlador controlador, Nivel nivel) {
		super(new ArrayList<Enemigo>(), controlador, nivel);
		for(int i = 0; i < cantKamikazes; i++) {
			Enemigo nuevoEnemigo = fabrica.getKamikaze(Vector2.Zero.cpy(), controlador, controlador.getJugador());
			enemigos.add(nuevoEnemigo);
		}
		registrarEnemigos(enemigos);
	}
}