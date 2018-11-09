package edu.uns.galaxian.entidades.inanimadas.disparos;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.ColisionadorDisparoEspecial;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.BlackHole;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.util.EntidadBatch;

public class DisparoEspecial extends DisparoJugador{

	public DisparoEspecial(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, 
						   String texturaDir, Controlador controlador, Jugador jugador) 
	{
		super(posicion, velocidad, rotacion, fuerzaDeDisparo, texturaDir, controlador,jugador);
		Arma<DisparoJugador> armaNormal = new ArmaComun<DisparoJugador>(new FabricaDisparoJugador(jugador));
		jugador.setArma(armaNormal);
		colisionador = new ColisionadorDisparoEspecial(this);
	}
	
	public void efecto() {
		BlackHole blackHole = new BlackHole(posicion.x,posicion.y,controlador);
		controlador.agregarEntidad(blackHole);
	}
	
	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion, rotacion);
	}
	
}