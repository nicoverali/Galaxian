package edu.uns.galaxian.util;

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
        float posX = posicion.x;
        float posY = posicion.y;
        float origenX = posX - ancho/2;
        float origenY = posY - alto/2;
        this.draw(textura, posX, posY, origenX, origenY, ancho, alto, 1, 1, rotacion, false);
    }

}
