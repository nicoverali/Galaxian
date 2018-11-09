package edu.uns.galaxian.entidades.inanimadas.disparos.fabrica;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEspecial;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class FabricaEspecial extends FabricaDisparoJugador {
	
	public FabricaEspecial(Jugador jugador) {
		super(jugador);
	}
	
    public DisparoJugador crearDisparo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, String texturaDir, Controlador controlador) {
        return new DisparoEspecial(posicion, velocidad, rotacion, fuerzaDeDisparo, texturaDir, controlador, jugador);
    }

}