package edu.uns.galaxian.entidades.inanimadas.obstaculos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorObstaculo;
import edu.uns.galaxian.colision.colisionadores.ColisionadorObstaculoEnemigo;
import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaNula;
import edu.uns.galaxian.util.EntidadBatch;

public class ObstaculoEnemigo extends EntidadViva implements Autonomo {

	private static final int VIDA_MAX = 150;
	
	private int fuerzaDeColision;
	
	private Texture textura;
	private Controlador controlador;
	//TODO hacer lo del box
	private HBCirculo box;
	private InteligenciaArtificial inteligencia;
	private ColisionadorObstaculoEnemigo colisionador;
	
	public ObstaculoEnemigo(float xPos, float yPos){
		super(new Vector2(xPos, yPos), VIDA_MAX, 0);
		colisionador = new ColisionadorObstaculoEnemigo(this);
		fuerzaDeColision = 100;
		inteligencia = new InteligenciaNula();
	}
	
	
	public ObstaculoEnemigo(float xPos, float yPos, Controlador controlador){
		super(new Vector2(xPos, yPos), VIDA_MAX,0 );
		this.controlador = controlador;
		colisionador = new ColisionadorObstaculoEnemigo(this);
		fuerzaDeColision = 150;
		inteligencia = new InteligenciaNula();
	}
	
	public int getFuerzaDeColision() {
		return fuerzaDeColision;
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
		colisionador.colisionarConBarricada(this);
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

	//TODO hacer
	public HitBox getHitBox() {
		return null;
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(textura, posicion, rotacion);
	}
}
