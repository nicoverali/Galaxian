package edu.uns.galaxian.servicios;

import java.util.Random;

import com.badlogic.gdx.Gdx;

import edu.uns.galaxian.entidades.inanimadas.obstaculos.Asteroide;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Barricada;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.ia.inteligencias.basica.InteligenciaDeOnda;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;

public class GeneracionObstaculo implements Servicio, Observador<LiveData<Integer>> {
	
	private Controlador controlador;
	private GeneracionObstaculo generador = this;
    private volatile boolean activado;
    private volatile int cantObstaculos;
    private static final int CANT_MAXIMA_OBSTACULOS = 8;
    
    public GeneracionObstaculo(Controlador controlador){
        this.controlador = controlador;
        activado = false;
        cantObstaculos = 0;
        generarBarricadas();
    }
    
    private void generarBarricadas() {
    	Random random = new Random();
    	int ancho = Gdx.graphics.getWidth();
    	int alto = Gdx.graphics.getHeight();
    	
    	//Primer bloque de barricada
    	float posX = random.nextInt(ancho/4) + (ancho/4);
    	float posY = random.nextInt(alto/4)  + (alto/3);
    	armarBloque(posX,posY);
    	
    	//Segundo bloque de barricada
    	int posX2 = random.nextInt(ancho/4) + (ancho/2);
    	int posY2 = random.nextInt(alto/4)  + (alto/3);
    	armarBloque(posX2,posY2);
    	
    }
    
    private void armarBloque(float posX, float posY) {
    	Barricada referente = new Barricada(posX,posY,controlador);
    	Barricada hijoIzq = new Barricada(posX-30,posY-30,controlador);
    	Barricada hijoDer = new Barricada(posX+30,posY-30,controlador);
    	Barricada hermanoIzq = new Barricada(posX-50,posY,controlador);
    	Barricada hermanoDer = new Barricada(posX+50,posY,controlador);
    	controlador.agregarEntidad(referente);
    	controlador.agregarEntidad(hijoIzq);
    	controlador.agregarEntidad(hijoDer);
    	controlador.agregarEntidad(hermanoIzq);
    	controlador.agregarEntidad(hermanoDer);
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
            while( activado ){
            	if(cantObstaculos<CANT_MAXIMA_OBSTACULOS) {
	            	final Random ran = new Random();
					Gdx.app.postRunnable(new Runnable() {
						public void run() {
							// Probabilidad de que aparezca un asteroide = 5/10
							if(ran.nextInt(10)<4) {
								int posX = ran.nextInt(Gdx.graphics.getWidth());
								int posY  = ran.nextInt(120) + Gdx.graphics.getHeight() / 3;
								Obstaculo nuevoObstaculo = new 	Asteroide(posX,posY, controlador);
								nuevoObstaculo.getVida().observar(generador);
								nuevoObstaculo.setPosicion(0,posY-15);
								nuevoObstaculo.setInteligencia(new InteligenciaDeOnda<Obstaculo>(nuevoObstaculo));
								controlador.agregarEntidad(nuevoObstaculo);
								cantObstaculos++;
							}
						}
					});
					try {  Thread.sleep(ran.nextInt(6000) + 2000); }
					catch (InterruptedException e) { 
							System.out.println("Error en ejecucion de Thread de GeneracionObstaculo");
							e.printStackTrace(); }
            	}
            }
        }
    }

	public void notificar(LiveData<Integer> subject) {
		if(subject.getValor()==0) {
			cantObstaculos--;
		}
	}

}
