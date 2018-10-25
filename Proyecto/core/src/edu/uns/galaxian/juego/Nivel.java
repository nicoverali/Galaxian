package edu.uns.galaxian.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.*;
import edu.uns.galaxian.servicios.FormacionEnemigo;
import edu.uns.galaxian.servicios.GeneracionObstaculo;
import edu.uns.galaxian.servicios.ServicioDeDesarrollo;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.escenario.Background;
import edu.uns.galaxian.juego.config.ConfigNivel;
import edu.uns.galaxian.servicios.Servicio;
import edu.uns.galaxian.util.enums.TipoEnemigo;
import java.util.*;

public class Nivel extends ScreenAdapter {

    private Juego juego;
    private Background background;
    private Controlador controlador;
    private List<Servicio> servicios;

    private BitmapFont score;
    private BitmapFont time;
    
    private int contador;
    private int mili;
    private int seg;
    private int min;
   
    
    public Nivel(ConfigNivel config, Juego juego){
        this.juego = juego;
        background = new Background();
        controlador = new Controlador(juego.getTextureAtlas());
        Jugador jugador = new Jugador(new Vector2(Gdx.graphics.getWidth()/2, 50), config.getNaveJugador(), this, controlador);
        controlador.agregarJugador(jugador);
        servicios = new LinkedList<>();
        FormacionEnemigo formacion = new FormacionEnemigo(formacionRandom(), config.getFabricaEnemigos(), controlador);
        GeneracionObstaculo obstaculos = new GeneracionObstaculo(controlador);
        servicios.add(formacion);
        servicios.add(obstaculos);
        formacion.activar();
        obstaculos.activar();
        //new ServicioDeDesarrollo(controlador, config.getFabricaEnemigos()).activar();
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
        EntidadBatch batch = juego.getBatch();

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

    /**
     * Retorna una formacion enemiga. Metodo solo para desarrollo.
     */
    private List<List<TipoEnemigo>> formacionRandom(){
        Random ran = new Random();
        List<List<TipoEnemigo>> formacion = new ArrayList<>(4);
        for(int i = 0; i < 5; i++){
            int cant;
            do{
                cant = ran.nextInt(7)+2;
            }while(cant % 2 == 0);
            List<TipoEnemigo> tempFila = new ArrayList<>(cant);
            for(int j = 0; j < cant; j++){
                tempFila.add(TipoEnemigo.values()[ran.nextInt(cant) % 5]);
            }
            formacion.add(tempFila);
        }
        return  formacion;
    }

	public void gameOver() {
		juego.pantallaGameOver(controlador.getPuntuacion());
	}
}