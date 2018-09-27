package edu.uns.galaxian.juego.config;

import edu.uns.galaxian.entidades.jugador.input.InputKeyboard;
import edu.uns.galaxian.entidades.jugador.nave.NaveJugador;
import edu.uns.galaxian.entidades.jugador.nave.NaveLiviana;
import edu.uns.galaxian.juego.config.keys.GameDataKey;
import edu.uns.galaxian.juego.exceptions.NonExistentGameDataException;
import edu.uns.galaxian.util.enums.Color;
import edu.uns.galaxian.util.io.GSONNonFieldTypeAdapter;
import edu.uns.galaxian.util.io.IOManager;
import edu.uns.galaxian.juego.config.keys.SaveDataKey;

import java.io.IOException;

import com.google.gson.*;


public class AdministradorDatos {

    private JsonObject datosDeUsuario;
    private JsonArray datosDelJuego;
    private NaveJugador naveJugador;

    // Constructor
    public AdministradorDatos(){
        cargarDatosDeUsuario();
        cargarDatosDelJuego();

        TypeAdapterFactory naveAdapter = new GSONNonFieldTypeAdapter(NaveJugador.class, new Class[]{Color.class}, new Object[]{Color.AZUL});
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(naveAdapter).create();
        naveJugador = gson.fromJson(datosDeUsuario.getAsJsonObject(SaveDataKey.NAVE_JUGADOR.key()), NaveJugador.class);
    }


    // Metodos
    /**
     * Retorna la cantidad de niveles que hay en el juego.
     * @return Cantidad de niveles en el juego
     */
    public int getCantidadNiveles(){
        return datosDelJuego.size();
    }

    /**
     * Retorna el maximo nivel alcanzado por el usuario.
     * @return Maximo nivel alcanzado por el usuario
     */
    public int getNivelAlcanzado(){
        return datosDeUsuario.get(SaveDataKey.NIVEL_ALCANZADO.key()).getAsInt();
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
        datosDeUsuario.addProperty(SaveDataKey.NIVEL_ALCANZADO.key(), nivel);
        return guardarDatosDeUsuario();
    }

    /**
     * Retorn el objeto de configuracion del nivel pedido.
     * @param nivel Nivel
     * @return  Archivo de configuracion del nivel
     * @throws IndexOutOfBoundsException Si el nivel es menor a 1 o no existe
     */
    public ConfigNivel getConfiguracionNivel(int nivel) throws IndexOutOfBoundsException{
        verificarNivel(nivel);
        JsonObject nivelJson = datosDelJuego.get(nivel-1).getAsJsonObject();
        return new ConfigNivel(nivelJson, naveJugador);
    }

    // Metodo privados
    private void cargarDatosDeUsuario(){
        IOManager io = IOManager.getInstance();
        JsonParser parser = new JsonParser();
        try{
            String jsonString = io.leerArchivo(SaveDataKey.DIR_ARCHIVO, true);
            datosDeUsuario = parser.parse(jsonString).getAsJsonObject();
        }catch (IOException e){
            TypeAdapterFactory genericAdapter = new GSONNonFieldTypeAdapter();
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(genericAdapter).create();
            JsonElement naveJugadorJson = gson.toJsonTree(new NaveLiviana(Color.AZUL), NaveJugador.class);
            datosDeUsuario = new JsonObject();
            datosDeUsuario.addProperty(SaveDataKey.NIVEL_ALCANZADO.key(), 1);
            datosDeUsuario.add(SaveDataKey.NAVE_JUGADOR.key(), naveJugadorJson);
            guardarDatosDeUsuario();
        }
    }

    private void cargarDatosDelJuego(){
        IOManager io = IOManager.getInstance();
        JsonParser parser = new JsonParser();
        try{
            datosDelJuego = parser.parse(io.leerArchivo(GameDataKey.DIR_ARCHIVO, true)).getAsJsonArray();
        }catch (IOException e){
            throw new NonExistentGameDataException("Los config del juego no existen o estan corruptos.",e);
        }
    }

    private boolean guardarDatosDeUsuario(){
        IOManager io = IOManager.getInstance();
        String contenido = datosDeUsuario.toString();
        try{
            io.escribirArchivoComoString(SaveDataKey.DIR_ARCHIVO, contenido, false);
        }catch (IOException e){
            return false;
        }
        return true;
    }

    private void verificarNivel(int nivel) throws IndexOutOfBoundsException{
        if(nivel < 1) {
            throw new ArrayIndexOutOfBoundsException("El nivel no puede ser negativo ni cero.");
        }
        if(nivel > datosDelJuego.size()){
            throw new ArrayIndexOutOfBoundsException("Este nivel no existe.");
        }
    }
}
