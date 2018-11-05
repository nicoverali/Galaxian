package edu.uns.galaxian.colision.identificadores;

import java.util.List;

import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.enemigo.Enemigo;

public class IdentificarEnemigos extends Identificador {

	public IdentificarEnemigos(List<Entidad> ent) {
		super(ent);
	}
	
	public void colisionarConEnemigo(Enemigo enemigo) {
		resultado.add(enemigo);
	}

}
