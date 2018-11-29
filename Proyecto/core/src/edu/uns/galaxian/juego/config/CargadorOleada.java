package edu.uns.galaxian.juego.config;

import com.badlogic.gdx.math.Vector2;
import com.google.gson.*;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.enemigo.fabrica.FabricaEnemigos;
import edu.uns.galaxian.juego.screen.nivel.Nivel;
import edu.uns.galaxian.oleada.*;
import edu.uns.galaxian.util.enums.TipoEnemigo;
import edu.uns.galaxian.util.io.gson.*;

import java.util.*;
import static edu.uns.galaxian.juego.config.GameData.*;

public class CargadorOleada {

    private Gson globalGson;

    public CargadorOleada(){
        globalGson = crearGson();
    }

    public Oleada cargarOleada(JsonObject oleadaJson, Controlador controlador, Nivel nivel){
        JsonObject configOleada = oleadaJson.getAsJsonObject(CONFIG_OLEADA);
        JsonArray decoratorsOleada = oleadaJson.getAsJsonArray(DECORATORS);
        Gson gsonOleada = crearGsonConfigOleada(configOleada, controlador, nivel);
        Oleada oleada = gsonOleada.fromJson(oleadaJson.get(OLEADA), Oleada.class);
        oleada = crearOleadaDecorators(oleada, decoratorsOleada, controlador);
        return oleada;
    }

    private Gson crearGsonConfigOleada(JsonObject oleadaConfig, Controlador controlador, Nivel nivel){
        GsonBuilder builder = new GsonBuilder();
        FabricaEnemigos fabrica = globalGson.fromJson(oleadaConfig.get(FABRICA), FabricaEnemigos.class);
        if(oleadaConfig.has(FORMACION)){
            Class<?>[] tiposArgumentos = new Class[]{List.class, Controlador.class, Nivel.class};
            Object[] argumentos = new Object[]{leerFormacion(oleadaConfig.getAsJsonArray(FORMACION), fabrica, controlador), controlador, nivel};
            builder.registerTypeAdapter(Oleada.class, new GSONClassDeserializer<>(tiposArgumentos, argumentos));
        }else if(oleadaConfig.has(LISTA_ENEMIGOS)){
            Class<?>[] tiposArgumentos = new Class[]{List.class, Controlador.class, Nivel.class};
            Object[] argumentos = new Object[]{leerListaEnemigo(oleadaConfig.getAsJsonArray(LISTA_ENEMIGOS) , fabrica, controlador), controlador, nivel};
            builder.registerTypeAdapter(Oleada.class, new GSONClassDeserializer<>(tiposArgumentos, argumentos));
        }else if(oleadaConfig.has(CANT_KAMIKAZE)){
            Class<?>[] tiposArgumentos = new Class[]{int.class, FabricaEnemigos.class, Controlador.class, Nivel.class};
            Object[] argumentos = new Object[]{oleadaConfig.get(CANT_KAMIKAZE).getAsInt(), fabrica, controlador, nivel};
            builder.registerTypeAdapter(Oleada.class, new GSONClassDeserializer<>(tiposArgumentos, argumentos));

        }
        return builder.create();
    }

    private Oleada crearOleadaDecorators(Oleada oleadaPrincipal, JsonArray decorators, Controlador controlador){
        GSONOleadaDecoratorDeserializer typeAdapter = new GSONOleadaDecoratorDeserializer(oleadaPrincipal, controlador);
        Gson gson = new GsonBuilder().registerTypeAdapter(OleadaDecorator.class, typeAdapter).create();
        return gson.fromJson(decorators, OleadaDecorator.class);
    }

    private List<Enemigo> leerListaEnemigo(JsonArray lista, FabricaEnemigos fabrica, Controlador controlador){
        final Vector2 DEFAULT_POS = new Vector2(0,0);
        List<Enemigo> resultado = new ArrayList<>(lista.size());
        for(int i = 0; i < lista.size(); i++){
            TipoEnemigo tipoEnemigo = globalGson.fromJson(lista.get(i), TipoEnemigo.class);
            Enemigo enemigo = fabrica.crearEnemigo(tipoEnemigo, DEFAULT_POS, controlador, controlador.getJugador());
            resultado.add(enemigo);
        }
        return resultado;
    }

    private List<List<Enemigo>> leerFormacion(JsonArray formacion, FabricaEnemigos fabrica, Controlador controlador){
        final Vector2 DEFAULT_POS = new Vector2(0,0);
        List<List<Enemigo>> resultado = new ArrayList<>(formacion.size());
        for(int i = 0; i < formacion.size(); i++){
            JsonArray fila = formacion.get(i).getAsJsonArray();
            List<Enemigo> filaRes = new ArrayList<>(fila.size());
            for(int j = 0; j < fila.size(); j++){
                TipoEnemigo tipoEnemigo = globalGson.fromJson(fila.get(j), TipoEnemigo.class);
                Enemigo enemigo = fabrica.crearEnemigo(tipoEnemigo, DEFAULT_POS, controlador, controlador.getJugador());
                filaRes.add(enemigo);
            }
            resultado.add(filaRes);
        }
        return resultado;
    }

    private Gson crearGson(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(new GSONEnumTypeAdapter());
        builder.registerTypeAdapter(FabricaEnemigos.class, new GSONClassDeserializer<>());
        builder.registerTypeAdapter(Oleada.class, new GSONClassDeserializer<>());
        return builder.create();
    }

}