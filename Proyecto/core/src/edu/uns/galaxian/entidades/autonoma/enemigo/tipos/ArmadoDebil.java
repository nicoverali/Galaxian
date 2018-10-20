package edu.uns.galaxian.entidades.autonoma.enemigo.tipos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.status.GameObject;

public class ArmadoDebil extends Enemigo {

	private static final String TEXTURA_DIR = "./enemigos/armado_debil/estandar.png";

	private int vidaMax;
	private float velocidadMax;
	private int colisionDamage;
	// TODO Crear inteligencia del kamikaze y asignarsela a esta nave de manera fija
	private InteligenciaArtificial inteligenciaDeAtaque;
	
	private static Texture textura= new Texture(Gdx.files.internal(TEXTURA_DIR));
	
	//TODO fijarse el estadoJugador no esta asignado a nada, mandarlo a la inteligencia
	public ArmadoDebil(Vector2 pos, int vida, float velocidadMax, int colisionDamage, Controlador controlador, GameObject estadoJugador) {
		super(pos, vida, textura,controlador);
		vidaMax=vida;
		this.velocidadMax=velocidadMax;
		this.colisionDamage=colisionDamage;
	}
	
	public int getVidaMax() {
		return vidaMax;
	}

	public float getVelocidadMax() {
		return velocidadMax;
	}

	public float getRotacionInicial() {
		return 270;
	}

	public int getDamage() {
		return colisionDamage;
	}

	public InteligenciaArtificial getInteligenciaDeAtaque() {
		return inteligenciaDeAtaque;
	}

	@Override
	public int getFuerzaDeColision() {
		// TODO Auto-generated method stub
		return colisionDamage;
	}
	
}
