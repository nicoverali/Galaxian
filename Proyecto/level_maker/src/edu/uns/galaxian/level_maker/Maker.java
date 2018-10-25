package edu.uns.galaxian.level_maker;

import com.badlogic.gdx.Game;
import com.google.gson.*;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEstandar;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.equipamiento.escudos.EscudoNulo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.juego.config.GameData;
import edu.uns.galaxian.util.io.gson.GSONNonFieldTypeAdapter;
import edu.uns.galaxian.util.io.IOManager;

import java.io.IOException;


public class Maker extends Game {

    private Arma<DisparoJugador> ARMA_JUGADOR;
    private Escudo ESCUDO_JUGADOR;
    private FabricaEnemigos FABRICA_ENEMIGOS;

    public void create(){
        ARMA_JUGADOR = new ArmaComun(new FabricaDisparoJugador());
        ESCUDO_JUGADOR = new EscudoNulo();
        FABRICA_ENEMIGOS = new FabricaEstandar();

        IOManager io = IOManager.getInstance();
        Gson gson = getGson();
        JsonArray gameData = getGameData();

        // A partir de aca las cosas se tienen que hacer para cada nivel
        JsonObject nivelJson = new JsonObject();

        // Creacion de EQUIPAMIENTO JSON
        JsonObject equipamiento = new JsonObject();
        equipamiento.add(GameData.ARMA, gson.toJsonTree(ARMA_JUGADOR));
        equipamiento.add(GameData.ESCUDO, gson.toJsonTree(ESCUDO_JUGADOR));

        // Creacion de FABRICA JSON
        JsonElement fabricaEnemigo = gson.toJsonTree(FABRICA_ENEMIGOS);

        nivelJson.add(GameData.EQUIPAMIENTO, equipamiento);
        nivelJson.add(GameData.FABRICA_ENEMIGO, fabricaEnemigo);
        gameData.add(nivelJson);
        try {
            io.escribirArchivoComoString(GameData.DIR, gameData.toString(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Gson getGson(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(new GSONNonFieldTypeAdapter());
        return builder.create();
    }

    private JsonArray getGameData(){
        IOManager io = IOManager.getInstance();
        JsonParser parser = new JsonParser();
        JsonArray gameData;
        try{
            String contenido = io.leerArchivo(GameData.DIR, true);
            gameData = parser.parse(contenido).getAsJsonArray();
        }catch (IOException e){
            gameData = new JsonArray();
        }
        return gameData;
    }
}
