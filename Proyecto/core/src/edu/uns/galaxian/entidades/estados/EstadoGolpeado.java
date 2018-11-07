package edu.uns.galaxian.entidades.estados;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.nave.Nave;
import edu.uns.galaxian.observer.livedata.LiveData;
import edu.uns.galaxian.util.EntidadBatch;

public class EstadoGolpeado extends EstadoDibujar {
	
	private static final String TEXTURA_DIR = "naveGolpeada";
	private TextureRegion texturaGolpeada;

	public EstadoGolpeado(EntidadConNave entidad, Nave nave, TextureAtlas altas) {
		super(entidad, nave, altas);
	}

	public void notificar(LiveData<Integer> subject) {
		int vidaCritica = nave.getVidaMax()/3;
		if(subject.getValor()<=vidaCritica) {
			EstadoDibujar nuevoEstado = new EstadoMoribundo(entidad,nave,atlas);
			entidad.cambiarEstado(nuevoEstado);
		}
	}
	
	public void dibujar(EntidadBatch batch) {
		super.dibujar(batch);
		// TODO cuando las texturas esten listas se debe habilitar el siguiente código
		/* 
		if(texturaGolpeada==null) {
			texturaGolpeada = atlas.findRegion(TEXTURA_DIR);
		}
		batch.draw(texturaGolpeada, entidad.getPosicion(), entidad.getRotacion());
		*/
	}

}
