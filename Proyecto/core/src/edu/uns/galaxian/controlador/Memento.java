package edu.uns.galaxian.controlador;

import edu.uns.galaxian.colision.colisionadores.Visitor;

public class Memento {

	protected Visitor visitorGuardado;
	protected Caller caller;
	
	public Memento(Visitor visitor, Caller caller) {
		visitorGuardado = visitor;
		this.caller = caller;
	}
	
	public Memento(Visitor visitor) {
		visitorGuardado = visitor;
	}
	
	public Memento(Caller caller) {
		this.caller = caller;
	}
	
	public Visitor getVisitor() {
		return visitorGuardado;
	}
	
	public Caller getCaller() {
		return caller;
	}
	
}