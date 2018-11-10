package edu.uns.galaxian.entidades.enemigo;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.ia.AutonomoDinamico;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.powerups.fabricaPowerUp.FabricaPowerUp;
import edu.uns.galaxian.entidades.inanimadas.powerups.fabricaPowerUp.FabricaPowerUpConvencional;
import edu.uns.galaxian.colision.colisionadores.*;
import edu.uns.galaxian.ia.Tarea;
import edu.uns.galaxian.ia.TareaNula;
import edu.uns.galaxian.juego.Juego;
import edu.uns.galaxian.nave.NaveEnemigo;

public  class Enemigo extends EntidadConNave<NaveEnemigo, DisparoEnemigo> implements AutonomoDinamico {
	
	private Controlador controlador;
	private Tarea<Enemigo> inteligencia;
	private ColisionadorEnemigo colisionador;
	private FabricaPowerUp fabricaPowerUp;

	public Enemigo(Vector2 posicion, NaveEnemigo nave, Controlador controlador, FabricaPowerUp fPowerUp){
		super(posicion, 270, nave, controlador.getTextureAtlas(Juego.ATLAS_NAVES));
		this.controlador = controlador;
		inteligencia = new TareaNula<>();
		colisionador = new ColisionadorEnemigo(this);
		fabricaPowerUp = fPowerUp;
	}

	public Enemigo(Vector2 posicion, NaveEnemigo nave, Controlador controlador){
		super(posicion, 270, nave, controlador.getTextureAtlas(Juego.ATLAS_NAVES));
		this.controlador = controlador;
		inteligencia = new TareaNula<>();
		colisionador = new ColisionadorEnemigo(this);
		fabricaPowerUp = new FabricaPowerUpConvencional();
	}

	/**
	 * Retorna la fuerza con la que colisiona el enemigo
	 * @return Fuerza de colision del enemigo
	 */
	public int getFuerzaDeColision()
	{
		return nave.getFuerzaDeColision();
	}

	/**
	 * Retorna el puntaje bonus que se
	 * obtiene de este enemigo
	 * @return Puntaje bonus obtenido de este enemigo
	 */
	public int getBonus() {
		return nave.getBonus();
	}

    public void disparar() {
		nave.getArma().disparar(posicion.cpy(), rotacion, controlador);
	}

	public void atacar() {
		inteligencia = nave.getTareaAtaque(this, controlador.getJugador());
	}

	public void setTareaInteligencia(Tarea TareaIA) {
		inteligencia = TareaIA;
	}

	public void actualizar(float delta) {
		inteligencia.realizar(delta);
	}

    public void eliminar() {
    	controlador.eliminarEntidad(this);
    	if(MathUtils.randomBoolean(0.22f)) {
    		PowerUp entidad = fabricaPowerUp.getPowerUp(posicion, rotacion, controlador);
    		controlador.agregarEntidad(entidad);
    	}
    }

	public Visitor getColisionador(){
		return colisionador;
	}

	public void aceptarVisitor(Visitor colisionador) {
		colisionador.visitEnemigo(this);
	}

	public float getVelocidadMaxima() {
		return nave.getVelocidadMax();
	}

	public float getSteeringMaximo() {
		return nave.getSteeringMax();
	}
}
