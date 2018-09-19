package edu.uns.galaxian.entidades.jugador;

public interface ProcesadorInput {

	/*
	 * Devuelve la posicion del eje X
	 * @return posicion eje X
	 */
	public int getXAxis();
	
	/*
	 * Devuelve si se acciono la tecla disparar
	 * @ true si disparo, false en caso contrario
	 */
	public boolean sePresionoDisparar();
}
