package edu.uns.galaxian.colision.identificadores;

import java.util.List;

import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

public class IdentificarObstaculos extends Identificador {

	public IdentificarObstaculos(List<Entidad> ent) {
		super(ent);
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		resultado.add(obstaculo);
	}
	
	public void visitBarricada(Barricada obstaculoEnemigo) {
		resultado.add(obstaculoEnemigo);
	}
	
}