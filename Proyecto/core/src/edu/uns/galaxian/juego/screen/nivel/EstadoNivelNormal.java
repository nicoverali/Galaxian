package edu.uns.galaxian.juego.screen.nivel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.escenario.CampoEstrellas;
import edu.uns.galaxian.juego.Tiempo;
import edu.uns.galaxian.util.EntidadBatch;

class EstadoNivelNormal implements EstadoAnimacion {

    private Controlador controlador;
    private Nivel nivel;
    private Jugador jugador;
    private CampoEstrellas estrellas;
    private EntidadBatch batch;


    private BitmapFont score;
    private BitmapFont time;
    private Tiempo tiempo;

    public EstadoNivelNormal(Nivel nivel){
        this.nivel = nivel;
        controlador = nivel.getControlador();
        estrellas = nivel.getCampoEstrellas();
        batch = nivel.getBatch();
        jugador = nivel.getJugador();

        score= new BitmapFont();
        time= new BitmapFont();
        tiempo = nivel.getTiempoNivel();
    }


    public void accion(float delta) {
        nivel.getOleadaActual().actualizar(delta);
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
}