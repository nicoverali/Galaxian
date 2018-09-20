package edu.uns.galaxian.colision;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectorDeColisiones {

	private List<Colisionable> colisionables;

	public DetectorDeColisiones() {
		colisionables = new LinkedList<>();
	}

	/**
	 * Registra un nuevo colisionable
	 * @param col Colsionable a registrar
	 */
	public void registrarColisionable(Colisionable col) {
		colisionables.add(col);
	}

	/**
	 * Elimina un colisionable de la coleccion de colisionables registrados
	 * @param col Colisionable a eliminar
	 */
	public void eliminarColisionable(Colisionable col) {
		Iterator<Colisionable> it = colisionables.iterator();
		while(it.hasNext()) {
			Colisionable aux = it.next();
			if(aux== col)  colisionables.remove(aux);
		}
	}

	/**
	 * A partir del colisionable previsto, se verifica la existencia de alguna colision con este colisionable.
	 * En caso de haber una colision, esta se resuelve.
	 * @param referencia Objeto colisionable del cual se verifican las colisiones
	 */
	public void verificarYResolverColisiones(Colisionable referencia) {
		for(Colisionable otraColisionable : colisionables) {
			int x = (int) referencia.getPosicion().x;
			int y = (int) referencia.getPosicion().y;
			int ancho = referencia.getAncho();
			int alto = referencia.getAlto();
			if(otraColisionable.getPosicion().x <= x+(ancho/2) && otraColisionable.getPosicion().x >= x-(ancho/2)
					&& otraColisionable.getPosicion().y <= y+(alto/2) && otraColisionable.getPosicion().y >= y-(alto/2) && referencia != otraColisionable) {
				referencia.aceptarColision(otraColisionable.getColisionador());
				otraColisionable.aceptarColision(referencia.getColisionador());
			}
		}
	}
}