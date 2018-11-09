package edu.uns.galaxian.juego.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.uns.galaxian.juego.exceptions.NonExistentGameDataException;
import edu.uns.galaxian.nave.NaveJugador;
import edu.uns.galaxian.util.io.IOManager;

import java.io.IOException;

public class GameData {

    public static final String DIR = "./files/game_data.json";
    public static final String OLEADA = "oleada";
    public static final String CONFIG_OLEADA = "configuracion";
    public static final String FORMACION = "formacion";
    public static final String FABRICA = "fabricaEnemigos";
    public static final String LISTA_ENEMIGOS = "listaEnemigos";
    public static final String CANT_KAMIKAZE = "cantidadKamikaze";
    public static final String DECORATORS = "decoratorsOleada";

    private JsonArray dataJson;

    public GameData() throws NonExistentGameDataException{
        IOManager io = IOManager.getInstance();
        JsonParser parser = new JsonParser();
        try{
            dataJson = parser.parse(io.leerArchivo(DIR, true)).getAsJsonArray();
        }catch (IOException e){
            throw new NonExistentGameDataException("Los config del juego no existen o estan corruptos.",e);
        }
    }

    /**
     * Retorna la cantidad de niveles que hay en el juego.
     * @return Cantidad de niveles en el juego
     */
    public int getCantidadNiveles(){
        return dataJson.size();
    }

    /**
     * Retorna el objeto de configuracion del nivel pedido.
     * @param nivel Nivel
     * @return Objeto de configuracion del nivel
     * @throws IndexOutOfBoundsException Si el nivel es menor a 1 o no existe
     */
    public JsonArray getNivel(int nivel) throws IndexOutOfBoundsException{
        verificarNivel(nivel);
        return dataJson.get(nivel-1).getAsJsonArray();
    }

    private void verificarNivel(int nivel) throws IndexOutOfBoundsException{
        if(nivel < 1) {
            throw new ArrayIndexOutOfBoundsException("El nivel no puede ser negativo ni cero.");
        }
        if(nivel > dataJson.size()){
            throw new ArrayIndexOutOfBoundsException("Este nivel no existe.");
        }
    }
}
