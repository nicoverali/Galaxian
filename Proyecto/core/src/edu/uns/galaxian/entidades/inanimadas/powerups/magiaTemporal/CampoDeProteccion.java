package edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class CampoDeProteccion extends PowerUp {

	private Escudo escudo;
	
	public CampoDeProteccion(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura = controlador.getTextureAtlas().findRegion("powerup/campoProteccion");
		box = new HBCirculo(this,textura.getRegionWidth()/2);
	}

	@Override
	public void efectoJugador(Jugador jugador) {
		escudo= new Escudo(jugador,controlador);
		controlador.agregarEntidad(escudo);
	}

}
