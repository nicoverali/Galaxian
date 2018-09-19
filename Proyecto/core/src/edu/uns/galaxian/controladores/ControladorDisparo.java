package edu.uns.galaxian.controladores;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.colision.DetectorDeColisiones;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ControladorDisparo implements ControladorEntidad {
    
private List<Disparo> disparos;
private DetectorDeColisiones detector;
	
	public ControladorDisparo() {
		disparos = new LinkedList<Disparo>();
	}
	
	public void actualizarEstado() {
		for(Disparo d : disparos) {
			d.actualizar();
		}
	}
	
	public void agregarDisparo(Disparo d) {
		disparos.add(d);
		detector.registrarEntidadColisionable(d);
	}

	public void dibujar(SpriteBatch batch) {
		for(Disparo d : disparos) {
			d.dibujar(batch);
		}
	}

	public void setDetectorColisiones(DetectorDeColisiones detector) {
		this.detector = detector;
	}
	
}
