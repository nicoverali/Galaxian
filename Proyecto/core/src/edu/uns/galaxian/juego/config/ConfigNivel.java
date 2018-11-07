package edu.uns.galaxian.juego.config;

import com.google.gson.Gson;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.entidades.equipamiento.armas.*;
import edu.uns.galaxian.entidades.equipamiento.escudos.*;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.nave.NaveJugador;
import edu.uns.galaxian.util.io.gson.GSONNonFieldTypeAdapter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ConfigNivel{

    private NaveJugador naveJugador;
    private FabricaEnemigos fabricaEnemigos;

    public ConfigNivel(JsonObject datosNivel, NaveJugador naveJugador){
        Gson gson = getGson();

        JsonObject equipamientoJugador = datosNivel.getAsJsonObject(GameData.EQUIPAMIENTO);
        Arma<DisparoJugador> armaJugador = gson.fromJson(equipamientoJugador.getAsJsonObject(GameData.ARMA), Arma.class);
        naveJugador.setArma(armaJugador);

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
        Class<?>[] armaClases = new Class[]{FabricaDisparo.class};
        Object[] armaParametros = new Object[]{new FabricaDisparoJugador(null)};
        return new GsonBuilder().registerTypeAdapterFactory(new GSONNonFieldTypeAdapter())
                .registerTypeAdapterFactory(new GSONNonFieldTypeAdapter(Arma.class, armaClases, armaParametros))
                .create();
    }
}