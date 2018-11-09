package edu.uns.galaxian.colision.colisionadores;

import edu.uns.galaxian.entidades.enemigo.Enemigo;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.DisparoEnemigo;
import edu.uns.galaxian.entidades.inanimadas.obstaculos.Obstaculo;

public class ColisionadorEscudo extends Colisionador<Escudo> {

	private Escudo objetoFuente;
	
	public ColisionadorEscudo(Escudo escudo){
		objetoFuente=escudo;
	}

	public void visitEnemigo(Enemigo enemigo) {
		objetoFuente.eliminar();
	}

	public void visitDisparoEnemigo(DisparoEnemigo disparo) {
		// TODO falta decidir si el escudo deberia tener vida o algo por el estilo.
	}

	public void visitObstaculo(Obstaculo obstaculo) {
		// TODO falta decidir si el escudo deberia tener vida o algo por el estilo.
	}

}