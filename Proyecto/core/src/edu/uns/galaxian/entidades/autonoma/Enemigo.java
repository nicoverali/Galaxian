package edu.uns.galaxian.entidades.autonoma;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.uns.galaxian.entidades.equipamiento.*;
import edu.uns.galaxian.entidades.inanimadas.*;
import edu.uns.galaxian.controladores.ControladorEnemigo;
public class Enemigo extends EntidadAutonoma{

	private ControladorEnemigo controlador;
	private Arma arma;

    public Enemigo(int xPos, int yPos, int alto, int ancho, int vidaMaxima) {
        super(xPos, yPos, alto, ancho, vidaMaxima);
    }

    /**
	 * Setea el arma del enemigo con la nueva pasada como par�metro.
	 * @param nuevaArma Nueva arma que tendr� el enemigo.
	 */
	public void setArma(Arma nuevaArma) {
		arma = nuevaArma;
	}
	
	/**
	 * Devuelve el arma que el enemigo posee actualmente.
	 * @return Arma que posee el enemigo.
	 */
	public Arma getArma() {
		return arma;
	}
	
	/**
	 * Devuelve un nuevo disparo realizado por el enemigo.
	 * @return Disparo realizado por el enemigo.
	 */
	public List<Disparo> disparar() {
		return arma.disparar();
	}

	// Implementacion de metodos abstractos
    // TODO Implementar metodos
    @Override
    public void actualizar() {

    }

    @Override
    public void dibujar(SpriteBatch batch) {

    }

    @Override
    public void eliminar() {

    }
}
