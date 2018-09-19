package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.Colisionador;
import edu.uns.galaxian.entidades.EntidadColisionable;

public class Disparo extends EntidadColisionable  {

	private int damage;
	private int velocidad;
	private Vector2 direccion;
	private Texture textura;
	
	public Disparo() {
		damage=0;
		velocidad=0;
		direccion=null;
		textura=null;
	}
	
	public Disparo(Vector2 direccion) {
		damage=0;
		velocidad=0;
		this.direccion=direccion;
		textura=null;
	}
	
	public Disparo(int damage, int velocidad, Vector2 direccion, Texture textura){
		this.damage= damage;
		this.velocidad= velocidad;
		this.direccion= direccion;
		this.textura=textura;
	}
	/**
	 * Devuelve el danio asociado al disparo.
	 * @return Danio que provoca el disparo.
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Setea el danio nuevo
	 */
	public void setDamage( int damage) {
		this.damage=damage;
	}
	
	/**
	 * Setea la velocidad nueva
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
	}
	
	/**
	 * Setea la direccion nueva
	 */
	public void setDireccion(Vector2 v) {
		direccion= v;
	}
	
	/**
	 * Setea la textura nueva
	 */
	public void setTextura(Texture textura) {
		this.textura=textura;
	}
	
	/**
	 * Retorna una copia del disparo con sus atributos 
	 * @return copia del disparo
	 */
	public Disparo clonar() {
		return new Disparo (damage, velocidad, direccion, textura);
	}

	@Override
	public Colisionador getColisionador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAlto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAncho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dibujar(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}
	
}
