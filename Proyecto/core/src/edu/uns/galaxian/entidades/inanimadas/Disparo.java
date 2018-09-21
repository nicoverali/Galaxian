package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.controladores.ControladorDisparo;
import edu.uns.galaxian.entidades.EntidadColisionable;

public abstract class Disparo extends EntidadColisionable  {

	private int damage;
	private int velocidad;
	private Vector2 direccion;
	private Texture textura;
	private ControladorDisparo controlador;

	// TODO estos atributos debrian estar aqui realmente?
	private int ancho;
	private int alto;

	public Disparo() {
		super(0,0,1);
		damage=0;
		velocidad=0;
		direccion=null;
		textura=null;
	}

	public Disparo(int damage, int velocidad, float factor, Texture textura) {
		super(0,0,factor);
		this.damage = damage;
		this.velocidad = velocidad;
		this.direccion = new Vector2(0,0);
		this.textura = textura;
		this.alto = (int) Math.floor(textura.getHeight() * factorEscala)-30;
	    this.ancho = (int) Math.floor(textura.getWidth() * factorEscala);
	}

	public Disparo(int damage, int velocidad, Vector2 direccion, Texture textura){
		super(0,0,1);
		this.damage= damage;
		this.velocidad= velocidad;
		this.direccion= direccion;
		this.textura=textura;
		this.alto = (int) Math.floor(textura.getHeight() * factorEscala);
	    this.ancho = (int) Math.floor(textura.getWidth() * factorEscala);
	}
	
	// METODOS ABSTRACTOS
	
	public abstract Disparo clonar();
	
	public abstract void aceptarColision(Colisionador colisionador);
	
	public abstract Colisionador getColisionador();
	
	
	// METODOS Y CONSULTAS
	
	public int getDamage() {
		return damage;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public float getFactor() {
		return factorEscala;
	}
	
	public Vector2 getDireccion() {
		return direccion;
	}
	
	public Texture getTextura() {
		return textura;
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
