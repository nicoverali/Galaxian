package edu.uns.galaxian.juego.exceptions;

/**
 * Si los datos del juego no existen o no son validos, una NonExistentGameDataException sera lanzada.
 */
public class NonExistentGameDataException extends RuntimeException {

    /**
     * Crea la excepcion con los detalles proveidos.
     * @param detalles Detalles de la excepcion lanzada
     */
    public NonExistentGameDataException(String detalles){
        super(detalles);
    }
}
