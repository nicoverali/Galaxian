package edu.uns.galaxian.entidades.inanimadas.disparos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.util.EntidadBatch;

public abstract class Disparo extends Entidad {

	protected int fuerzaDeDisparo;
	protected TextureRegion textura;
	protected Controlador controlador;
	protected HBRectangulo box;

	public Disparo(Vector2 posicion, Vector2 velocidad, float rotacion, int fuerzaDeDisparo, String texturaDir, Controlador controlador) {
		super(posicion, velocidad, rotacion);
		this.fuerzaDeDisparo = fuerzaDeDisparo;
		this.textura = controlador.getTextureAtlas(Juego.ATLAS_DISPAROS).findRegion(texturaDir);
		this.controlador = controlador;
		box = new HBRectangulo(this,textura.getRegionHeight(),textura.getRegionWidth());
	}

	public int getFuerzaDeDisparo() {
		return fuerzaDeDisparo;
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion, rotacion);
	}

	public void actualizar(float delta) {
		posicion.add(velocidad);
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y < 0)) {
			eliminar();
		}
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
	}
	
	public HitBox getHitBox() {
		return box;
	}
}
