package edu.uns.galaxian.entidades.estados;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.nave.Nave;
import edu.uns.galaxian.observer.livedata.LiveData;

public class EstadoSano extends EstadoDibujar {
	
	public EstadoSano(EntidadConNave entidad, Nave nave, TextureAtlas atlas) {
		super(entidad,nave,atlas);
	}

	public void notificar(LiveData<Integer> subject) {
		int vidaMax = nave.getVidaMax();
		int vidaIntermedia = (2*vidaMax)/3;
		int vidaCritica = vidaMax/3;
		if(subject.getValor()<=vidaIntermedia) {
			EstadoDibujar nuevoEstado = new EstadoGolpeado(entidad,nave,atlas);;
			entidad.cambiarEstado(nuevoEstado);
		}
		else if(subject.getValor()<=vidaCritica) {
			EstadoDibujar nuevoEstado = new EstadoMoribundo(entidad,nave,atlas);
			entidad.cambiarEstado(nuevoEstado);
		}
	}

}
