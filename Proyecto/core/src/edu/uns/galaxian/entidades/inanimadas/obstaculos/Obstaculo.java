package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.colisionadores.ColisionadorObstaculo;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.ia.autonomo.Autonomo;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.inteligencias.basica.InteligenciaNula;

public abstract class Obstaculo extends EntidadViva implements Autonomo {
	
	private static final int VIDA_MAX = 500;

	protected ColisionadorObstaculo colisionador;
	protected TextureRegion textura;
	protected Controlador controlador;
	protected HBCirculo box;
	protected InteligenciaArtificial<Obstaculo> inteligencia;
	protected int fuerzaDeColision;

	public Obstaculo(float xPos, float yPos, String TEXTURA_DIR, Controlador controlador) {
		super(new Vector2(xPos, yPos), VIDA_MAX,0);
		this.controlador = controlador;
		fuerzaDeColision = 100;
		colisionador = new ColisionadorObstaculo(this);
		inteligencia = new InteligenciaNula<Obstaculo>(this);
		textura = controlador.getTextureAtlas(Juego.ATLAS_OBSTACULOS).findRegion(TEXTURA_DIR);
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
		inteligencia.pensar(d);
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
	}

	public void setVidaAlMaximo() {
		vida.setValor(VIDA_MAX);
	}

	public void aceptarVisitor(Visitor colisionador) {
		colisionador.visitObstaculo(this);
	}

	public Visitor getColisionador() {
		return colisionador;
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(InteligenciaArtificial i) {
		inteligencia = i;
	}

	public void transicionarInteligencia(InteligenciaArtificial ia) {
		inteligencia.transicionar(ia);
	}

	public HitBox getHitBox() {
		return box;
	}
}
