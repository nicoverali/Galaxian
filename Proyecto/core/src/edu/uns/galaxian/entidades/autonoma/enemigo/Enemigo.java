package edu.uns.galaxian.entidades.autonoma.enemigo;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.EntidadAutonoma;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.entidades.status.StatusMutableVida;
import edu.uns.galaxian.nave.enemigo.NaveEnemigo;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEnemigo;
import edu.uns.galaxian.controladores.ControladorEnemigo;

public class Enemigo implements EntidadViva, Autonomo  {
	
	private NaveEnemigo nave;
	private StatusMutableVida estado;
	
	private ControladorEnemigo controladorEnemigo;
	private ColisionadorEnemigo colisionador;

	public Enemigo(int xPos, int yPos, NaveEnemigo nave)
	{
		estado= new StatusMutableVida(new Vector2(xPos,yPos),nave.getRotacionInicial() ,nave.getVidaMax());
		colisionador = new ColisionadorEnemigo(this);
		this.nave=nave;
	}

    
    // Metodos y consultas
    
    public List<Disparo> disparar() {
    	Vector2 posicion = estado.getPosicion();
		return nave.getArma().disparar(posicion.x, posicion.y, estado.getVelocidad().nor());
	}
    
    public int getColisionDamage() {
    	return nave.getDamage();
    }
    
    public float getAlto() {
    	return (int) Math.ceil(textura.getHeight() * factorEscala);
    }
    
    public float getAncho() {
    	return nave.get;
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
