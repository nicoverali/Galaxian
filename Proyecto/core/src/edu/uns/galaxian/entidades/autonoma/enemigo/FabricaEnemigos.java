package edu.uns.galaxian.entidades.autonoma.enemigo;

import edu.uns.galaxian.controladores.ControladorEnemigo;
import edu.uns.galaxian.entidades.status.GameObject;

public abstract class FabricaEnemigos {

	/**
	 * Crea un nuevo enemigo segun la informacion provista.
	 * @param tipoEnemigo Tipo de enemigo
	 * @param xPos Posicion en X del enemigo
	 * @param yPos Posicion en Y del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo del tipo pedido
	 */
	public Enemigo crearEnemigo(TipoEnemigo tipoEnemigo, float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador){
		switch (tipoEnemigo){
			case ARMADO_DEBIL: return getArmadoDebil(xPos, yPos, controlador, jugador);
			case ARMADO: return getArmado(xPos, yPos, controlador, jugador);
			case KAMIKAZE: return getKamikaze(xPos, yPos, controlador, jugador);
			case KAMIKAZE_ALEATORIO: return  getKamikazeAleatorio(xPos, yPos, controlador);
			case KAMIKAZE_MIXTO: return getKamikazeMixto(xPos, yPos, controlador, jugador);
			default: return null;
		}
	}

	/**
	 * Crea un nuevo enemigo Kamikaze con la informacion provista
	 * @param xPos Posicion en X del enemigo
	 * @param yPos Posicion en Y del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo Kamikaze
	 */
	public abstract Enemigo getKamikaze(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador);

	/**
	 * Crea un nuevo enemigo Kamikaze Aleatorio con la informacion provista
	 * @param xPos Posicion en X del enemigo
	 * @param yPos Posicion en Y del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @return Nuevo enemigo Kamikaze Aleatorio
	 */
	public abstract Enemigo getKamikazeAleatorio(float xPos, float yPos, ControladorEnemigo controlador);

	/**
	 * Crea un nuevo enemigo Kamikaze Mixto con la informacion provista
	 * @param xPos Posicion en X del enemigo
	 * @param yPos Posicion en Y del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo Kamikaze Mixto
	 */
	public abstract Enemigo getKamikazeMixto(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador);

	/**
	 * Crea un nuevo enemigo Armado con la informacion provista
	 * @param xPos Posicion en X del enemigo
	 * @param yPos Posicion en Y del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo Armado
	 */
	public abstract Enemigo getArmado(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador);

	/**
	 * Crea un nuevo enemigo Armado Debil con la informacion provista
	 * @param xPos Posicion en X del enemigo
	 * @param yPos Posicion en Y del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo Armado Debil
	 */
	public abstract Enemigo getArmadoDebil(float xPos, float yPos, ControladorEnemigo controlador, GameObject jugador);
	
}
