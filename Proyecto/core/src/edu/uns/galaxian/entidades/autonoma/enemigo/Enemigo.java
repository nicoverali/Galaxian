package edu.uns.galaxian.entidades.autonoma.enemigo;

import java.util.Collection;
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
	
	public Enemigo(int xPos, int yPos, NaveEnemigo nave, ControladorEnemigo controlador){
		this.nave = nave;
		this.controladorEnemigo = controlador;
		this.estado = new StatusMutableVida(new Vector2(xPos,yPos), nave.getRotacionInicial() , nave.getVidaMax());
		this.colisionador = new ColisionadorEnemigo(this);
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

    @Override
    public float getAlto() {
    	return nave.getAlto();
    }

    @Override
    public float getAncho() {
    	return nave.getAncho();
    }

	@Override
	public void setVidaAlMaximo() {
		estado.setVida(nave.getVidaMax());
	}

	@Override
	public void restarVida(int vidaARestar) throws IllegalArgumentException {
		if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida a restar no puede ser negativa.");
		}
		int nuevaVida = estado.getVida() - vidaARestar;
		estado.setVida(Math.max(0, nuevaVida));
	}

	@Override
	public StatusVida getStatus() {
		return estado;
	}

	@Override
	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	@Override
	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}

    @Override
	public void actualizar(float d) {
		inteligencia.pensar(estado);
	}

    @Override
    public void dibujar(SpriteBatch batch) {
    	nave.dibujar(batch, estado.getPosicion());
    }

    @Override
    public void eliminar() {
    	controladorEnemigo.deregistrar(this);
    }

    @Override
	public Colisionador getColisionador(){
		return colisionador;
	}

	@Override
	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConEnemigo(this);
	}
}
