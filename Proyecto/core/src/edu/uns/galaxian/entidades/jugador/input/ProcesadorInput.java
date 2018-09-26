package edu.uns.galaxian.entidades.jugador.input;

public interface ProcesadorInput {

	/*
	 * Devuelve la direccion en la que se desea mover el jugador
	 * @return -1 si se presiono izquierda, retorna 1 si se presiono derecha.
	 */
	int getXAxis();
	
	/*
	 * Devuelve si se acciono la tecla disparar.
	 * @ true si disparo, false en caso contrario.
	 */
	boolean sePresionoDisparar();
}
