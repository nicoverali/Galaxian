package edu.uns.galaxian.juego.config;

import com.google.gson.Gson;
import edu.uns.galaxian.entidades.autonoma.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.entidades.equipamiento.armas.*;
import edu.uns.galaxian.entidades.equipamiento.escudos.*;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.nave.jugador.NaveJugador;
import edu.uns.galaxian.util.io.gson.GSONNonFieldTypeAdapter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ConfigNivel{

    private NaveJugador naveJugador;
    private FabricaEnemigos fabricaEnemigos;

    public ConfigNivel(JsonObject datosNivel, NaveJugador naveJugador){
        Gson gson = getGson();

        JsonObject equipamientoJugador = datosNivel.getAsJsonObject(GameData.EQUIPAMIENTO);
        Arma armaJugador = gson.fromJson(equipamientoJugador.getAsJsonObject(GameData.ARMA), Arma.class);
        Escudo escudoJugador = gson.fromJson(equipamientoJugador.getAsJsonObject(GameData.ESCUDO), Escudo.class);
        naveJugador.setArma(armaJugador);
        naveJugador.setEscudo(escudoJugador);

        this.naveJugador = naveJugador;
        this.fabricaEnemigos = gson.fromJson(datosNivel.getAsJsonObject(GameData.FABRICA_ENEMIGO), FabricaEnemigos.class);
    }

    // Metodos
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