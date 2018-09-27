package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.ControladorDisparo;
import edu.uns.galaxian.entidades.EntidadColisionable;

public abstract class Disparo extends EntidadColisionable  {

	protected int damage;
	protected int velocidad;
	protected Vector2 direccion;
	protected Texture textura;
	private ControladorDisparo controlador;

	public Disparo() {
		super(0, 0, 1);
		damage = 0;
		velocidad = 0;
		direccion = Vector2.Zero;
		textura = null;
	}

	public Disparo(int damage, int velocidad, Vector2 direccion, Texture textura){
		super(0,0,1);
		this.damage = damage;
		this.velocidad = velocidad;
		this.direccion = direccion;
		this.textura = textura;
	}

	public Disparo(int damage, int velocidad, float factor, Vector2 direccion, Texture textura, ControladorDisparo controlador) {
		super(0,0,factor);
		this.damage = damage;
		this.velocidad = velocidad;
		this.direccion = direccion;
		this.textura = textura;
		this.controlador = controlador;
	}
	
	// METODOS ABSTRACTOS
	
	public abstract Disparo clonar();
	
	// METODOS Y CONSULTAS
	
	public int getDamage() {
		return damage;
	}
	
	public int getAlto() {
		return (int) Math.ceil(textura.getHeight() * factorEscala);
	}
	
	public int getAncho() {
		return (int) Math.ceil(textura.getWidth() * factorEscala);
	}
	
	public void setDamage( int damage) {
		this.damage=damage;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
	}

	public void setDireccion(Vector2 v) {
		direccion= v;
	}

	public void setTextura(Texture textura) {
		this.textura=textura;
	}

	public void setControladorDisparo(ControladorDisparo c) {
		controlador = c;
	}

	public void dibujar(SpriteBatch batch) {
		batch.draw(textura, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
	}

	public void actualizar() {
		posicion.add(direccion.x, direccion.y*velocidad*Gdx.graphics.getDeltaTime());
	}

	public void eliminar() {
		controlador.deregistrar(this);
    	//textura.dispose();
	}
	
}
