package edu.uns.galaxian.controladores;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;

public class ControladorObstaculo implements ControladorEntidad{

	private final ControladorObstaculo CONTROLADOR = this;
	
	private List<Obstaculo> obstaculos;
	private List<Obstaculo> listaEliminar;
	private DetectorColision detector;

	public ControladorObstaculo(DetectorColision detector) {
		this.detector = detector;
		obstaculos = new LinkedList<>();
		listaEliminar = new LinkedList<>();
		iniciarThreadDeCreacion();
	}

	public void actualizarEstado(float delta) {
		for(Obstaculo obstaculo : listaEliminar) {
			detector.eliminarEntidad(obstaculo);
			obstaculos.remove(obstaculo);
		}
		
		listaEliminar = new LinkedList<>();
		for(Obstaculo obstaculo : obstaculos) {
  			obstaculo.actualizar(delta);
  			detector.verificarYResolverColisiones(obstaculo);
		}
	}

	public void dibujar(SpriteBatch batch) {
		for(Obstaculo obstaculo : obstaculos) {
			obstaculo.dibujar(batch);
		}
	}

	public void deregistrar(Obstaculo obstaculo) {
		listaEliminar.add(obstaculo);
	}

	private void iniciarThreadDeCreacion(){
		new Thread(new Runnable() {
			public void run() {
				final Random ran = new Random();
				while(true){
					try {
						Thread.sleep(ran.nextInt(6000) + 2000);
						Gdx.app.postRunnable(new Runnable() {
							public void run() {
								int posX = ran.nextInt(Gdx.graphics.getWidth());
								int posY  = ran.nextInt(150) + Gdx.graphics.getHeight() / 3;
								Obstaculo nuevoObstaculo = new Obstaculo(posX,posY);
								nuevoObstaculo.setControladorObstaculo(CONTROLADOR);
								obstaculos.add(nuevoObstaculo);
								detector.registrarColisionable(nuevoObstaculo);
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
