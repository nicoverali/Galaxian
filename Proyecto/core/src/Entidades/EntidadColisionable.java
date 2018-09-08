package Entidades;
import Colision.Colisionable;

public interface EntidadColisionable extends Entidad, Colisionable{

	/**
	 * Devuelve la altura de la entidad en pixeles.
	 * @return Altura de la entidad en pixeles.
	 */
	public int getAlto();
	
	/**
	 * Devuelve el ancho de la entidad en pixeles
	 * @return Ancho de la entidad en pixeles.
	 */
	public int getAncho();
	
	/**
	 * Devuelve la vida actual de la entidad.
	 * @return Cantidad de vida de la entidad.
	 */
	public int getVida();
	
	/**
	 * Setea la vida de la entidad.
	 * @param nuevaVida Nueva cantidad de vida de la entidad.
	 */
	public void setVida(int nuevaVida);
	
	/**
	 * Setea la vida de la entidad al máximo permitido.
	 */
	public void setVidaAlMaximo();
	
}
