package edu.uns.galaxian.juego.config;


import com.google.gson.Gson;
import edu.uns.galaxian.entidades.autonoma.enemigo.FabricaEnemigos;
import edu.uns.galaxian.entidades.equipamiento.armas.*;
import edu.uns.galaxian.entidades.equipamiento.escudos.*;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.entidades.jugador.input.ProcesadorInput;
import edu.uns.galaxian.entidades.jugador.nave.*;
import edu.uns.galaxian.juego.config.keys.GameDataKey;
import edu.uns.galaxian.util.io.GSONNonFieldTypeAdapter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ConfigNivel{

    private Arma armaJugador;
    private Escudo escudoJugador;
    private NaveJugador naveJugador;
    private FabricaEnemigos fabricaEnemigos;

    public ConfigNivel(JsonObject datosNivel, NaveJugador naveJugador){
        Gson gson = getGson();

        JsonObject datosJugador = datosNivel.getAsJsonObject(GameDataKey.JUGADOR.key());
        armaJugador = gson.fromJson(datosJugador.getAsJsonObject(GameDataKey.ARMA.key()), Arma.class);
        escudoJugador = gson.fromJson(datosJugador.getAsJsonObject(GameDataKey.ESCUDO.key()), Escudo.class);
        this.naveJugador = naveJugador;

        fabricaEnemigos = gson.fromJson(datosNivel.getAsJsonObject(GameDataKey.FABRICA_ENEMIGOS.key()), FabricaEnemigos.class);
    }

    // Metodos
   public Arma getArmaJugador(){
        return armaJugador;
   }
   public Escudo getEscudoJugador(){
        return escudoJugador;
   }
   public NaveJugador getNaveJugador(){
        return naveJugador;
   }
   public FabricaEnemigos getFabricaEnemigos(){
        return fabricaEnemigos;
   }

    private Gson getGson(){
        Class<?>[] armaClases = new Class[]{Disparo.class};
        Object[] armaParametros = new Object[]{new DisparoJugador()};
        return new GsonBuilder().registerTypeAdapterFactory(new GSONNonFieldTypeAdapter())
                .registerTypeAdapterFactory(new GSONNonFieldTypeAdapter(Arma.class, armaClases, armaParametros))
                .create();
    }
}