package edu.uns.galaxian.juego.nivel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.*;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.juego.Tiempo;
import edu.uns.galaxian.oleada.*;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.escenario.Background;

public class Nivel extends ScreenAdapter{

    private DirectorNivel director;
    private Background background;
    private Jugador jugador;
    private Controlador controlador;
    private Oleada oleadaActual;

    private BitmapFont score;
    private BitmapFont time;

    private Tiempo tiempo;
   
    
    public Nivel(DirectorNivel director){
        this.director = director;
        background = new Background();
        controlador = director.getControladorEntidad();
        jugador = new Jugador(new Vector2(Gdx.graphics.getWidth()/2, 50), director.getNaveJugador(), this, controlador);
        controlador.agregarJugador(jugador);
        oleadaActual = director.getProximaOleada(this);
        oleadaActual.iniciar();
        //El marcador
        score= new BitmapFont();
        time= new BitmapFont();
        tiempo = new Tiempo();
        tiempo.iniciar();
    }

    public void render(float delta) {
        // Limpiar pantalla
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        EntidadBatch batch = director.getEntidadBatch();

        oleadaActual.actualizar(delta);
        background.draw();
        // Inicializa proceso de dibujado de EntidadBatch
        batch.begin();
        controlador.actualizarEstado(delta);
        controlador.dibujar(batch);
        score.draw(batch,"Score= "+Integer.toString(jugador.getPuntaje()),0,Gdx.graphics.getHeight()-5);
        time.draw(batch, "Time= "+tiempo.getHora()+":"+tiempo.getMinutos()+":"+tiempo.getSegundos(),0,Gdx.graphics.getHeight()-20);
        // Finaliza proceso de dibujado
        batch.end();
    }

    public void dispose() {

    }

    public void oleadaFinalizada() throws IllegalArgumentException{
        oleadaActual.finalizar();
        if(director.hayMasOleadas()){
            oleadaActual = director.getProximaOleada(this);
            oleadaActual.iniciar();
        }
        else{
            director.finalizarNivel();
        }
    }

	public void gameOver() {
		//juego.pantallaGameOver(controlador.getPuntuacion());
	}

    public float getTiempoActual() {
        return tiempo.getTiempoEnMinutos();
    }

}