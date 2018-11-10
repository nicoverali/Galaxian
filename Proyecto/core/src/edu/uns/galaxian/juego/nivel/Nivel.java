package edu.uns.galaxian.juego.nivel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.*;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.Tiempo;
import edu.uns.galaxian.oleada.*;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.escenario.Background;

public class Nivel extends ScreenAdapter{

    private DirectorNivel director;
    private CampoEstrellas estrellas;
    private Jugador jugador;
    private Controlador controlador;
    private Oleada oleadaActual;

    private BitmapFont score;
    private BitmapFont time;

    private Tiempo tiempo;
   
    
    public Nivel(DirectorNivel director){
        this.director = director;
        estrellas = new CampoEstrellas(CampoEstrellas.ABAJO, 500);
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
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
        EntidadBatch batch = director.getEntidadBatch();

        oleadaActual.actualizar(delta);
        estrellas.draw(delta);
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

    /**
     * Se llama cuando la oleada actual del nivel finalizo,
     * el nivel elimina la oleada actual y verifica si hay mas
     * oleadas para continuar el nivel, en caso de que no haya
     * el nivel se determina como ganado
     */
    public void oleadaFinalizada(){
        oleadaActual.finalizar();
        if(director.hayMasOleadas()){
            oleadaActual = director.getProximaOleada(this);
            oleadaActual.iniciar();
        }
        else{
            director.ganarNivel(jugador.getPuntaje());
        }
    }

    /**
     * Se llama cuando el jugador muere y
     * se pierde el nivel. El nivel avisa a su
     * director que debe finalizar.
     */
	public void perderNivel(){
        director.perderNivel(jugador.getPuntaje());
    }

    /**
     * Retorna el tiempo transcurrido desde que inicio el
     * nivel en minutos
     * @return Tiempo transcurrido en minutos
     */
    public float getTiempoActual() {
        return tiempo.getTiempoEnMinutos();
    }

}