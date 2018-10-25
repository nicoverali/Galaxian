package edu.uns.galaxian.ia.inteligencias.basica;

import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.autonomo.Autonomo;

public class InteligenciaNula<T extends Autonomo> implements InteligenciaArtificial<T> {

	private T autonomo;

	public InteligenciaNula(T autonomo){
		this.autonomo = autonomo;
	}

	public void pensar(float delta) {
		// No hacer nada
	}

	public void transicionar(InteligenciaArtificial<T> nuevaInteligencia) {
		autonomo.setInteligencia(nuevaInteligencia);
	}
}
