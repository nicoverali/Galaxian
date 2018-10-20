package edu.uns.galaxian.colision;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.status.GameObject;

public class HBRectangulo implements HeadBox {
	
	private GameObject objeto;
	private float alto;
	private float ancho;
	
	public HBRectangulo(GameObject objeto, float alto, float ancho){
		this.objeto = objeto;
		this.alto = alto;
		this.ancho = ancho;
	}

	public boolean intersectarConRectangulo(HBRectangulo rectangulo) {
		Vector2 coordenada = objeto.getPosicion();
		float x = rectangulo.getCoordenada().x;
		float y = rectangulo.getCoordenada().y;
		return (Math.abs(coordenada.x - x)<=(ancho + rectangulo.getAncho())/2
				&& Math.abs(coordenada.y - y)<=(alto + rectangulo.getAlto())/2);
	}

	public boolean insersectarConCirculo(HBCirculo circulo) {
		float x = objeto.getPosicion().x ;
		float y = objeto.getPosicion().y ;
		
		float px = circulo.getCentro().x;
		if ( px < x) px = x;
		if ( px > x + ancho ) px = x + ancho;
		
		float py = circulo.getCentro().y;
		if ( py < y ) py = y;
		if ( py > y + alto ) py = y + alto;
		
		Vector2 centro = circulo.getCentro();
		float distancia = (float) Math.sqrt((centro.x - px)*(centro.x - px) + (centro.y - py)*(centro.y - py));
		return (distancia < circulo.getRadio());
	}

	public Vector2 getCoordenada() {
		return objeto.getPosicion();
	}

	public float getAncho() {
		return ancho;
	}

	public float getAlto() {
		return alto;
	}

}
