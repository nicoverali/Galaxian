package edu.uns.galaxian.controlador;

import edu.uns.galaxian.controlador.actualizadores.VisitorJuegoNormal;
import edu.uns.galaxian.colision.colisionadores.Visitor;

public class Vigilante {
	
	private Memento mementoPorDefecto;
	private Memento ultimoMemento;
	
	public Vigilante() {
		this.mementoPorDefecto = new Memento(new VisitorJuegoNormal());
	}
	
	public Memento getUltimoMemento() {
		Memento ultimo;
		if(ultimoMemento==null) {
			ultimo = mementoPorDefecto;
		}
		else {
			ultimo = ultimoMemento;
		}
		return ultimo;
	}
	
	public void guardarMemento(Memento memento) {
		ultimoMemento = memento;
	}

	public Visitor getVisitorRestaurado() {
		return mementoPorDefecto.getVisitor();
	}
	
}