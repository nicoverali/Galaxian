package edu.uns.galaxian.colision;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.uns.galaxian.entidades.EntidadColisionable;

public class DetectorDeColisiones {

	private List<EntidadColisionable> colisionables;
	
	public DetectorDeColisiones() {
		colisionables = new LinkedList<EntidadColisionable>();
	}
	
	public void registrarEntidadColisionable(EntidadColisionable nueva) {
		colisionables.add(nueva);
	}
	
	public void eliminarEntidad(EntidadColisionable eliminar) {
		/*boolean encontre = false;
		for(int i=0; i<colisionables.size() && !encontre; i++) {
			if(colisionables.get(i).equals(eliminar)) {
				encontre = true;
			}
		}
		if(encontre) {
			colisionables.remove(eliminar);
			System.out.println("elimine");
		}*/
	}
	
	public void verificarColisiones() {
		for(EntidadColisionable entidad1 : colisionables) {
			for(EntidadColisionable entidad2 : colisionables) {
				int x = (int) entidad1.getPosicion().x;
				int y = (int) entidad1.getPosicion().y;
				int ancho = entidad1.getAncho();
				int alto = entidad1.getAlto();
				if(entidad2.getPosicion().x <= x+(ancho/2) && entidad2.getPosicion().x >= x-(ancho/2) 
				   && entidad2.getPosicion().y <= y+(alto/2) && entidad2.getPosicion().y >= y-(alto/2) && entidad1!=entidad2) {
				entidad1.aceptarColision(entidad2);
				}
			}
		}
	}
	
}
