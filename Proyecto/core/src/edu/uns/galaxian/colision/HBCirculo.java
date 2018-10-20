package edu.uns.galaxian.colision;

import com.badlogic.gdx.math.Vector2;

import edu.uns.galaxian.entidades.status.GameObject;

public class HBCirculo implements HeadBox {
	
	GameObject objeto;
	float radio;
	
	public HBCirculo(GameObject objeto, float radio) {
		this.objeto = objeto;
		this.radio = radio;
	}

	public boolean intersectarConRectangulo(HBRectangulo rectangulo) {
		float anchoRectangulo = rectangulo.getAncho();
		float altoRectangulo = rectangulo.getAlto();
		float x = rectangulo.getCoordenada().x;
		float y = rectangulo.getCoordenada().y;
		Vector2 centro = objeto.getPosicion();
		
		float px = centro.x;
		if ( px < x) px = x;
		if ( px > x + anchoRectangulo ) px = x + anchoRectangulo;
		
		float py = centro.y;
		if ( py < y ) py = y;
		if ( py > y + altoRectangulo ) py = y + altoRectangulo;
		
		float distancia = (float) Math.sqrt((centro.x - px)*(centro.x - px) + (centro.y - py)*(centro.y - py));
		return (distancia < radio);
	}

	public boolean insersectarConCirculo(HBCirculo circulo) {
		Vector2 coordenadas = circulo.getCentro();
		Vector2 centro = objeto.getPosicion();
		float cx = coordenadas.x;
		float cy = coordenadas.y;
		float distancia = (float) Math.sqrt((centro.x-cx)*(centro.x-cx) + (centro.y-cy)*(centro.y-cy));
		return (distancia < (radio+circulo.getRadio())) ;
	}

	public float getRadio() {
		return radio;
	}

	public Vector2 getCentro() {
		return objeto.getPosicion();
	}

}
