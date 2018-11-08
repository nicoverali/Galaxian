package edu.uns.galaxian.controlador;

import edu.uns.galaxian.colision.colisionadores.Visitor;

public class Memento {

	protected Visitor visitorGuardado;
	
	public Memento(Visitor visitor) {
		visitorGuardado = visitor;
	}
	
	public Visitor getState() {
		return visitorGuardado;
	}
	
}
