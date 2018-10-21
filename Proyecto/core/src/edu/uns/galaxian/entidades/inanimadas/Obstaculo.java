package edu.uns.galaxian.entidades.inanimadas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
	
	private static Texture TEXTURA = new Texture(Gdx.files.internal("./obstaculos/asteroideMarron.png"));
	private static final int VIDA_MAX = 300;
	
	private ColisionadorObstaculo colisionador;
	private Controlador controlador;
	private int fuerzaDeColision;
	private InteligenciaArtificial inteligencia;
	private HBCirculo box;
	
	public Obstaculo(float xPos, float yPos, Controlador controlador) {
		super(new Vector2(xPos, yPos), VIDA_MAX,0 );
		this.controlador = controlador;
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 300;
		inteligencia = new InteligenciaNula();
		box = new HBCirculo(this,TEXTURA.getWidth()/5);
	}
	
	public Obstaculo(float xPos, float yPos) {
		super(new Vector2(xPos, yPos), VIDA_MAX, 0);
		colisionador = new ColisionadorObstaculo(this);
		fuerzaDeColision = 100;
		inteligencia = new InteligenciaNula();
		box = new HBCirculo(this,TEXTURA.getWidth()/2);
	}
	
	public int getFuerzaDeColision() {
		return fuerzaDeColision;
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(TEXTURA, posicion.x-(TEXTURA.getWidth()/2), posicion.y-(TEXTURA.getHeight()/2), TEXTURA.getWidth(), TEXTURA.getHeight());
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

	public void setControladorObstaculo(Controlador controlador) {
		this.controlador = controlador;
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
