package edu.uns.galaxian.oleada;

import java.util.ArrayList;
import java.util.List;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEstandar;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.juego.nivel.Nivel;

public class OleadaKamikazes implements Oleada {
	
	private Oleada oleada;
	
	public OleadaKamikazes(Controlador controlador, Nivel nivel, Jugador jugador) {
		List<List<Enemigo>> enemigos = new ArrayList<>();
		FabricaEnemigos fabrica = new FabricaEstandar();
		int CANT_MAXIMA_FILA = 5;
		List<Enemigo> fila1 = new ArrayList<Enemigo>();
		List<Enemigo> fila2 = new ArrayList<Enemigo>();
		List<Enemigo> fila3 = new ArrayList<Enemigo>();
		enemigos.add(fila1);
		enemigos.add(fila2);
		enemigos.add(fila3);
		for(int i=0; i<3; i++) {
			for(int j=0; j<CANT_MAXIMA_FILA; j++) {
				enemigos.get(i).add(fabrica.getKamikaze(null, controlador, jugador));
			}
		}
		oleada = new OleadaBonus(enemigos, controlador, nivel);
	}

	public void iniciar() throws IllegalStateException {
		oleada.iniciar();
	}

	public void actualizar(float delta) throws IllegalStateException {
		oleada.actualizar(delta);
	}

	public void finalizar() throws IllegalStateException {
		oleada.finalizar();
	}

}