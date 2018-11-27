package edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.util.enums.Asset;

public class CampoDeProteccion extends PowerUp {
	
	public CampoDeProteccion(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		textura = controlador.getTextureAtlas(Asset.ATLAS_POWERUP.valor()).findRegion("powerup/campoProteccion");
		box = new HBRectangulo(this,textura.getRegionHeight(),textura.getRegionWidth());
	}

	public void efectoJugador(Jugador jugador) {
		Escudo escudo = new Escudo(jugador,controlador);
		controlador.agregarEntidad(escudo);
		this.eliminar();
	}

}
