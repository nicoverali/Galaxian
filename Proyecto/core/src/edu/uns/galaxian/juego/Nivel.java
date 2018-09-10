package edu.uns.galaxian.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.uns.galaxian.controladores.ControladorEnemigo;
import edu.uns.galaxian.controladores.ControladorEntidad;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.juego.keys.GameDataKeys;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Nivel extends ScreenAdapter {

    private Juego juego;
    private Jugador jugador;
    private Collection<ControladorEntidad> controladores;

    // Constructor
    public Nivel(JSONObject configNivel, Juego juego){
        this.juego = juego;
        this.controladores = new ArrayList<>();

        // Inicializar jugador
        JSONObject configJugador = configNivel.getJSONObject(GameDataKeys.NIVEL_JUGADOR.getKey());
        jugador = new Jugador( Gdx.graphics.getWidth()/2, 30, 64, configJugador, this);

        // Inicializar controladores
        JSONObject configControladores = configNivel.getJSONObject(GameDataKeys.NIVEL_CONTROLADORES.getKey());
        inicializarControladores(jugador, configControladores);
    }


    @Override
    public void render(float delta) {
        SpriteBatch batch = juego.getBatch();
        // Limpiar pantalla
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Dibujar controladores
        for(ControladorEntidad controlador : controladores){
            controlador.actualizarEstado();
            controlador.dibujar(batch);
        }

        // Dibujar jugador
        jugador.dibujar(batch);
    }

    @Override
    public void dispose() {

    }

    /**
     * Inicializa todos los controladores necesarios en este nivel.
     * Requiere una instancia de Jugador y un objeto JSON de configuracion.
     * @param jugador Jugador del nivel
     * @param config Objeto de configuracion de los controladores
     */
    private void inicializarControladores(Jugador jugador, JSONObject config){
        Iterator<String> keys = config.keys();
        String keyActual;
        JSONObject configControladorActual;
        while(keys.hasNext()){
            keyActual = keys.next();
            switch (GameDataKeys.buscarPorKey(keyActual)){
                case CONTROLADOR_ENEMIGO:{
                    configControladorActual = config.getJSONObject(keyActual);
                    ControladorEnemigo controladorEnemigo = new ControladorEnemigo(configControladorActual, jugador);
                    controladores.add(controladorEnemigo);
                }
            }
        }
    }
}
