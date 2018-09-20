package edu.uns.galaxian.juego.config.keys;

import java.util.HashMap;

public enum GameDataKey {
    // Enums
    NIVEL_TIPO("tipo"),
    NIVEL_JUGADOR("jugador"),
    NIVEL_CONTROLADORES("controladores"),
    CONTROLADOR_ENEMIGO("controladorEnemigo"),
    FORMACION("formacion"),
    ENEMIGOS("enemigos"),
    ENEMIGOS_KAMIKAZE("kamikaze"),
    ENEMIGOS_ARMADO("armado"),
    VIDA_MAXIMA("vidaMaxima"),
    VELOCIDAD_MAXIMA("velocidadMaxima"),
    ARMA("arma"),
    ESCUDO("escudo"),
    INTELIGENCIA("inteligencia"),
    MODO_ENEMIGO("modo");


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
