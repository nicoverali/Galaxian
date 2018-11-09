package edu.uns.galaxian.colision;

import java.util.Collection;

public class DetectorColision {

	/**
	 * Verifica entre todos los colisionables registrados si se produjo alguna
	 * colision. En caso de producirse, esta es resuelta.
	 */
	public void resolverColisiones(Collection<Colisionable> colisionables) {
		for(Colisionable referencia : colisionables){
			for(Colisionable otroColisionable : colisionables){
				if(referencia != otroColisionable && colisionaron(referencia, otroColisionable)){
					referencia.aceptarVisitor(otroColisionable.getColisionador());
				}
			}
		}
	}

	private boolean colisionaron(Colisionable A, Colisionable B){
		return A.getHitBox().verificarInterseccion(B.getHitBox());
	}
	
}