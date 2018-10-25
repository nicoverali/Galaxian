package edu.uns.galaxian.entidades.enemigo;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.EntidadConNave;
import edu.uns.galaxian.ia.autonomo.AutonomoDinamico;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.powerups.PowerUp;
import edu.uns.galaxian.entidades.inanimadas.powerups.magiaTemporal.*;
import edu.uns.galaxian.entidades.inanimadas.powerups.objetoPrecioso.*;
import edu.uns.galaxian.colision.colisionadores.*;
import edu.uns.galaxian.ia.InteligenciaArtificial;
import edu.uns.galaxian.ia.inteligencias.basica.InteligenciaNula;
import edu.uns.galaxian.nave.NaveEnemigo;

public  class Enemigo extends EntidadConNave<NaveEnemigo, DisparoEnemigo> implements AutonomoDinamico {
	
	private static final int puntaje=10;
	private Controlador controlador;
	private InteligenciaArtificial inteligencia;
	private ColisionadorEnemigo colisionador;

	public Enemigo(Vector2 posicion, NaveEnemigo nave, Controlador controlador, InteligenciaArtificial iaIncial){
		super(posicion, 270, nave, controlador.getTextureAtlas());
		this.controlador = controlador;
		inteligencia = iaIncial;
		colisionador = new ColisionadorEnemigo(this);
	}

	public Enemigo(Vector2 posicion, NaveEnemigo nave, Controlador controlador){
		super(posicion, 270, nave, controlador.getTextureAtlas());
		this.controlador = controlador;
		inteligencia = new InteligenciaNula<>(this);
		colisionador = new ColisionadorEnemigo(this);
	}

	/**
	 * Retorna la fuerza con la que colisiona el enemigo
	 * @return Fuerza de colision del enemigo
	 */
	public int getFuerzaDeColision()
	{
		return nave.getFuerzaDeColision();
	}
    public void disparar() {
		nave.getArma().disparar(posicion.cpy(), rotacion, controlador);
	}

	public void atacar() {
		inteligencia.transicionar(nave.getInteligenciaAtaque(this, controlador.getJugador()));
	}

	public InteligenciaArtificial getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(InteligenciaArtificial ia) {
		inteligencia = ia;
	}

	public void transicionarInteligencia(InteligenciaArtificial ia) {
		inteligencia.transicionar(ia);
	}

	public void actualizar(float delta) {
		inteligencia.pensar(delta);
	}

    public void eliminar() {
    	controlador.eliminarEntidad(this);
    	if(decidirCrearPowerUp()) {
    		PowerUp entidad = crearPower();
    		controlador.agregarEntidad(entidad);
    	}
    	controlador.sumar(puntaje);
    }

    private PowerUp crearPower(){
    	//Cuando esten todos los powers
    	//Random ran= new Random();
    	//int n= ran.nextInt(5);
    	int n=3;
    	switch(n){
    		case 0: return new PastillaVida(posicion,new Vector2 (0,-1),rotacion,controlador);
    		case 1: return new CampoDeProteccion(posicion,new Vector2 (0,-1),rotacion,controlador);
    		case 2: return new Misil(posicion,new Vector2 (0,-1),rotacion,controlador);
    		case 3: return new MejoraArma(posicion,new Vector2 (0,-1),rotacion,controlador);
    		case 4: return new CongelaTiempo(posicion,new Vector2 (0,-1),rotacion,controlador);
    		default: return null;
    	}
    }

    //Probabilidad de que se genere un power 3 de 10
	private boolean decidirCrearPowerUp() {
    	Random ran= new Random();
    	int azar = ran.nextInt(10);
    	return azar<3;
    }

	public Colisionador getColisionador(){
		return colisionador;
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.colisionarConEnemigo(this);
		nave.aceptarColision(colisionador);
	}

	public float getVelocidadMaxima() {
		return nave.getVelocidadMax();
	}

	public float getSteeringMaximo() {
		return nave.getSteeringMax();
	}
}
