package edu.uns.galaxian.entidades.autonoma;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.equipamiento.*;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEnemigo;
import edu.uns.galaxian.controladores.ControladorEnemigo;

public class Enemigo extends EntidadAutonoma{
	
	private static final int FACTOR_ESCALA = 1;
	
	private Arma arma;
	private int alto;
	private int ancho;

	private Texture textura;
	private ControladorEnemigo controladorEnemigo;
	private ColisionadorEnemigo colisionador;

    public Enemigo(int xPos, int yPos, int vidaMaxima, Texture textura) {
        super(xPos, yPos, FACTOR_ESCALA, vidaMaxima);
        this.textura = textura;
        this.alto = (int) Math.floor(textura.getHeight() * factorEscala)-55;
        this.ancho = (int) Math.floor(textura.getWidth() * factorEscala)-65;
        colisionador = new ColisionadorEnemigo(this);
    }

	// Implementacion de metodos abstractos

    public void actualizar() {

    }

    public void dibujar(SpriteBatch batch) {
    	batch.draw(textura, posicion.x-getAncho()/2, posicion.y-getAlto()/2, getAncho(), getAlto());
    }
    
    public void restarVida(int vidaARestar) throws IllegalArgumentException {
    	if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida que se quiere restar no puede ser negativa.");
		}
		setVida(Math.max(0, getVida() - vidaARestar));
    }

    public void eliminar() {
    	controladorEnemigo.deregistrar(this);
    	textura.dispose();
    }
    
    // METODOS Y CONSULTAS
    
    public List<Disparo> disparar() {
		return arma.disparar((int)posicion.x, (int)posicion.y, new Vector2(0,-1));
	}
    
    public Arma getArma() {
    	return arma;
    }
    
    public static int getFactorEscala() {
    	return FACTOR_ESCALA;
    }
    
    public int getColisionDamage() {
    	return 0;
    }
    
    public int getAlto() {
    	return alto;
    }
    
    public int getAncho() {
    	return ancho;
    }
    
    public void setArma(Arma nuevaArma) {
    	arma = nuevaArma;
    }
    
    public void setControladorEnemigo(ControladorEnemigo c) {
    	controladorEnemigo = c;
    }
    
	public Colisionador getColisionador(){
		return colisionador;
	}
	
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConEnemigo(this);
	}
	
}
