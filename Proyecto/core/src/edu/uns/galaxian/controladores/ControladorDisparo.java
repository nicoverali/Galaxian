package edu.uns.galaxian.controladores;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

public class ControladorDisparo implements ControladorEntidad {

	private List<Disparo> disparos;
	private List<Disparo> listaEliminar;
	private DetectorColision detector;

	public ControladorDisparo(DetectorColision detector) {
		this.detector = detector;
		disparos = new LinkedList<>();
		listaEliminar = new LinkedList<>();
	}

	public void actualizarEstado(float delta) {
		for(Disparo d : listaEliminar) {
			detector.eliminarEntidad(d);
		}
		
		listaEliminar = new LinkedList<>();
		
		for(Disparo d : disparos) {
  			d.actualizar(delta);
		}
	}

	public void agregarDisparo(Disparo disparo) {
		disparo.setControladorDisparo(this);
		disparos.add(disparo);
		detector.registrarColisionable(disparo);
	}

	public void agregarDisparos(Collection<Disparo> disparos){
		for(Disparo disparo : disparos){
			disparo.setControladorDisparo(this);
			this.disparos.add(disparo);
			detector.registrarColisionable(disparo);
		}
	}

	public void dibujar(SpriteBatch batch) {
		for(Disparo d : disparos) {
			d.dibujar(batch);
		}
	}

	public void deregistrar(Disparo disparo) {
		listaEliminar.add(disparo);
	}
	
}