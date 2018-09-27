package edu.uns.galaxian.level_maker;

import com.badlogic.gdx.Game;
import com.google.gson.*;
import edu.uns.galaxian.entidades.autonoma.enemigo.FabricaEnemigos;
import edu.uns.galaxian.entidades.autonoma.enemigo.FabricaEstandar;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.equipamiento.escudos.EscudoNulo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.input.InputKeyboard;
import edu.uns.galaxian.entidades.jugador.nave.NaveJugador;
import edu.uns.galaxian.entidades.jugador.nave.NaveLiviana;
import edu.uns.galaxian.entidades.jugador.input.ProcesadorInput;
import edu.uns.galaxian.juego.config.keys.GameDataKey;
import edu.uns.galaxian.util.enums.Color;
import edu.uns.galaxian.util.io.GSONNonFieldTypeAdapter;
import edu.uns.galaxian.util.io.IOManager;

import java.io.IOException;


public class Maker extends Game {

    @Override
    public void create() {
        IOManager io = IOManager.getInstance();
        Gson gson = getGson();
        JsonArray gameData = getGameData();
        JsonObject nivelJson = new JsonObject();
        // Creacion de equipamiento de jugador
        Arma jugadorArma = new ArmaComun(new DisparoJugador());
        Escudo jugadorEscudo = new EscudoNulo();
        ProcesadorInput input = new InputKeyboard();
        NaveJugador nave = new NaveLiviana(Color.AZUL);

        // Creacion de JUGADOR JSON
        JsonObject jugadorJson = new JsonObject();
        jugadorJson.add(GameDataKey.ARMA.key(), gson.toJsonTree(jugadorArma, Arma.class));
        jugadorJson.add(GameDataKey.ESCUDO.key(), gson.toJsonTree(jugadorEscudo, Escudo.class));
        jugadorJson.add(GameDataKey.INPUT.key(), gson.toJsonTree(input, ProcesadorInput.class));
        jugadorJson.add(GameDataKey.NAVE_JUGADOR.key(), gson.toJsonTree(nave, NaveJugador.class));

        // Creacion de FABRICA JSON
        JsonElement fabricaEnemigo = gson.toJsonTree(new FabricaEstandar(), FabricaEnemigos.class);

        nivelJson.add(GameDataKey.JUGADOR.key(), jugadorJson);
        nivelJson.add(GameDataKey.FABRICA_ENEMIGOS.key(), fabricaEnemigo);
        gameData.add(nivelJson);
        try {
            io.escribirArchivoComoString("./files/game_data.json", gameData.toString(), false);
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
            String contenido = io.leerArchivo(GameDataKey.DIR_ARCHIVO, true);
            gameData = parser.parse(contenido).getAsJsonArray();
        }catch (IOException e){
            gameData = new JsonArray();
        }
        return gameData;
    }
}
