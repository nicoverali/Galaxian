package edu.uns.galaxian.juego.config.keys;

import java.util.HashMap;

public enum GameDataKey {

    // Enums
    NIVEL_TIPO("tipo"),
    JUGADOR("jugador"),
    ARMA("arma"),
    ESCUDO("escudo"),
    INPUT("procesadorInput"),
    NAVE_JUGADOR("naveJugador"),
    FABRICA_ENEMIGOS("fabricaEnemigos"),
    CONTROLADORES("controladores"),
    CONTROLADOR_ENEMIGO("controladorEnemigo");

    // Direccion del archivo
    public static final String DIR_ARCHIVO = "./files/game_data.json";

    // Clave guardada por cada enum
    private String key;

    // Mapeo para hacer busquedas inversas
    private static final HashMap<String, GameDataKey> enumHash = new HashMap<>();

    private GameDataKey(String key){
        this.key = key;
    }

    /**
     * Busca alguna constante de este enum que contenga la key proveida.
     * @param key Key de alguna constante
     * @return Constante que contiene la key proveida
     */
    public static GameDataKey buscarPorKey(String key){
        if(enumHash.isEmpty()){
            GameDataKey[] valores = values();
            for(GameDataKey valor : valores){
                enumHash.put(valor.key, valor);
            }
        }
        return enumHash.get(key);
    }

    /**
     * Retorna la key que representa este enum
     * @return Key represantada
     */
    public String key(){
        return this.key;
    }
}
