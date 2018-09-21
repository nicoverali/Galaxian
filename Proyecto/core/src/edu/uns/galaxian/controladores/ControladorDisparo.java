package edu.uns.galaxian.controladores;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ControladorDisparo implements ControladorEntidad {

	private List<Disparo> disparos;
	private List<Disparo> listaEliminar;
	private DetectorColision detector;

	public ControladorDisparo() {
		disparos = new LinkedList<>();
		listaEliminar = new LinkedList<>();
	}

	public void actualizarEstado() {
		
		for(Disparo d : listaEliminar) {
			detector.eliminarEntidad(d);
		}
		
		listaEliminar = new LinkedList<Disparo>();
		
		for(Disparo d : disparos) {
			d.actualizar();
		}
	}

	public void agregarDisparo(Disparo disparo) {
		disparo.setControladorDisparo(this);
		disparos.add(disparo);
		detector.registrarColisionable(disparo);
	}

	public void dibujar(SpriteBatch batch) {
		for(Disparo d : disparos) {
			d.dibujar(batch);
		}
	}
	
	public void setDetectorColisiones(DetectorColision d) {
		detector = d;
	}
	
	public void deregistrar(Disparo disparo) {
		for(Disparo d : disparos) {
			if(d==disparo) {
				disparos.remove(d);
				break;
			}
		}
		listaEliminar.add(disparo);
	}
	
}