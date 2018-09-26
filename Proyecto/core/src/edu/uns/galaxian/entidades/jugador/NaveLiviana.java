package edu.uns.galaxian.entidades.jugador;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import edu.uns.galaxian.util.enums.Color;

public class NaveLiviana implements NaveJugador {

    private static final String DIR_TEXTURA = "./jugador/%s/naveLiviana.png";
    private static final int VELOCIDAD_MAXIMA = 250;
    private static final int VIDA_MAXIMA = 100;

    private int alto;
    private int ancho;
    private Texture textura;

    // Constructor
    public NaveLiviana(Color color) {
        this.textura = new Texture(Gdx.files.internal(String.format(DIR_TEXTURA, color.name())));
        this.alto = (int) Math.ceil(textura.getHeight());
        this.ancho = (int) Math.ceil(textura.getWidth());
    }

    // Implementacion de metodos

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }
    
    public int getVelocidad(){
        return VELOCIDAD_MAXIMA;
    }

    public int getVidaMax(){
        return VIDA_MAXIMA;
    }

    public Texture getTextura(){
        return textura;
    }

}
