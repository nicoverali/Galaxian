package edu.uns.galaxian.controladores;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.colision.DetectorDeColisiones;
import edu.uns.galaxian.entidades.autonoma.Enemigo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ControladorDisparo implements ControladorEntidad {

	private List<Disparo> disparos;
	private List<Disparo> listaEliminar;
	private DetectorDeColisiones detector;

	public ControladorDisparo() {
		disparos = new LinkedList<>();
		listaEliminar = new LinkedList<>();
	}

	public void actualizarEstado() {
		
		for(Disparo d : listaEliminar) {
			detector.eliminarEntidad(d);
		}
		
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

	public void setDetectorColisiones(DetectorDeColisiones detector) {
		this.detector = detector;
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