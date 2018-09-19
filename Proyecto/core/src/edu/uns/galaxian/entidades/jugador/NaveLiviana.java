package edu.uns.galaxian.entidades.jugador;

import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.uns.galaxian.colision.Colisionador;
import edu.uns.galaxian.juego.Nivel;

public class NaveLiviana extends Jugador {

    // Propiedades de este jugador
    private static final int VIDA_MAXIMA = 100;
    private static final int VELOCIDAD_MAXIMA = 200;
    private static final String DIR_TEXTURA = "./jugador/%s/naveLiviana.png";
    private Texture textura;
    private int alto;
    private int ancho;

    // Constructor
    public NaveLiviana(int i, int j, int factorEscala, Nivel nivel) {
    	super(i,j,factorEscala,VIDA_MAXIMA);
        this.textura = new Texture(Gdx.files.internal(String.format(DIR_TEXTURA)));
        this.alto = (int) Math.floor(textura.getHeight() * factorEscala);
        this.ancho = (int) Math.floor(textura.getWidth() * factorEscala);
    }

	// Implementacion de metodos abstractos
    @Override
    public int getAlto() {
        return alto;
    }
    @Override
    public int getAncho() {
        return ancho;
    }
    @Override
    public void actualizar() {
        this.posicion.x += VELOCIDAD_MAXIMA * input.getXAxis() * Gdx.graphics.getDeltaTime();
    }
    @Override
    public void dibujar(SpriteBatch batch) {
        batch.draw(textura, posicion.x, posicion.y, ancho, alto);
    }
    @Override
    public void eliminar() {
        textura.dispose();
    }
    @Override
    public Colisionador getColisionador() {
        return null; // TODO Agregar colisionador
    }
}
