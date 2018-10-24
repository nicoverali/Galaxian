package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorObstaculo;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaNula;

public class Obstaculo extends EntidadViva implements Autonomo {
	
	private static final String TEXTURA_DIR = "obstaculo/meteoro1";
	private static final int VIDA_MAX = 300;

	private TextureRegion textura;
	private int fuerzaDeColision;
	private Controlador controlador;
	private HBCirculo box;
	private InteligenciaArtificial inteligencia;
	private ColisionadorObstaculo colisionador;

	public Obstaculo(float xPos, float yPos, Controlador controlador) {
		super(new Vector2(xPos, yPos), VIDA_MAX,0 );
		this.controlador = controlador;
		textura = controlador.getTextureAtlas().findRegion(TEXTURA_DIR);
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 300;
		inteligencia = new InteligenciaNula();
		box = new HBCirculo(this,textura.getRegionWidth()/2);
	}
	
	public Obstaculo(float xPos, float yPos) {
		super(new Vector2(xPos, yPos), VIDA_MAX, 0);
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 100;
		inteligencia = new InteligenciaNula();
		box = new HBCirculo(this,textura.getRegionWidth()/2);
	}
	
	public int getFuerzaDeColision() {
		return fuerzaDeColision;
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion, rotacion);
	}

	public void actualizar(float d) {
		if((posicion.y > Gdx.graphics.getHeight()) || (posicion.y<0) || posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
			restarVida(getVida().getValor());
		}
		inteligencia.pensar(this);
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
	}

	public void setVidaAlMaximo() {
		vida.setValor(VIDA_MAX);
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConObstaculo(this);
	}

	public Colisionador getColisionador() {
		return colisionador;
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(InteligenciaArtificial i) {
		inteligencia = i;
	}

	public HitBox getHitBox() {
		return box;
	}
}
