package edu.uns.galaxian.juego.config.keys;

public enum SaveDataKey {

    // Enums
    NIVEL_ALCANZADO("nivelAlcanzado");

    // Clave guardada por cada enum
    private String key;

    private SaveDataKey(String key){
        this.key = key;
    }

    /**
     * Retorna la key que representa este enum
     * @return Key represantada
     */
    public String key(){
        return this.key;
    }

}
