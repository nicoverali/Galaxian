package edu.uns.galaxian.colision;

import java.util.LinkedList;
import java.util.List;

public class DetectorColision {

	private List<Colisionable> colisionables;

	public DetectorColision() {
		colisionables = new LinkedList<>();
	}

	/**
	 * Registra un nuevo colisionable
	 * @param col Colsionable a registrar
	 */
	public void registrarColisionable(Colisionable col) {
		colisionables.add(col);
	}

	public void eliminarEntidad(Colisionable eliminar) {
		boolean encontre = false;
		for(int i=0; i<colisionables.size() && !encontre; i++) {
			if(colisionables.get(i).equals(eliminar)) {
				encontre = true;
				colisionables.remove(eliminar);
			}
		}
	}

	/**
	 * A partir del colisionable previsto, se verifica la existencia de alguna colision con este colisionable.
	 * En caso de haber una colision, esta se resuelve.
	 * @param referencia Objeto colisionable del cual se verifican las colisiones
	 */
	public void verificarYResolverColisiones(Colisionable referencia) {
		for (Colisionable otroColisionable : colisionables){
			int x = (int) referencia.getPosicion().x;
			int y = (int) referencia.getPosicion().y;
			int ancho = referencia.getAncho();
			int alto = referencia.getAlto();
			if(referencia != otroColisionable && colisionaron(referencia, otroColisionable)) {
				referencia.aceptarColision(otroColisionable.getColisionador());
				otroColisionable.aceptarColision(referencia.getColisionador());
			}
		}
	}

	private boolean colisionaron(Colisionable A, Colisionable B){
		return (Math.abs(A.getPosicion().x - B.getPosicion().x)<=(A.getAncho() + B.getAncho())/2
				&& Math.abs(A.getPosicion().y - B.getPosicion().y)<=(A.getAlto() + B.getAlto())/2);
	}
}