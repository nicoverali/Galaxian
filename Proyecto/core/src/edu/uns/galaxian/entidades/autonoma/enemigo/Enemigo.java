package edu.uns.galaxian.entidades.autonoma.enemigo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.EntidadBatch;
import edu.uns.galaxian.entidades.EntidadViva;
import edu.uns.galaxian.entidades.autonoma.Autonomo;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaArtificial;
import edu.uns.galaxian.entidades.autonoma.ia.InteligenciaFormacion;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.armas.ArmaDisparoDoble;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.disparos.fabrica.FabricaDisparoEnemigo;
import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEnemigo;

public  class Enemigo extends EntidadViva implements Autonomo  {
	
	private Controlador controlador;
	private ColisionadorEnemigo colisionador;
	private InteligenciaArtificial inteligencia;
	
	private static final int puntaje=10;
	
	private int vidaMax;
	private int rotacion;
	
	
	protected Arma arma;
	protected Texture textura;
	
	public Enemigo(Vector2 posicion, int vida, Texture textura, Controlador controlador){
		super(posicion, vida, 270);
		this.textura=textura;
		vidaMax=vida;
		rotacion=270;
		this.controlador = controlador;
		this.colisionador = new ColisionadorEnemigo(this);
		inteligencia = new InteligenciaFormacion(posicion);
		setArma(new ArmaDisparoDoble<>(new FabricaDisparoEnemigo()));
	}

	/**
	 * Retorna el danio por colisionar con la entidad
	 * @return int danio por colisionar
	 */
	public int getFuerzaDeColision()
	{
		return 100;
	}
	
	/**
	 * Cambia el arma actual del enemigo por una nueva.
	 * @param nuevaArma Nueva arma del enemigo
	 */
	public void setArma(Arma<DisparoEnemigo> nuevaArma) {
		arma=nuevaArma;
	}

	/**
	 * Produce nuevos disparos con el arma que tiene el enemigo.
	 */
    public void disparar() {
		arma.disparar(posicion.cpy(), rotacion, controlador);
	}

    public float getAlto() {
    	return textura.getHeight();
    }

    public float getAncho() {
    	return textura.getWidth();
    }

	public void setVidaAlMaximo() {
		vida.setValor(vidaMax);
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}

	public void actualizar(float delta) {
		inteligencia.pensar(this);
		if(posicion.y < 0) {
			posicion.y = Gdx.graphics.getHeight();
			if(posicion.x<0 || posicion.x>Gdx.graphics.getWidth()) {
				posicion.x = 40;
			}
		}
	}
    
	//TODO setear inteligencia
    public void atacar() {
    	disparar();
    }

    public void dibujar(EntidadBatch batch) {
    	float alto = getAlto();
		float ancho = getAncho();
		batch.draw(textura, posicion.x - ancho/2, posicion.y - alto/2, ancho, alto);

    }

    public void eliminar() {
    	controlador.eliminarEntidad(this);
    	controlador.sumar(puntaje);
    }

	public Colisionador getColisionador(){
		return colisionador;
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConEnemigo(this);
	}
}
