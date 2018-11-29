package edu.uns.galaxian.entidades.equipamiento.escudos;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import edu.uns.galaxian.colision.colisionadores.Visitor;
import edu.uns.galaxian.colision.colisionadores.ColisionadorEscudo;
import edu.uns.galaxian.colision.hitbox.HBCirculo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.controlador.Controlador;
import edu.uns.galaxian.entidades.Entidad;
import edu.uns.galaxian.entidades.jugador.Jugador;
import edu.uns.galaxian.util.EntidadBatch;
import edu.uns.galaxian.util.enums.Asset;

public class Escudo extends Entidad {

	private Jugador jugador;
	private ColisionadorEscudo colisionador;
	private Controlador controlador;
	private HBCirculo hitbox;
	private TextureRegion texture;
	
	public Escudo(Jugador jugador, Controlador controlador){
		super(jugador.getPosicion(),jugador.getVelocidad(),jugador.getRotacion());
		this.jugador=jugador;		
		this.controlador=controlador;
		texture = controlador.getTextureAtlas(Asset.ATLAS_MISC.valor()).findRegion("escudo");
		colisionador= new ColisionadorEscudo(this);
		hitbox = new HBCirculo(this,texture.getRegionWidth()*0.4f);
	}
	
	public HitBox getHitBox() {
		return hitbox;
	}

	public Visitor getColisionador() {
		return colisionador;
	}

	public void aceptarVisitor(Visitor colisionador) {
		colisionador.visitEscudo(this);
	}

	public void dibujar(EntidadBatch batch) {
		batch.draw(texture, jugador.getPosicion(), 0);
	}

	public void actualizar(float delta) {
		posicion = jugador.getPosicion();		
	}

	public void eliminar() {
		controlador.eliminarEntidad(this);
	}

}