package edu.uns.galaxian.servicios;

import java.util.Random;

import com.badlogic.gdx.Gdx;

import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;

public class GeneracionObstaculo implements Servicio, Observador<LiveData<Integer>> {
	
	private Controlador controlador;
	private GeneracionObstaculo generador = this;
    private volatile boolean activado;
    private int cantObstaculos;
    private static final int CANT_MAXIMA_OBSTACULOS = 8;
    
    public GeneracionObstaculo(Controlador controlador){
        this.controlador = controlador;
        activado = false;
        cantObstaculos = 0;
    }

    public void activar() throws IllegalStateException {
        if(activado) throw new IllegalStateException("El servicio no puede activarse si ya esta activo.");
        activado = true;
        new Thread(new RunnableGeneracion()).start();
    }

    public void desactivar() throws IllegalStateException{
        if(!activado) throw new IllegalStateException("El servicio no puede desactivarse si no esta activo.");
        activado = false;
    }
    
    private class RunnableGeneracion implements Runnable {
        public void run(){
            while( activado && (cantObstaculos<=CANT_MAXIMA_OBSTACULOS) ){
            	final Random ran = new Random();
				try {
					Thread.sleep(ran.nextInt(6000) + 2000);
					Gdx.app.postRunnable(new Runnable() {
						public void run() {
							int posX = ran.nextInt(Gdx.graphics.getWidth());
							int posY  = ran.nextInt(150) + Gdx.graphics.getHeight() / 3;
							Obstaculo nuevoObstaculo = new Obstaculo(posX,posY);
							nuevoObstaculo.getVida().observar(generador);
							nuevoObstaculo.setControladorObstaculo(controlador);
							controlador.agregarEntidad(nuevoObstaculo);
							cantObstaculos++;
						}
					});
				} catch (InterruptedException e) { 
						System.out.println("Error en ejecucion de Thread de GeneracionObstaculo");
						e.printStackTrace(); }
            }
        }
    }

	public void notificar(LiveData<Integer> subject) {
		if(subject.getValor()==0) {
			cantObstaculos--;
		}
	}

}
