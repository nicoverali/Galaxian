package edu.uns.galaxian.juego.screen.nivel;

import com.badlogic.gdx.assets.AssetManager;
import com.google.gson.*;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.juego.config.CargadorOleada;
import edu.uns.galaxian.nave.NaveJugador;
import edu.uns.galaxian.oleada.*;
import edu.uns.galaxian.util.EntidadBatch;

public class DirectorNivel {

    private Juego juego;
    private JsonArray nivelJson;
    private Nivel nivel;
    private NaveJugador naveJugador;
    private CargadorOleada cargador;
    private Controlador controladorEntidad;
    private int proximaOleada;

    public DirectorNivel(Juego juego, JsonArray nivelJson, NaveJugador naveJugador){
        this.juego = juego;
        this.nivelJson = nivelJson;
        this.naveJugador = naveJugador;
        controladorEntidad = new Controlador(juego.getAssetManager());
        cargador = new CargadorOleada();
        proximaOleada = 0;

        nivel = new Nivel(this);
        juego.setScreen(nivel);
    }

    /**
     * Retorna el controlador de entidades
     * que debe utilizar el nivel
     * @return Controlador de entidades
     */
    public Controlador getControladorEntidad(){
        return controladorEntidad;
    }

    /**
     * Retorna la instancia de EntidadBatch
     * que debe utilizar el nivel
     * @return Instancia de EntidadBatch
     */
    public EntidadBatch getEntidadBatch(){
        return juego.getBatch();
    }

    /**
     * Retorna la nave que el jugador deseo
     * utilizar
     * @return Nave del jugador
     */
    public NaveJugador getNaveJugador(){
        return naveJugador;
    }

    /**
     * Verifica si hay mas oleadas
     * @return Verdadero si hay mas oleadas, falso en caso contrario
     */
    public boolean hayMasOleadas(){
        return proximaOleada < nivelJson.size();
    }

    /**
     * Retorna la proxima oleada en el nivel
     * @param nivel Nivel que esta trabajando con las oleadas
     * @return Proxima oleada
     */
    public Oleada getProximaOleada(Nivel nivel){
        JsonObject oleadaJson = nivelJson.get(proximaOleada++).getAsJsonObject();
        return cargador.cargarOleada(oleadaJson, controladorEntidad, nivel);
    }

    /**
     * Retorna el AssetManager del juego
     * @return AssetManager del juego
     */
    public AssetManager getAssetManager(){
        return juego.getAssetManager();
    }

    /**
     * Retorna a el juego
     * @return Juego
     */
    public Juego getJuego(){
        return juego;
    }

    /**
     * Muestra la pantalla de nivel ganado
     * con el puntaje final
     * @param puntaje Puntaje final del nivel
     */
    public void ganarNivel(int puntaje){
        nivel.setEstadoNivel(new EstadoNivelGanado(nivel, this));
    }

    /**
     * Muestra la pantalla de nivel perdido con el
     * puntaje final del jugador
     * @param puntaje Puntaje final del jugador
     */
    public void perderNivel(int puntaje){
        nivel.setEstadoNivel(new EstadoNivelPerdido(nivel, this));
    }
}
