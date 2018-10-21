package edu.uns.galaxian.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class EntidadBatch extends SpriteBatch {

    /**
     * Toma la textura recibida y la dibuja en la posicion y con la rotacion dadas.
     * @param textura Textura
     * @param posicion Posicion donde se dibujara la textura
     * @param rotacion Rotacion con la que se dibujara la textura
     */
    public void draw(TextureRegion textura, Vector2 posicion, float rotacion){
        float ancho = textura.getRegionWidth();
        float alto = textura.getRegionHeight();
        float posX = posicion.x - ancho/2;
        float posY = posicion.y - alto/2;
        float origenX = ancho/2;
        float origenY = alto/2;
        this.draw(textura, posX, posY, origenX, origenY, ancho, alto, 1, 1, rotacion);
    }

    /**
     * Toma la textura recibida y la dibuja en la posicion y con la rotacion dadas.
     * @param textura Textura
     * @param posicion Posicion donde se dibujara la textura
     * @param rotacion Rotacion con la que se dibujara la textura
     */
    public void draw(Texture textura, Vector2 posicion, float rotacion){
        float ancho = textura.getWidth();
        float alto = textura.getHeight();
        float posX = posicion.x - ancho/2;
        float posY = posicion.y - alto/2;
        float origenX = ancho/2;
        float origenY = alto/2;
        this.draw(textura, posX, posY, origenX, origenY, ancho, alto, 1, 1, rotacion, 0, 0, (int)ancho, (int)alto, false, false);
    }
}
