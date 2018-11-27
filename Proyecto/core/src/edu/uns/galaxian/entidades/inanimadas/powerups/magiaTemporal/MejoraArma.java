package edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.util.enums.Asset;

public class MejoraArma extends PowerUp {

	public MejoraArma(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura = controlador.getTextureAtlas(Asset.ATLAS_POWERUP.valor()).findRegion("powerup/mejoraArma");
		box = new HBCirculo(this,textura.getRegionWidth()/2);
	}

	public void efectoJugador(Jugador jugador) {
		controlador.eliminarColisionable(this);
		Arma<DisparoJugador> armaMejorada = new ArmaDisparoDoble<DisparoJugador>(new FabricaDisparoJugador(jugador),15);
		jugador.setArma(armaMejorada);
		eliminar();
	}

}