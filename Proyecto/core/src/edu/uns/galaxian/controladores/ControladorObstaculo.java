package edu.uns.galaxian.controladores;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.entidades.inanimadas.Obstaculo;

public class ControladorObstaculo implements ControladorEntidad{
	
	private List<Obstaculo> obstaculos;
	private List<Obstaculo> listaEliminar;
	private DetectorColision detector;
	
	private static final long CADENCIA = 1900;
    private long ultimaCreacion;
	
	public ControladorObstaculo(DetectorColision detector) {
		this.detector = detector;
		obstaculos = new LinkedList<Obstaculo>();
		listaEliminar = new LinkedList<Obstaculo>();
		ultimaCreacion = System.currentTimeMillis();
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
		
		crearObstaculos();
	}
	
	private void crearObstaculos() {
		if(TimeUtils.timeSinceMillis(ultimaCreacion) > CADENCIA) {
			Random random = new Random();
			int max = random.nextInt(2);
			for(int i=0; i<max; i++) {
	            int alto = Gdx.graphics.getHeight()/4;
	            int ancho = Gdx.graphics.getWidth();
	            int posX = random.nextInt(ancho);
	            int posY  = random.nextInt(alto) + alto + 60;
	            Obstaculo nuevoObstaculo = new Obstaculo(posX,posY);
	            nuevoObstaculo.setControladorObstaculo(this);
	            obstaculos.add(nuevoObstaculo);
	            detector.registrarColisionable(nuevoObstaculo);
			}
			ultimaCreacion = TimeUtils.millis();
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

	/*public void run() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) { e.printStackTrace(); }
		Random random = new Random();
		int max = random.nextInt(10);
		for(int i=0; i<max; i++) {
			 Gdx.app.postRunnable(new Runnable() {
                 public void run() {
                	 Random random = new Random();
                	 int altoPantalla = Gdx.graphics.getHeight()/4;
                	 int anchoPantalla = Gdx.graphics.getWidth()/4;
                	 int posX = random.nextInt(4);
                	 int posY  = random.nextInt(4);
                	 System.out.println(posX);
                	 System.out.println(posY);
                     Obstaculo nuevoObstaculo = new Obstaculo(posX*anchoPantalla,posY*altoPantalla);
                     obstaculos.add(nuevoObstaculo);
                     detector.registrarColisionable(nuevoObstaculo);
                 }
             });
		}
		for(Obstaculo obs : obstaculos) {
			obs.setControladorObstaculo(this);
		}
	}*/
	
}
