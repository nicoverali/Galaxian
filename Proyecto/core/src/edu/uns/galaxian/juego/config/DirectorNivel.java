package edu.uns.galaxian.juego.config;

import com.google.gson.*;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.juego.Nivel;
import edu.uns.galaxian.nave.NaveJugador;
import edu.uns.galaxian.servicios.*;
import edu.uns.galaxian.util.EntidadBatch;

public class DirectorNivel {

    private Juego juego;
    private JsonArray nivelJson;
    private NaveJugador naveJugador;
    private Gson globalGson;
    private CargadorOleada cargador;
    private Controlador controladorEntidad;
    private int proximaOleada;

    public DirectorNivel(Juego juego, JsonArray nivelJson, NaveJugador naveJugador){
        this.juego = juego;
        this.nivelJson = nivelJson;
        this.naveJugador = naveJugador;
        controladorEntidad = new Controlador(juego.getTextureAtlas());
        globalGson = new Gson();
        cargador = new CargadorOleada();
        proximaOleada = 0;

        Nivel nivel = new Nivel(this);
        juego.setScreen(nivel);
    }

    public Controlador getControladorEntidad(){
        return controladorEntidad;
    }

    public EntidadBatch getEntidadBatch(){
        return juego.getBatch();
    }

    public NaveJugador getNaveJugador(){
        return naveJugador;
    }

    public boolean hayMasOleadas(){
        return nivelJson.size() == proximaOleada;
    }

    public Oleada getProximaOleada(){
        CargadorOleada cargador = new CargadorOleada();
        JsonObject oleadaJson = nivelJson.get(proximaOleada++).getAsJsonObject();
        return cargador.cargarOleada(oleadaJson, controladorEntidad);
    }
}
