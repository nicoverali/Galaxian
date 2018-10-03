package edu.uns.galaxian.entidades.autonoma.enemigo;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.entidades.status.StatusMutableVida;
import edu.uns.galaxian.entidades.status.StatusVida;
import edu.uns.galaxian.nave.enemigo.NaveEnemigo;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEnemigo;
import edu.uns.galaxian.controladores.ControladorEnemigo;

public class Enemigo implements EntidadViva, Autonomo  {
	
	private NaveEnemigo nave;
	private StatusMutableVida estado;
	
	private ControladorEnemigo controladorEnemigo;
	private ColisionadorEnemigo colisionador;

	private InteligenciaArtificial inteligencia;
	
	public Enemigo(int xPos, int yPos, NaveEnemigo nave)
	{
		estado = new StatusMutableVida(new Vector2(xPos,yPos),nave.getRotacionInicial() ,nave.getVidaMax());
		colisionador = new ColisionadorEnemigo(this);
		this.nave=nave;
	}

    
    // Metodos y consultas
    
    public List<Disparo> disparar() {
    	Vector2 posicion = estado.getPosicion();
    	float rotacion = estado.getRotacion();
		return (List<Disparo>) nave.getArma().disparar(posicion,rotacion);
	}
    
    public int getColisionDamage() {
    	return nave.getDamage();
    }
    
    public float getAlto() {
    	return nave.getAlto();
    }
    
    public float getAncho() {
    	return nave.getAncho();
    }
    
    public void setArma(Arma nuevaArma) {
    	nave.setArma(nuevaArma);
    	nave.getArma().setDisparoModelo(new DisparoEnemigo());
    }
    
    public void setControladorEnemigo(ControladorEnemigo c) {
    	controladorEnemigo = c;
    }

    
	// Implementacion de metodos abstractos

    public void dibujar(SpriteBatch batch) {
    	float posicion_en_x = (estado.getPosicion().x)-(nave.getAncho()/2);
    	float posicion_en_y = (estado.getPosicion().y)-(nave.getAlto()/2);
    	Vector2 posicion_dibujar = new Vector2(posicion_en_x , posicion_en_y);
    	nave.dibujar(batch,posicion_dibujar);
    }

    public void eliminar() {
    	controladorEnemigo.deregistrar(this);
    }
    
	public Colisionador getColisionador(){
		return colisionador;
	}
	
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConEnemigo(this);
	}


	public void actualizar(float d) {
		inteligencia.pensar(estado);
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}


	public void setInteligencia(InteligenciaArtificial i) {
		inteligencia = i;
	}


	public void setVidaAlMaximo() {
		int vida_max = nave.getVidaMax();
		estado.setVida(vida_max);
	}


	public void restarVida(int vidaARestar) throws IllegalArgumentException {
		if(vidaARestar>=0) {
			estado.setVida(vidaARestar);
		}
		else throw new IllegalArgumentException("ERROR AL RESTAR VIDA");
	}


	public StatusVida getStatus() {
		return estado;
	}
	
}
