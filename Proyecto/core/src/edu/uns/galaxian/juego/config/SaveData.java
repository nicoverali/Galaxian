package edu.uns.galaxian.juego.config;

import com.google.gson.*;
import edu.uns.galaxian.nave.NaveJugador;
import edu.uns.galaxian.nave.jugador.NaveLiviana;
import edu.uns.galaxian.util.enums.Color;
import edu.uns.galaxian.util.io.gson.GSONClassDeserializer;
import edu.uns.galaxian.util.io.gson.GSONClassSerializer;
import edu.uns.galaxian.util.io.IOManager;
import edu.uns.galaxian.util.io.gson.GSONEnumTypeAdapter;

import java.io.IOException;

public class SaveData {

    private static final String DIR = "./files/save_data.json";
    private static final String NIVEL_ALCANZADO = "nivelAlcanzado";
    private static final String NAVE_JUGADOR = "naveJugador";
    private static final String NAVE_COLOR = "naveColor";
    
    private JsonObject dataJson;
    
    public SaveData(){
        IOManager io = IOManager.getInstance();
        JsonParser parser = new JsonParser();
        try{
            String jsonString = io.leerArchivo(DIR, true);
            dataJson = parser.parse(jsonString).getAsJsonObject();
        }catch (IOException e){
            dataJson = crearNuevosDatos();
            guardarDatos();
        }
    }

    /**
     * Retorna el maximo nivel alcanzado por el usuario.
     * Los niveles comienzan desde el nivel 1
     * @return Maximo nivel alcanzado por el usuario
     */
    public int getNivelAlcanzado(){
        return dataJson.get(NIVEL_ALCANZADO).getAsInt();
    }

    /**
     * Actualiza el maximo nivel alcanzado por el usuario. Retorna verdadero en caso de
     * que los datos se hayan salvado con exito, o falso en caso contrario.
     * @param nivel Nuevo nivel alcanzado por el usuario
     * @return Verdadero si los datos se salvaron exitosamente
     * @throws ArrayIndexOutOfBoundsException Si el nuevo nivel es menor a 1 o no existe
     */
    public boolean setNivelAlcanzado(int nivel) throws IndexOutOfBoundsException{
        verificarNivel(nivel);
        dataJson.addProperty(NIVEL_ALCANZADO, nivel);
        return guardarDatos();
    }

    /**
     * Retorna la nave que el jugador desea usar.
     * @return Nave del jugador
     */
    public NaveJugador getNaveJugador(){
        Gson gson = getGson();
        Color naveColor = gson.fromJson(dataJson.get(NAVE_COLOR).getAsString(), Color.class);
        gson = agregarNaveJugadorDeserializer(gson, naveColor);
        return gson.fromJson(dataJson.getAsJsonObject(NAVE_JUGADOR), NaveJugador.class);
    }

    private JsonObject crearNuevosDatos(){
        JsonObject nuevosDatos = new JsonObject();
        Gson gson = getGson();
        Color colorNave = Color.VERDE;
        JsonElement naveJugadorJson = gson.toJsonTree(new NaveLiviana(colorNave), NaveLiviana.class);
        JsonElement colorJson = gson.toJsonTree(colorNave, Color.class);
        nuevosDatos.addProperty(NIVEL_ALCANZADO, 1);
        nuevosDatos.add(NAVE_JUGADOR, naveJugadorJson);
        nuevosDatos.add(NAVE_COLOR, colorJson);
        return nuevosDatos;
    }

    private boolean guardarDatos(){
        IOManager io = IOManager.getInstance();
        String contenido = dataJson.toString();
        try{
            io.escribirArchivoComoString(DIR, contenido, false);
        }catch (IOException e){
            return false;
        }
        return true;
    }

    private Gson getGson(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(NaveJugador.class, new GSONClassSerializer<>());
        builder.registerTypeAdapterFactory(new GSONEnumTypeAdapter());
        return builder.create();
    }

    private Gson agregarNaveJugadorDeserializer(Gson gson, Color naveColor){
        GsonBuilder builder = gson.newBuilder();
        builder.registerTypeAdapter(NaveJugador.class, new GSONClassDeserializer<NaveJugador>(new Class[]{Color.class}, new Object[]{naveColor}));
        return builder.create();
    }


    private void verificarNivel(int nivel) throws IndexOutOfBoundsException{
        GameData gameData = new GameData();
        if(nivel < 1) {
            throw new ArrayIndexOutOfBoundsException("El nivel no puede ser negativo ni cero.");
        }
        if(nivel > gameData.getCantidadNiveles()){
            throw new ArrayIndexOutOfBoundsException("Este nivel no existe.");
        }
    }
}