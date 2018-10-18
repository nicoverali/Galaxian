package edu.uns.galaxian.colision;

import java.util.LinkedList;
import java.util.List;

public class DetectorColision {

	private List<Colisionable> colisionables;

	public DetectorColision() {
		colisionables = new LinkedList<>();
	}

	/**
	 * Registra un nuevo colisionable.
	 * @param col Colsionable a registrar
	 */
	public void registrarColisionable(Colisionable col) {
		colisionables.add(col);
	}

	/**
	 * Elimina el colisionable de la lista de colisionables registrados.
	 * @param eliminar Colisionable a eliminar
	 */
	public void eliminarColisionable(Colisionable eliminar) {
		boolean encontre = false;
		for(int i=0; i<colisionables.size() && !encontre; i++) {
			if(colisionables.get(i).equals(eliminar)) {
				encontre = true;
				colisionables.remove(eliminar);
			}
		}
	}

	/**
	 * Verifica entre todos los colisionables registrados si se produjo alguna
	 * colision. En caso de producirse, esta es resuelta.
	 */
	public void resolverColisiones(){
		for(Colisionable referencia : colisionables){
			for(Colisionable otroColisionable : colisionables){
				if(referencia != otroColisionable && colisionaron(referencia, otroColisionable)){
					referencia.aceptarColision(otroColisionable.getColisionador());
				}
			}
		}
	}

	private boolean colisionaron(Colisionable A, Colisionable B){
		return (Math.abs(A.getStatus().getPosicion().x - B.getStatus().getPosicion().x)<=(A.getAncho() + B.getAncho())/2
				&& Math.abs(A.getStatus().getPosicion().y - B.getStatus().getPosicion().y)<=(A.getAlto() + B.getAlto())/2);
	}
	
}