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


    private Tiempo tiempo;

    public EstadoNivelNormal(Nivel nivel){
        this.nivel = nivel;
        controlador = nivel.getControlador();
        estrellas = nivel.getCampoEstrellas();
        batch = nivel.getBatch();
        jugador = nivel.getJugador();
        tiempo = nivel.getTiempoNivel();
    }


    public void accion(float delta) {
        nivel.getOleadaActual().actualizar(delta);
        estrellas.draw(delta);
        // Inicializa proceso de dibujado de EntidadBatch
        batch.begin();
        controlador.actualizarEstado(delta);
        controlador.dibujar(batch);
        nivel.getNivelFont().draw(batch,"Score : "+Integer.toString(jugador.getPuntaje()),0,Gdx.graphics.getHeight()-5);
        nivel.getNivelFont().draw(batch, "Time : "+tiempo.getHora()+":"+tiempo.getMinutos()+":"+tiempo.getSegundos(),0,Gdx.graphics.getHeight()-30);
        nivel.getNivelFont().draw(batch, "Vida : "+jugador.getVida().getValor(),0,Gdx.graphics.getHeight()-55);
        // Finaliza proceso de dibujado
        batch.end();
    }
}