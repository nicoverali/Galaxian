package edu.uns.galaxian.colision.colisionadores;

import java.util.HashSet;
import java.util.Set;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.BlackHole;
import edu.uns.galaxian.ia.Blackboard;
import edu.uns.galaxian.ia.tareas.acciones.ArrivePosicion;

public class ColisionadorBlackHole extends ColisionadorObstaculo {
	
	private Set<Enemigo>  absorbidos;

	public ColisionadorBlackHole(BlackHole obstaculo) {
		super(obstaculo);
		absorbidos = new HashSet<>();
	}
	
	public void visitEnemigo(Enemigo enemigo) {
		if(absorbidos.size()<4) {
			if(!absorbidos.contains(enemigo)) {
				enemigo.setTareaInteligencia(new ArrivePosicion<>(new Blackboard<>(enemigo),objetoFuente.getPosicion()));
				absorbidos.add(enemigo);
			}
		}
		else {
			objetoFuente.restarVida(objetoFuente.getVida().getValor());
		}
	}

}