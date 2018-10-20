package edu.uns.galaxian.entidades;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.observer.livedata.LiveDataMutable;

public abstract class EntidadViva extends Entidad {

	protected LiveDataMutable<Integer> vida;

	public EntidadViva(Vector2 posicion, Vector2 velocidad, float rotacion, int vida){
		super(posicion, velocidad, rotacion);
		this.vida = new LiveDataMutable<>(vida);
	}

	public EntidadViva(Vector2 posicion, int vida, float rotacion){
		this(posicion, new Vector2(0, 0), rotacion, vida);
	}

	public EntidadViva(){
		this(new Vector2(0, 0), 0, 1);
	}

	/**
	 * Devuelve la vida actual de la entidad encapsulada
	 * en un LiveData.
	 * @return Vida actual de la entidad
	 */
	public LiveData<Integer> getVida(){
		return vida;
	}

	/**
	 * Resta a la vida actual de la entidad, la cantidad de vida recibida. Si al restar la vida,
	 * esta resulta ser 0 o menos, la entidad es eliminada del juego.
	 * @param vidaARestar Cantidad de vida que se desea restar
	 * @throws IllegalArgumentException Si la vida recibida es negativa
	 */
	public void restarVida(int vidaARestar) throws IllegalArgumentException{
		if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida a restar no puede ser negativa.");
		}
		int nuevaVida = vida.getValor() - vidaARestar;
		vida.setValor(Math.max(0, nuevaVida));
		if(vida.getValor() == 0){
			this.eliminar();
		}
	}

	/**
	 * Setea la vida de la entidad al maximo permitido.
	 */
	abstract public void setVidaAlMaximo();
}
