package edu.uns.galaxian.juego.keys;

import java.util.HashMap;

public enum GameDataKeys {
    // Enums
    NIVEL_TIPO("tipo"),
    NIVEL_JUGADOR("jugador"),
    NIVEL_CONTROLADORES("controladores"),
    JUGADOR_VIDA_MAXIMA("vidaMaxima"),
    JUGADOR_VELOCIDAD_MAXIMA("velocidadMaxima"),
    JUGADOR_ARMA("arma"),
    JUGADOR_ESCUDO("escudo"),
    CONTROLADOR_ENEMIGO("controladorEnemigo"),
    CONTROLADOR_ENEMIGO_FORMACION("formacion"),
    CONTROLADOR_ENEMIGO_ENEMIGOS("enemigos"),
    ENEMIGOS_KAMIKAZE("kamikaze"),
    ENEMIGOS_ARMADO("armado"),
    ENEMIGO_VIDA_MAXIMA("vidaMaxima"),
    ENEMIGO_VELOCIDAD_MAXIMA("velocidadMaxima"),
    ENEMIGO_ARMA("arma"),
    ENEMIGO_MODO("modo");


    // Clave guardada por cada enum
    private String key;

    // Mapeo para hacer busquedas inversas
    private static final HashMap<String, GameDataKeys> enumHash = new HashMap<>();

    private GameDataKeys(String key){
        this.key = key;
    }

    /**
     * Busca alguna constante de este enum que contenga la key proveida.
     * @param key Key de alguna constante
     * @return Constante que contiene la key proveida
     */
    public static GameDataKeys buscarPorKey(String key){
        if(enumHash.isEmpty()){
            GameDataKeys[] valores = values();
            for(GameDataKeys valor : valores){
                enumHash.put(valor.key, valor);
            }
        }
        return enumHash.get(key);
    }

    /**
     * Retorna la key que representa este enum
     * @return Key represantada
     */
    public String getKey(){
        return this.key;
    }
}
