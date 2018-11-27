package edu.uns.galaxian.entidades.inanimadas.powerups.objetoPrecioso;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.actualizadores.VisitorJuegoCongelado;
import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.controlador.Caller;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.util.enums.Asset;
import edu.uns.galaxian.util.temporizador.TemporizadorManual;
import edu.uns.galaxian.juego.Juego;

public class CongelaTiempo extends PowerUp implements Caller {
	
	private static float TIEMPO_EFECTO = 4;
	private TemporizadorManual temporizador;

	public CongelaTiempo(Vector2 posicion, Vector2 velocidad, float rotacion, Controlador controlador) {
		super(posicion, velocidad, rotacion, controlador);
		this.textura = controlador.getTextureAtlas(Asset.ATLAS_POWERUP.valor()).findRegion("powerup/congelaTiempo");
		box = new HBRectangulo(this,textura.getRegionHeight(),textura.getRegionWidth());
	}

	public void efectoJugador(Jugador jugador) {
		setVelocidad(new Vector2(0,0));
		controlador.eliminarColisionable(this);
		temporizador = new TemporizadorManual(TIEMPO_EFECTO);
		Visitor congelador = new VisitorJuegoCongelado();
		controlador.setActualizacion(congelador,this);
	}
	
	public void actualizar(float delta) {
		posicion.add(velocidad);
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0) || posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
			eliminar();
		}
		if(temporizador!=null) {
			temporizador.contarTiempo(delta);
			if(temporizador.tiempoCumplido()) {
				controlador.restaurar(this);
				eliminar();
			}
		}
	}
	
	public void dibujar(EntidadBatch batch) {
		if(temporizador==null) {
			super.dibujar(batch);
		}
	}

}