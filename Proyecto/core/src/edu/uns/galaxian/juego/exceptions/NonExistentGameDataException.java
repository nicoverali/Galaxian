package edu.uns.galaxian.juego.exceptions;

/**
 * Si los config del juego no existen o no son validos, una NonExistentGameDataException sera lanzada.
 */
public class NonExistentGameDataException extends RuntimeException {

    /**
     * Crea la excepcion con los detalles proveidos.
     * @param detalles Detalles de la excepcion lanzada
     */
    public NonExistentGameDataException(String detalles){
        super(detalles);
    }

    /**
     * Crea la excepcion con los detalles y la causa proveida.
     * @param detalles Detalles de la excepcion lanzada
     * @param causa Causa de la excepcion
     */
    public NonExistentGameDataException(String detalles, Throwable causa){
        super(detalles, causa);
    }
}