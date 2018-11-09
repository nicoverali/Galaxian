package edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoJugador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.util.temporizador.TemporizadorManual;

public class MejoraArma extends PowerUp {
	
	private static float TIEMPO_EFECTO = 5;
	private TemporizadorManual temporizador;
	private Jugador jugadorBeneficiado;
	private Arma<DisparoJugador> armaGuardada;

	public MejoraArma(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura = controlador.getTextureAtlas().findRegion("powerup/mejoraArma");
		box = new HBCirculo(this,textura.getRegionWidth()/2);
	}

	public void efectoJugador(Jugador jugador) {
		setVelocidad(new Vector2(0,0));
		controlador.eliminarColisionable(this);
		temporizador = new TemporizadorManual(TIEMPO_EFECTO);
		jugadorBeneficiado = jugador;
		armaGuardada = jugador.getArma();
		Arma<DisparoJugador> armaMejorada = new ArmaDisparoDoble<DisparoJugador>(new FabricaDisparoJugador(jugador));
		jugador.setArma(armaMejorada);
	}
	
	public void actualizar(float delta) {
		posicion.add(velocidad);
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0) || posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
			eliminar();
		}
		if(temporizador!=null) {
			temporizador.contarTiempo(delta);
			if(temporizador.tiempoCumplido()) {
				jugadorBeneficiado.setArma(armaGuardada);
				eliminar();
			}
		}
	}
	
	public void dibujar(EntidadBatch batch) {
		if(jugadorBeneficiado==null) {
			super.dibujar(batch);
		}
	}

}