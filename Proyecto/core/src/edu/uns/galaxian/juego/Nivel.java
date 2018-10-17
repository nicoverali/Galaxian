package edu.uns.galaxian.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

import edu.uns.galaxian.colision.DetectorColision;
import edu.uns.galaxian.controladores.*;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.escenario.Background;
import edu.uns.galaxian.juego.config.ConfigNivel;
import edu.uns.galaxian.entidades.autonoma.enemigo.TipoEnemigo;
import java.util.*;

public class Nivel extends ScreenAdapter {

    private Juego juego;
    private Jugador jugador;
    private Background background;
    private DetectorColision detector;
    private List<ControladorEntidad> controladores;

    public Nivel(ConfigNivel config, Juego juego){
        this.juego = juego;
        background = new Background();
        detector = new DetectorColision();
        controladores = new LinkedList<>();

        ControladorDisparo cDisparos = new ControladorDisparo(detector);
        jugador = new Jugador(Gdx.graphics.getWidth()/2, 50, config.getNaveJugador(), this, cDisparos);
        ControladorEnemigo cEnemigos = new ControladorEnemigo(config.getFabricaEnemigos(), formacionRandom(), jugador.getStatus(), detector, cDisparos);
        ControladorObstaculo cObstaculo = new ControladorObstaculo(detector);

        controladores.add(cDisparos);
        controladores.add(cEnemigos);
        controladores.add(cObstaculo);
    }

    @Override
    public void render(float delta) {
        // Limpiar pantalla
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        EntidadBatch batch = juego.getBatch();

        background.draw();
        // Inicializa proceso de dibujado de EntidadBatch
        batch.begin();
        jugador.actualizar(delta);
        jugador.dibujar(batch);
        for(ControladorEntidad controlador : controladores){
            controlador.actualizarEstado(delta);
            controlador.dibujar(batch);
        }
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
            int cant = ran.nextInt(9);
            List<TipoEnemigo> tempFila = new ArrayList<>(cant);
            for(int j = 0; j < cant; j++){
                tempFila.add(TipoEnemigo.values()[ran.nextInt(cant) % 5]);
            }
            formacion.add(tempFila);
        }
        return  formacion;
    }
}