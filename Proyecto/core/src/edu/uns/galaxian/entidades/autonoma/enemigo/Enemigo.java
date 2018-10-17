package edu.uns.galaxian.entidades.autonoma.enemigo;

import java.util.Collection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaFormacion;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.nave.enemigo.NaveEnemigo;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEnemigo;
import edu.uns.galaxian.controladores.ControladorEnemigo;

public class Enemigo extends EntidadViva implements Autonomo  {
	
	private NaveEnemigo nave;
	private ControladorEnemigo controladorEnemigo;
	private ColisionadorEnemigo colisionador;
	private InteligenciaArtificial inteligencia;
	
	public Enemigo(int xPos, int yPos, NaveEnemigo nave, ControladorEnemigo controlador){
		super(new Vector2(xPos, yPos), nave.getRotacionInicial(), nave.getVidaMax());
		this.nave = nave;
		this.controladorEnemigo = controlador;
		this.colisionador = new ColisionadorEnemigo(this);
		inteligencia = new InteligenciaFormacion(posicion);
		
		setArma(new ArmaDisparoDoble<DisparoEnemigo>(new DisparoEnemigo()));
	}

	/**
	 * Retorna fuerza con la que colisiona este enemigo con otra entidad.
	 * @return Fuerza de colision
	 */
	public int getFuerzaDeColision() {
    	return nave.getDamage();
    }

	/**
	 * Cambia el arma actual del enemigo por una nueva.
	 * @param nuevaArma Nueva arma del enemigo
	 */
	public void setArma(Arma<DisparoEnemigo> nuevaArma) {
		nave.setArma(nuevaArma);
	}

	/**
	 * Retorna una coleccion de disparos producidos por el enemigo.
	 * @return Coleccion de disparos producidos
	 */
    public Collection<Disparo> disparar() {
		return nave.getArma().disparar(posicion.cpy() ,rotacion);
	}

    public float getAlto() {
    	return nave.getAlto();
    }

    public float getAncho() {
    	return nave.getAncho();
    }

	public void setVidaAlMaximo() {
		vida.setValor(nave.getVidaMax());
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}

	public void actualizar(float delta) {
		inteligencia.pensar(this);
		if(posicion.y < 0) {
			posicion.y = Gdx.graphics.getHeight();
		}
	}
    
    public void atacar() {
    	inteligencia = nave.getInteligenciaDeAtaque();
    }

    public void dibujar(EntidadBatch batch) {
    	nave.dibujar(batch, posicion);
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
}
