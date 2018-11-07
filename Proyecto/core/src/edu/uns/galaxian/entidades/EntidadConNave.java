package edu.uns.galaxian.entidades;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.estados.EstadoDibujar;
import edu.uns.galaxian.entidades.estados.EstadoSano;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;
import edu.uns.galaxian.nave.Nave;
import edu.uns.galaxian.util.EntidadBatch;

public abstract class EntidadConNave<T extends Nave<S>, S extends Disparo> extends EntidadViva{

    protected T nave;
    protected TextureRegion textura;
    protected EstadoDibujar estado;
    protected EstadoDibujar proximoEstado;
    protected HitBox hitbox;

    public EntidadConNave(Vector2 posicion, float rotacion, T nave, TextureAtlas atlas){
        super(posicion, nave.getVidaMax(), rotacion);
        this.nave = nave;
        textura = atlas.findRegion(nave.getTexturaDir());
        hitbox = new HBRectangulo(this, textura.getRegionHeight(), textura.getRegionWidth());
        estado = new EstadoSano(this,nave,atlas);
    }

    /**
     * Cambia el arma actual de la entidad por una nueva.
     * @param nuevaArma Nueva arma de la entidad
     */
    public void setArma(Arma<S> nuevaArma) {
        nave.setArma(nuevaArma);
    }

    /**
     * Retorna el arma actual de la entidad.
     * @return Arma actual
     */
    public Arma<S> getArma(){
        return nave.getArma();
    }

    /**
     * Produce nuevos disparos con el arma que tiene la nave de la entidad.
     */
    public abstract void disparar();

    @Override
    public void setVidaAlMaximo() {
        this.vida.setValor(nave.getVidaMax());
    }

    @Override
    public void dibujar(EntidadBatch batch) {
        estado.dibujar(batch);
    }

    @Override
    public HitBox getHitBox() {
        return hitbox;
    }

	public void cambiarEstado(EstadoDibujar nuevoEstado) {
		proximoEstado = nuevoEstado;
	}
}
