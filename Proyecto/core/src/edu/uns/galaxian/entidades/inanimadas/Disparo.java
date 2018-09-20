package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.controladores.ControladorDisparo;
import edu.uns.galaxian.entidades.EntidadColisionable;

public class Disparo extends EntidadColisionable  {

	private int damage;
	private int velocidad;
	private Vector2 direccion;
	private Texture textura;
	private Colisionador colisionadorDisparo;
	private ControladorDisparo controlador;

	// TODO estos atributos debrian estar aqui realmente?
	private int ancho;
	private int alto;

	public Disparo() {
		damage=0;
		velocidad=0;
		direccion=null;
		textura=null;
	}

	public Disparo(int damage, int velocidad, int factor, Texture textura) {
		this.damage = damage;
		this.velocidad = velocidad;
		direccion = new Vector2(0,0);
		this.textura=textura;
		this.alto = (int) Math.floor(textura.getHeight() * factorEscala);
	    this.ancho = (int) Math.floor(textura.getWidth() * factorEscala);
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
		Disparo nuevo = new Disparo (damage, velocidad, direccion, textura);
		nuevo.setPosicion(posicion);
		return nuevo;
	}
	
	public void setControladorDisparo(ControladorDisparo c) {
		controlador = c;
	}

	public void setColisionador(Colisionador colisionador) {
		colisionadorDisparo = colisionador;
	}

	@Override
	public Colisionador getColisionador() {
		colisionadorDisparo.setObjetoFuente(this);
		return colisionadorDisparo;
	}

	@Override
	public int getAlto() {
		return 30;
	}

	@Override
	public int getAncho() {
		return 30;
	}

	@Override
	public void dibujar(SpriteBatch batch) {
		// TODO ver tama�o del disparo (se modifico solo para graficar, despues se debe borrar el -5)
		batch.draw(textura, posicion.x-((getAncho()-10)/2), posicion.y-getAlto()/2, getAncho()-20, getAlto()-6);
	}

	@Override
	public void actualizar() {
		posicion.add(direccion.x, direccion.y*velocidad*Gdx.graphics.getDeltaTime());
	}

	@Override
	public void eliminar() {
		controlador.deregistrar(this);
    	//textura.dispose();
	}

	@Override
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConDisparo(this);
	}
}
