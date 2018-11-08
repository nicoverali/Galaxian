package edu.uns.galaxian.entidades.estados;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.nave.Nave;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.EntidadBatch;

public class EstadoMoribundo extends EstadoDibujar {
	
	private static final String TEXTURA_DIR = "naveMoribunda";
	private TextureRegion texturaMoribunda;

	public EstadoMoribundo(EntidadConNave entidad, Nave nave, TextureAtlas altas) {
		super(entidad, nave, altas);
	}

	public void notificar(LiveData<Integer> subject) {
		// Una vez llegado a este estado, no se debe cambiar la textura.
		// Es el ultimo estado para dibujar de la entidad.
	}
	
	public void dibujar(EntidadBatch batch) {
		super.dibujar(batch);
		// TODO cuando las texturas esten listas se debe habilitar el siguiente codigo
		/*
		if(texturaMoribunda==null) {
			texturaMoribunda = atlas.findRegion(TEXTURA_DIR);
		}
		batch.draw(texturaMoribunda, entidad.getPosicion(), entidad.getRotacion());
		*/
	}

}
