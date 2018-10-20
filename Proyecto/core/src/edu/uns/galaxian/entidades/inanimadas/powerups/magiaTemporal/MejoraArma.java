package edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;

public class MejoraArma extends PowerUp{

	public MejoraArma(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura=new Texture(Gdx.files.internal("./power_up/things_bronze.png"));
		box = new HBCirculo(this,textura.getWidth()/2);
	}

	public void efectoJugador(Jugador jugador) {
		jugador.setArma(new ArmaDisparoDoble<DisparoJugador>(new FabricaDisparoJugador()));
	}

}
