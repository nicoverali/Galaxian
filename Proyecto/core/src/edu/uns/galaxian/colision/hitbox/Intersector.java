package edu.uns.galaxian.colision.hitbox;

import com.badlogic.gdx.math.Vector2;

public class Intersector {

    /**
     * Verifica la interseccion entre un rectangulo y un circulo.
     * Retorna verdadero si las figuras estan intersectadas, falso en caso contrario.
     * @param rect Rectangulo
     * @param circulo irculo
     * @return Verdadero si las figuras se intersectan
     */
    public static boolean interseccionRectCirculo(HBRectangulo rect, HBCirculo circulo){
        float x = rect.getPosicion().x ;
        float y = rect.getPosicion().y ;

        float px = circulo.getPosicion().x;
        if ( px < x) px = x;
        if ( px > x + rect.getAncho() ) px = x + rect.getAncho();

        float py = circulo.getPosicion().y;
        if ( py < y ) py = y;
        if ( py > y + rect.getAlto() ) py = y + rect.getAlto();

        Vector2 centro = circulo.getPosicion();
        float distancia = (float) Math.sqrt((centro.x - px)*(centro.x - px) + (centro.y - py)*(centro.y - py));
        return (distancia < circulo.getRadio());
    }

    /**
     * Verifica la interseccion entre un circulo y otro circulo.
     * Retorna verdadero si las figuras estan intersectadas, falso en caso contrario.
     * @param circuloA Primer circulo
     * @param circuloB Segundo circulo
     * @return Verdadero si las figuras se intersectan
     */
    public static boolean interseccionCirculoCirculo(HBCirculo circuloA, HBCirculo circuloB){
        Vector2 coordenadas = circuloA.getPosicion();
        Vector2 centro = circuloB.getPosicion();
        float cx = coordenadas.x;
        float cy = coordenadas.y;
        float distancia = (float) Math.sqrt((centro.x-cx)*(centro.x-cx) + (centro.y-cy)*(centro.y-cy));
        return (distancia < (circuloB.getRadio()+circuloA.getRadio())) ;
    }

    /**
     * Verifica la interseccion entre un circulo y otro circulo.
     * Retorna verdadero si las figuras estan intersectadas, falso en caso contrario.
     * @param rectA Primer rectangulo
     * @param rectB Segundo rectangulo
     * @return Verdadero si las figuras se intersectan
     */
    public static boolean interseccionRectRect(HBRectangulo rectA, HBRectangulo rectB){
        Vector2 coordenada = rectA.getPosicion();
        float x = rectB.getPosicion().x;
        float y = rectB.getPosicion().y;
        return (Math.abs(coordenada.x - x)<=(rectA.getAncho() + rectB.getAncho())/2
                && Math.abs(coordenada.y - y)<=(rectA.getAlto() + rectB.getAlto())/2);
    }
    
}