package edu.uns.galaxian.entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.colision.hitbox.HBRectangulo;
import edu.uns.galaxian.colision.hitbox.HitBox;
import edu.uns.galaxian.entidades.equipamiento.armas.Arma;
import edu.uns.galaxian.entidades.equipamiento.escudos.Escudo;
import edu.uns.galaxian.entidades.inanimadas.disparos.Disparo;
import edu.uns.galaxian.nave.Nave;
import edu.uns.galaxian.util.EntidadBatch;

public abstract class EntidadConNave<T extends Nave<S>, S extends Disparo> extends EntidadViva{

    protected T nave;
    protected Texture textura;
    protected HitBox hitbox;

    public EntidadConNave(Vector2 posicion, float rotacion, T nave){
        super(posicion, nave.getVidaMax(), rotacion);
        this.nave = nave;
        textura = new Texture(Gdx.files.internal(nave.getTexturaDir()));
        hitbox = new HBRectangulo(this, textura.getHeight(), textura.getWidth());
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
     * Cambia el escudo actual de la entidad por uno nuevo.
     * @param nuevoEscudo Nuevo escudo de la entidad
     */
    public void setEscudo(Escudo nuevoEscudo){
        nave.setEscudo(nuevoEscudo);
    }

    /**
     * Retorna el escudo actual de la entidad
     * @return Escudo actual
     */
    public Escudo getEscudo(){
        return nave.getEscudo();
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
        // TODO Puede ser que deba estar en Jugador y Enemigo. Tambien falta el metodo nave.dibujarEquipamiento, y utilizar EntidadBatch para dibujar
        float alto = textura.getHeight();
        float ancho = textura.getWidth();
        batch.draw(textura, posicion.x - ancho/2, posicion.y - alto/2, ancho, alto);
    }

    @Override
    public HitBox getHitBox() {
        return hitbox;
    }
}
