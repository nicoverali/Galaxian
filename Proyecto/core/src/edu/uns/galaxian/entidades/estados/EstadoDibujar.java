package edu.uns.galaxian.entidades.estados;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.nave.Nave;
import edu.uns.galaxian.observer.Observador;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.EntidadBatch;

public abstract class EstadoDibujar implements Observador<LiveData<Integer>> {
	
	protected EntidadConNave entidad;
	protected Nave nave;
	protected TextureAtlas atlas;
	protected TextureRegion textura;
	
	public EstadoDibujar(EntidadConNave entidad, Nave nave, TextureAtlas atlas) {
		this.entidad = entidad;
		this.nave = nave;
		this.atlas = atlas;
		textura = null;
		entidad.getVida().observar(this);
	}
	
	public void dibujar(EntidadBatch batch) {
		if(textura==null) {
			textura = atlas.findRegion(nave.getTexturaDir());
		}
		batch.draw(textura, entidad.getPosicion(), entidad.getRotacion());
	}

}
