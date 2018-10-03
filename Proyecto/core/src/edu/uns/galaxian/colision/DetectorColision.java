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
			int x = (int) referencia.getStatus().getPosicion().x;
			int y = (int) referencia.getStatus().getPosicion().y;
			float ancho = referencia.getAncho();
			float alto = referencia.getAlto();
			if(referencia != otroColisionable && colisionaron(referencia, otroColisionable)) {
				referencia.aceptarColision(otroColisionable.getColisionador());
				otroColisionable.aceptarColision(referencia.getColisionador());
			}
		}
	}

	private boolean colisionaron(Colisionable A, Colisionable B){
		return (Math.abs(A.getStatus().getPosicion().x - B.getStatus().getPosicion().x)<=(A.getAncho() + B.getAncho())/2
				&& Math.abs(A.getStatus().getPosicion().y - B.getStatus().getPosicion().y)<=(A.getAlto() + B.getAlto())/2);
	}
}