package edu.uns.galaxian.entidades;

import edu.uns.galaxian.entidades.status.StatusVida;

public interface EntidadViva extends Entidad {

	/**
	 * Setea la vida de la entidad al maximo permitido.
	 */
    void setVidaAlMaximo();
	
	/**
	 * Resta a la vida actual de la entidad, la cantidad de vida recibida. Si al restar la vida,
	 * esta resulta ser menor que 0 entonces la vida se setea a 0, es decir, la vida resultante nunca
	 * puede ser negativa.
	 * @param vidaARestar Cantidad de vida que se desea restar
	 * @throws IllegalArgumentException Si la vida recibida es negativa
	 */
    void restarVida(int vidaARestar) throws IllegalArgumentException;

	/**
	 * Retorna el estado actual de la entidad.
	 * @return Estado actual de la entidad
	 */
    StatusVida getStatus();
	
}
