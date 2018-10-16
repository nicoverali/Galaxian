package edu.uns.galaxian.entidades.autonoma.enemigo;

import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaFormacion;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
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
	
	public Enemigo(int xPos, int yPos, NaveEnemigo nave, ControladorEnemigo controlador){
		this.nave = nave;
		this.controladorEnemigo = controlador;
		this.estado = new StatusMutableVida(new Vector2(xPos,yPos), nave.getRotacionInicial() , nave.getVidaMax());
		this.colisionador = new ColisionadorEnemigo(this);
		inteligencia = new InteligenciaFormacion(estado.getPosicion());
		
		setArma(new ArmaDisparoDoble(new DisparoEnemigo()));
	}

	/**
	 * Retorna el dano que produce este enemigo al colisionar con otra entidad
	 * @return Dano de colision
	 */
	public int getColisionDamage() {
    	return nave.getDamage();
    }

	/**
	 * Cambia el arma actual del enemigo por una nueva.
	 * @param nuevaArma Nueva arma del enemigo
	 */
	public void setArma(Arma nuevaArma) {
		nuevaArma.setDisparoModelo(new DisparoEnemigo());
		nave.setArma(nuevaArma);
	}

	/**
	 * Retorna una coleccion de disparos producidos por el enemigo.
	 * @return Coleccion de disparos producidos
	 */
    public Collection<Disparo> disparar() {
    	Vector2 posicion = estado.getPosicion();
    	float rotacion = estado.getRotacion();
		return nave.getArma().disparar(posicion,rotacion);
	}

    public float getAlto() {
    	return nave.getAlto();
    }

    public float getAncho() {
    	return nave.getAncho();
    }

	public void setVidaAlMaximo() {
		estado.setVida(nave.getVidaMax());
	}

	public void restarVida(int vidaARestar) throws IllegalArgumentException {
		if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida a restar no puede ser negativa.");
		}
		int nuevaVida = estado.getVida() - vidaARestar;
		estado.setVida(Math.max(0, nuevaVida));
	}

	public StatusVida getStatus() {
		return estado;
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}

	public void actualizar(float delta) {
		inteligencia.pensar(estado);
		if(estado.getPosicion().y < 0) {
			estado.setPosicion(new Vector2(estado.getPosicion().x,Gdx.graphics.getHeight()));
		}
	}
    
    public void atacar() {
    	inteligencia = nave.getInteligenciaDeAtaque();
    }

    public void dibujar(SpriteBatch batch) {
    	nave.dibujar(batch, estado.getPosicion());
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


	// TODO Esto es solo de desarrollo
	public void setPosicion(float xPos, float yPos){
    	this.estado.setPosicion(new Vector2(xPos, yPos));
	}
}
