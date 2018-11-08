package edu.uns.galaxian.controlador;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;

import edu.uns.galaxian.colision.actualizadores.VisitorJuegoNormal;

public class Vigilante {
	
	private List<Memento> memoria;
	private Memento mementoPorDefecto;
	
	public Vigilante() {
		memoria = new LinkedList<Memento>();
		mementoPorDefecto = new Memento(new VisitorJuegoNormal());
	}
	
	public Memento getUltimoMemento() {
		Memento ultimo;
		if(!memoria.isEmpty()) {
			ultimo = memoria.remove(memoria.size()-1);
		}
		else {
			ultimo = mementoPorDefecto;
		}
		return ultimo;
	}
	
	public void guardarMemento(Memento memento) {
		memoria.add(memento);
	}
	
}