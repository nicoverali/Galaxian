package edu.uns.galaxian.juego.config.keys;

public enum SaveDataKey {

    // Enums
    NIVEL_ALCANZADO("nivelAlcanzado"),
    NAVE_JUGADOR("naveJugador");

    // Direccion del archivo
    public static final String DIR_ARCHIVO = "./files/save_data.json";

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
