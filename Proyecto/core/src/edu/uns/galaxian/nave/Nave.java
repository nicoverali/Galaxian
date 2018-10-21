package edu.uns.galaxian.nave;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaNula;

public abstract class Nave {

	protected Arma arma;
	protected Texture textura;

	public Nave(){
		arma = new ArmaNula();
	}

	/**
	 * Retorna el arma de la nave.
	 * @return Arma de la nave
	 */
	public Arma getArma(){
		return arma;
	}

	/**
	 * Reemplaza el arma actual de la nave por una nueva.
	 * @param nuevaArma Nueva arma de la nave
	 */
	public void setArma(Arma nuevaArma){
		arma = nuevaArma;
	}

	/**
	 * Utiliza el batch recibido para dibujar la nave en la posicion proveida.
	 * @param batch Batch utilizado para dibujar en pantalla
	 * @param posicion Posicion donde debe dibujarse la nave
	 */
	public void dibujar(EntidadBatch batch, Vector2 posicion){
		float alto = textura.getHeight();
		float ancho = textura.getWidth();
		batch.draw(textura, posicion.x - ancho/2, posicion.y - alto/2, ancho, alto);
	}

	/**
	 * Retorna la vida maxima de la nave.
	 * @return Vida maxima de la nave
	 */
	public abstract int getVidaMax();

	/**
	 * Retorna la velocidad maxima de la nave.
	 * @return Velocidad maxima de la nave
	 */
	public abstract float getVelocidadMax();

	/**
	 * Retorna la rotacion inicial de la nave.
	 * @return Rotacion inicial de la nave
	 */
	public abstract float getRotacionInicial();
}
