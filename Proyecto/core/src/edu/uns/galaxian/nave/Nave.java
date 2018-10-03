package edu.uns.galaxian.nave;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.Disparo;

import java.util.Collection;

// TODO ESTA CLASE DEBERIA SER ABSTRACTA

public interface Nave {

	/**
	 * Retorna el arma de la nave.
	 * @return Arma de la nave
	 */
	public Arma getArma();

	/**
	 * Reemplaza el arma actual de la nave por una nueva.
	 * @param nuevaArma Nueva arma de la nave
	 */
	public void setArma(Arma nuevaArma);

	/**
	 * Retorna el escudo de la nave.
	 * @return Escudo de la nave
	 */
	public Escudo getEscudo();

	/**
	 * Reemplaza el escudo actual de la nave por uno nuevo.
	 * @param nuevoEscudo Nuevo escudo de la nave
	 */
	public void setEscudo(Escudo nuevoEscudo);

	/**
	 * Retorna la vida maxima de la nave.
	 * @return Vida maxima de la nave
	 */
	public int getVidaMax();

	/**
	 * Retorna la velocidad maxima de la nave.
	 * @return Velocidad maxima de la nave
	 */
	public float getVelocidadMax();

	/**
	 * Retorna la rotacion inicial de la nave.
	 * @return Rotacion inicial de la nave
	 */
	public float getRotacionInicial();

	/**
	 * Retorna el alto de la nave.
	 * @return Alto de la nave
	 */
	public float getAlto();

	/**
	 * Retorna el ancho de la nave.
	 * @return Ancho de la nave
	 */
	public float getAncho();

	/**
	 * Utiliza el batch recibido para dibujar la nave en la posicion proveida.
	 * @param batch Batch utilizado para dibujar en pantalla
	 * @param posicion Posicion donde debe dibujarse la nave
	 */
	public void dibujar(SpriteBatch batch, Vector2 posicion);
	
}
