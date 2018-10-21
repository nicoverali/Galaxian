package edu.uns.galaxian.entidades.autonoma.enemigo.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.util.enums.TipoEnemigo;
import edu.uns.galaxian.entidades.status.GameObject;

public abstract class FabricaEnemigos {

	/**
	 * Crea un nuevo enemigo segun la informacion provista.
	 * @param tipoEnemigo Tipo de enemigo
	 * @param posicion Posicion del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo del tipo pedido
	 */
	public Enemigo crearEnemigo(TipoEnemigo tipoEnemigo, Vector2 posicion, Controlador controlador, GameObject jugador){
		switch (tipoEnemigo){
			case ARMADO_DEBIL: return getArmadoDebil(posicion, controlador, jugador);
			case ARMADO: return getArmado(posicion, controlador, jugador);
			case KAMIKAZE: return getKamikaze(posicion, controlador, jugador);
			case KAMIKAZE_ALEATORIO: return  getKamikazeAleatorio(posicion, controlador);
			case KAMIKAZE_MIXTO: return getKamikazeMixto(posicion, controlador, jugador);
			default: return null;
		}
	}

	/**
	 * Crea un nuevo enemigo Kamikaze con la informacion provista
	 * @param posicion Posicion del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo Kamikaze
	 */
	public abstract Enemigo getKamikaze(Vector2 posicion, Controlador controlador, GameObject jugador);

	/**
	 * Crea un nuevo enemigo Kamikaze Aleatorio con la informacion provista
	 * @param posicion Posicion del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @return Nuevo enemigo Kamikaze Aleatorio
	 */
	public abstract Enemigo getKamikazeAleatorio(Vector2 posicion, Controlador controlador);

	/**
	 * Crea un nuevo enemigo Kamikaze Mixto con la informacion provista
	 * @param posicion Posicion del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo Kamikaze Mixto
	 */
	public abstract Enemigo getKamikazeMixto(Vector2 posicion, Controlador controlador, GameObject jugador);

	/**
	 * Crea un nuevo enemigo NaveArmado con la informacion provista
	 * @param posicion Posicion del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo NaveArmado
	 */
	public abstract Enemigo getArmado(Vector2 posicion, Controlador controlador, GameObject jugador);

	/**
	 * Crea un nuevo enemigo NaveArmado Debil con la informacion provista
	 * @param posicion Posicion del enemigo
	 * @param controlador Controlador del cual dependara el enemigo
	 * @param jugador Jugador objetivo del enemigo
	 * @return Nuevo enemigo NaveArmado Debil
	 */
	public abstract Enemigo getArmadoDebil(Vector2 posicion, Controlador controlador, GameObject jugador);
	
}
