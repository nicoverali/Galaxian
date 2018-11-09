package edu.uns.galaxian.controlador;

import edu.uns.galaxian.colision.actualizadores.VisitorJuegoNormal;

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
	
}