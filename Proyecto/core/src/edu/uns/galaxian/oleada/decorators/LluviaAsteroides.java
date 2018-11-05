package edu.uns.galaxian.oleada.decorators;

import java.util.Random;

import com.badlogic.gdx.Gdx;

import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.ia.inteligencias.basica.InteligenciaDeOnda;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.oleada.*;
import edu.uns.galaxian.util.Temporizador;

public class LluviaAsteroides extends OleadaDecorator implements Observador<LiveData<Integer>> {

	private static final int CANT_MAXIMA_OBSTACULOS = 5;

	private Temporizador temporizador;
	private Controlador controlador;
    private int cantObstaculos;

    public LluviaAsteroides(Oleada oleadaPrincipal, Controlador controlador){
        super(oleadaPrincipal);
    	this.controlador = controlador;
    	temporizador = new Temporizador();
        cantObstaculos = 0;
    }

	public void actualizar(float delta) throws IllegalStateException {
    	super.actualizar(delta);
		if(cantObstaculos < CANT_MAXIMA_OBSTACULOS && temporizador.tiempoCumplido()){
			final Random ran = new Random();
			int posY  = ran.nextInt(200) + Gdx.graphics.getHeight() / 3;
			Obstaculo nuevoObstaculo = new Obstaculo(0 , posY, controlador);
			nuevoObstaculo.setInteligencia(new InteligenciaDeOnda<>(nuevoObstaculo));
			controlador.agregarEntidad(nuevoObstaculo);
			nuevoObstaculo.getVida().observar(this);
			cantObstaculos++;
			temporizador.iniciar(ran.nextInt(6000) + 2000);
		}
	}

	public void notificar(LiveData<Integer> subject) {
		if(subject.getValor()==0) {
			cantObstaculos--;
		}
	}
}
