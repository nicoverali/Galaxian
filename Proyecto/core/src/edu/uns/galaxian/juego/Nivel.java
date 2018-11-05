package edu.uns.galaxian.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.*;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.juego.config.DirectorNivel;
import edu.uns.galaxian.servicios.*;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.escenario.Background;
import edu.uns.galaxian.util.enums.TipoEnemigo;
import java.util.*;

public class Nivel extends ScreenAdapter{

    private DirectorNivel director;
    private Background background;
    private Controlador controlador;
    private Oleada oleadaActual;

    private BitmapFont score;
    private BitmapFont time;
    
    private int contador;
    private int mili;
    private int seg;
    private int min;
   
    
    public Nivel(DirectorNivel director){
        this.director = director;
        background = new Background();
        controlador = director.getControladorEntidad();
        Jugador jugador = new Jugador(new Vector2(Gdx.graphics.getWidth()/2, 50), director.getNaveJugador(), this, controlador);
        controlador.agregarJugador(jugador);
        oleadaActual = director.getProximaOleada();
        oleadaActual.iniciar();
        //El marcador
        score= new BitmapFont();
        time= new BitmapFont();
    }
    
    private void actualizarTiempo(){
    	contador=(int) Gdx.graphics.getDeltaTime();
    	if(contador<=1) {mili++;}
    	if(mili==59)
    	{
    		seg++;mili=0;
    	}
    	if(seg==59)
    	{
    		seg=0;
    		min++;
    	}  	
    }

    @Override
    public void render(float delta) {
        // Limpiar pantalla
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        EntidadBatch batch = director.getEntidadBatch();

        background.draw();
        actualizarTiempo();
        // Inicializa proceso de dibujado de EntidadBatch
        batch.begin();
        controlador.actualizarEstado(delta);
        controlador.dibujar(batch);
        score.draw(batch,"Score= "+Integer.toString(controlador.getPuntuacion()),0,Gdx.graphics.getHeight()-5);
        time.draw(batch, "Time= "+min+":"+seg+":"+mili,0,Gdx.graphics.getHeight()-20);
        // Finaliza proceso de dibujado
        batch.end();
    }

    @Override
    public void dispose() {

    }

	public void gameOver() {
		//juego.pantallaGameOver(controlador.getPuntuacion());
	}
}