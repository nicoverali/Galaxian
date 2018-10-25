package edu.uns.galaxian.ia.inteligencias;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.InteligenciaArtificial;

public class InteligenciaFormacion<T extends Autonomo> implements InteligenciaArtificial<T> {
	
	private static final long CADENCIA_MOVIMIENTO = 15;
	private long ultimoMovimiento;
	private float posX_formacion;
	private float posY_formacion;
	private float argumento;
	private T autonomo;
	
	public InteligenciaFormacion(T autonomo, Vector2 posInicial) {
		this.autonomo = autonomo;
		ultimoMovimiento = System.currentTimeMillis() - CADENCIA_MOVIMIENTO;
		posX_formacion = posInicial.x;
		posY_formacion = posInicial.y;
		float PI = (float) Math.PI;
		argumento = PI/60;
	}

	public void pensar(float delta) {
		if(TimeUtils.timeSinceMillis(ultimoMovimiento) > CADENCIA_MOVIMIENTO) {
			float nuevaPos_X = (float)(30*Math.cos(argumento)+posX_formacion);
			float nuevaPos_Y = (float)(30*Math.sin(argumento)+posY_formacion);
			Vector2 nuevaPos = new Vector2(nuevaPos_X, nuevaPos_Y);
			autonomo.setPosicion(nuevaPos);
			argumento += Math.PI/60;
			ultimoMovimiento = TimeUtils.millis();
		}
	}

}
