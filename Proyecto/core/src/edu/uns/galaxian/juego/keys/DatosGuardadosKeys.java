package edu.uns.galaxian.juego.keys;

public enum DatosGuardadosKeys {

    // Enums
    NIVEL_ALCANZADO("nivelAlcanzado");

    // Clave guardada por cada enum
    private String key;

    private DatosGuardadosKeys(String key){
        this.key = key;
    }

    /**
     * Retorna la key que representa este enum
     * @return Key represantada
     */
    public String getKey(){
        return this.key;
    }

}
