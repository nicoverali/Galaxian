package edu.uns.galaxian.juego.config;

import edu.uns.galaxian.juego.exceptions.NonExistentGameDataException;
import edu.uns.galaxian.util.io.IOManager;
import edu.uns.galaxian.juego.config.keys.SaveDataKey;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;


public class AdministradorDatos {

    // Direccion a archivos
    private static final String SAVE_DATA_DIR = "./files/save_data.json";
    private static final String SAVE_DATA_MD5_DIR = "./files/save_data.h";
    private static final String GAME_DATA_DIR = "./files/game_data.json";

    private JSONObject saveData;
    private JSONArray gameData;

    private AdministradorDatos(){
        cargarDatosGuardados();
        cargarDatosDelJuego();
    }

    // Holder
    private static class HolderInstanciaAdministrador{
        private static final AdministradorDatos INSTANCE = new AdministradorDatos();
    }

    // Pedido de instancia
    public static AdministradorDatos getInstance(){
        return HolderInstanciaAdministrador.INSTANCE;
    }

    // Metodos de escritura
    private boolean guardarDatos(){
        IOManager io = IOManager.getInstace();
        String contenido = saveData.toString();
        try{
            io.escribirArchivoComoString(SAVE_DATA_DIR, contenido, false);
            io.marcarSoloLectura(SAVE_DATA_DIR);

            io.escribirArchivoComoString(SAVE_DATA_MD5_DIR, io.obtenerMD5Hex(contenido), false);
            io.marcarSoloLectura(SAVE_DATA_MD5_DIR);
            io.ocultarArchivo(SAVE_DATA_MD5_DIR);
        }catch (IOException e){
            return false;
        }
        return true;
    }

    // Metodos de inicializacion
    // TODO Verificar integridad de ambos archivos
    private boolean cargarDatosGuardados(){
        IOManager io = IOManager.getInstace();
        // Cargar arhivo de config guardados
        try{
            io.leerArchivo(SAVE_DATA_DIR, true);
        }catch (IOException primExcepcion){
            // Se crea un objeto con nuevos config y luego es persistido en memoria
            saveData = new JSONObject();
            saveData.put(SaveDataKey.NIVEL_ALCANZADO.key(), 1);
            if(!guardarDatos()){
                return false;
            }
        }
        return true;
    }
    private void cargarDatosDelJuego(){
        IOManager io = IOManager.getInstace();
        try{
            gameData = new JSONArray(io.leerArchivo(GAME_DATA_DIR, true));
        }catch (IOException e){
            throw new NonExistentGameDataException("Los config del juego no existen o estan corruptos.",e);
        }
    }

    // Metodos publicos
    public int getCantidadNiveles(){
        return gameData.length();
    }

    public int getNivelAlcanzado(){
        return saveData.getInt(SaveDataKey.NIVEL_ALCANZADO.key());
    }

    public boolean setNivelAlcanzado(int nivel) throws ArrayIndexOutOfBoundsException{
        if(nivel < 1) throw new ArrayIndexOutOfBoundsException("El componentes no puede ser negativo ni cero.");
        if(nivel > gameData.length()) throw new ArrayIndexOutOfBoundsException("Este componentes no existe.");

        saveData.put(SaveDataKey.NIVEL_ALCANZADO.key(), nivel);
        return guardarDatos();
    }

    /*public ConfigNivel getConfiguracionNivel(int nivel) throws ArrayIndexOutOfBoundsException{
        if(nivel < 1) throw new ArrayIndexOutOfBoundsException("El componentes no puede ser negativo ni cero.");
        if(nivel > gameData.length()) throw new ArrayIndexOutOfBoundsException("Este componentes no existe.");

        return new ConfigNivel(gameData.getJSONObject(nivel-1));
    }*/
}
