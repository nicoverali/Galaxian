package edu.uns.galaxian.entidades.jugador;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.colision.colisionadores.Colisionador;
import edu.uns.galaxian.colision.colisionadores.ColisionadorJugador;
import edu.uns.galaxian.controladores.ControladorDisparo;
import edu.uns.galaxian.entidades.equipamiento.ArmaComun;
import edu.uns.galaxian.entidades.inanimadas.Disparo;
import edu.uns.galaxian.entidades.inanimadas.DisparoJugador;
import edu.uns.galaxian.juego.Nivel;

public class NaveLiviana extends Jugador {

    // Propiedades de este jugador
	private static final String DIR_TEXTURA = "./jugador/AZUL/naveLiviana.png";
    private static final int VIDA_MAXIMA = 100;
    private static final int VELOCIDAD_MAXIMA = 400;
    private static final long CADENCIA_DISPARO = 700;
    private long tiempoUltimoDisparo;
    private int alto;
    private int ancho;
    private Texture textura;
    private ControladorDisparo controladorDisparos;
    private ColisionadorJugador colisionador;
    private Nivel nivel;

    // Constructor
    public NaveLiviana(int i, int j, int factorEscala, Nivel nivel) {
    	super(i,j,factorEscala,VIDA_MAXIMA);
    	this.nivel = nivel;
    	this.tiempoUltimoDisparo = System.currentTimeMillis() - CADENCIA_DISPARO;
        this.textura = new Texture(Gdx.files.internal(String.format(DIR_TEXTURA)));
        this.alto = (int) Math.floor(textura.getHeight() * factorEscala)-20;
        this.ancho = (int) Math.floor(textura.getWidth() * factorEscala)-30;
        
        colisionador = new ColisionadorJugador(this);
        
        // TODO creo un arma por defecto, por ahora

        arma = new ArmaComun(new DisparoJugador());

    }

    // Implementacion de metodos abstractos

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void actualizar() {
    // Actualizar posicion
     	float posNueva = (posicion.x + (VELOCIDAD_MAXIMA * input.getXAxis() * Gdx.graphics.getDeltaTime()));
     	float anchoTextura = getAncho()/2;
     	if(posNueva - anchoTextura >= 0 && posNueva + anchoTextura < Gdx.graphics.getWidth()) {
     		posicion.set(posNueva, posicion.y);
     	}

    // Verificar disparo
     	if(input.sePresionoDisparar() && (System.currentTimeMillis() - tiempoUltimoDisparo) > CADENCIA_DISPARO) {
     		List<Disparo> disparos = arma.disparar((int)posicion.x , (int)posicion.y +(ancho/2)-2, new Vector2(0,1));
     		for(Disparo d : disparos) {
     			controladorDisparos.agregarDisparo(d);
     		}
     		tiempoUltimoDisparo = System.currentTimeMillis();
     	}
    }


    public void dibujar(SpriteBatch batch) {
		batch.draw(textura, posicion.x-(getAncho()/2), posicion.y-(getAlto()/2), getAncho(), getAlto());
    }
    
    public void restarVida(int vidaARestar) throws IllegalArgumentException {
    	if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida que se quiere restar no puede ser negativa.");
		}
		setVida(Math.max(0, getVida() - vidaARestar));
    }

    public void eliminar() {
        textura.dispose();
    }

    public void setControladorDisparo(ControladorDisparo c) {
    	controladorDisparos = c;
    }
    
    public Colisionador getColisionador() {
        return colisionador;
    }

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionarConJugador(this);
    }
}
