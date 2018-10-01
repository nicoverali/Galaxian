package edu.uns.galaxian.entidades;

import edu.uns.galaxian.entidades.status.StatusVida;

public interface EntidadViva extends Entidad{
	
	public StatusVida getStatus();

	/**
	 * Setea la vida de la entidad al maximo permitido.
	 */
	public void setVidaAlMaximo();
	
	/**
	 * Resta a la vida actual de la entidad, la cantidad de vida recibida. Si al restar la vida,
	 * esta resulta ser menor que 0 entonces la vida se setea a 0, es decir, la vida resultante nunca
	 * puede ser negativa.
	 * @param vidaARestar Cantidad de vida que se desea restar
	 * @throws IllegalArgumentException Si la vida recibida es negativa
	 */
	public void restarVida(int vidaARestar);
	
}
