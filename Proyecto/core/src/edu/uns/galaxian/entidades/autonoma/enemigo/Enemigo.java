package edu.uns.galaxian.entidades.autonoma.enemigo;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.autonoma.EntidadAutonoma;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEnemigo;
import edu.uns.galaxian.controladores.ControladorEnemigo;

public class Enemigo extends EntidadAutonoma {
	
	private Arma arma;
    private Texture textura;
    private int colisionDamage;
	private ControladorEnemigo controladorEnemigo;
	private ColisionadorEnemigo colisionador = new ColisionadorEnemigo(this);

    public Enemigo(int xPos, int yPos, float factorEscala, int vidaMaxima, Texture textura, int colisionDamage, Arma arma, InteligenciaArtificial ia) {
        super(xPos, yPos, factorEscala, vidaMaxima, ia);
        this.textura = textura;
        this.colisionDamage = colisionDamage;
    }

    public Enemigo(int xPos, int yPos, int vidaMaxima, Texture textura, int colisionDamage, Arma arma, InteligenciaArtificial ia){
        super(xPos, yPos, 1, vidaMaxima, ia);
        this.textura = textura;
        this.arma = arma;
        this.arma.setDisparoModelo(new DisparoEnemigo());
        this.colisionDamage = colisionDamage;
    }

    public Enemigo(int xPos, int yPos, int vidaMaxima, Texture textura, int colisionDamage, InteligenciaArtificial ia){
        super(xPos, yPos, 1, vidaMaxima, ia);
        this.textura = textura;
        this.arma = new ArmaComun(new DisparoEnemigo());
        this.colisionDamage = colisionDamage;
    }

    public Enemigo(int xPos, int yPos, int vidaMaxima, int colisionDamage, Texture texture){
        super(xPos, yPos, 1, vidaMaxima);
        this.textura = texture;
        this.arma = new ArmaComun(new DisparoEnemigo());
        this.colisionDamage = colisionDamage;
    }
    
    // Metodos y consultas
    
    public List<Disparo> disparar() {
		return arma.disparar((int)posicion.x, (int)posicion.y, new Vector2(0,-1));
	}
    
    public int getColisionDamage() {
    	return colisionDamage;
    }
    
    public int getAlto() {
    	return (int) Math.ceil(textura.getHeight() * factorEscala);
    }
    
    public int getAncho() {
    	return (int) Math.ceil(textura.getWidth() * factorEscala);
    }
    
    public void setArma(Arma nuevaArma) {
    	arma = nuevaArma;
    	arma.setDisparoModelo(new DisparoEnemigo());
    }
    
    public void setControladorEnemigo(ControladorEnemigo c) {
    	controladorEnemigo = c;
    }

    
	// Implementacion de metodos abstractos

    public void actualizar() {

    }

    public void dibujar(SpriteBatch batch) {
    	batch.draw(textura, posicion.x-getAncho()/2, posicion.y-getAlto()/2, getAncho(), getAlto());
    }

    public void eliminar() {
    	controladorEnemigo.deregistrar(this);
    	textura.dispose();
    }
    
	public Colisionador getColisionador(){
		return colisionador;
	}
	
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConEnemigo(this);
	}
	
}
