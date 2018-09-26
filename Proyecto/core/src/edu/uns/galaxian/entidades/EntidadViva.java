package edu.uns.galaxian.entidades;

public abstract class EntidadViva extends EntidadColisionable{

	private int vida;
	private int vidaMaxima;

	/**
	 * Crea una nueva entidad viva con la posicion, el factor de escala y la vida maxima proveido.
	 * @param xPos Posicion en X de la entidad viva
	 * @param yPos Posicion en Y de la entidad viva
	 * @param factorEscala Factor de escala de la entidad viva
	 * @param vidaMaxima Vida maxima de la entidad viva
	 */
	public EntidadViva(int xPos, int yPos, float factorEscala, int vidaMaxima){
		super(xPos, yPos, factorEscala);
		this.vida = vidaMaxima;
		this.vidaMaxima = vidaMaxima;
	}

	/**
	 * Crea una nueva entidad viva con la posicion y la vida maxima proveido. El factor de escala sera 1.
	 * @param xPos Posicion en X de la entidad viva
	 * @param yPos Posicion en Y de la entidad viva
	 * @param vidaMaxima Vida maxima de la entidad viva
	 */
	public EntidadViva(int xPos, int yPos, int vidaMaxima){
		super(xPos, yPos);
		this.vidaMaxima = vidaMaxima;
	}

	/**
	 * Crea una nueva entidad viva con la vida maxima proveido. La posicion sera asignada por defecto
	 * y el factor de escala sera 1.
	 * @param vidaMaxima Vida maxima de la entidad viva
	 */
	public EntidadViva(int vidaMaxima){
		super();
		this.vidaMaxima = vidaMaxima;
	}

	/**
	 * Setea la vida de la entidad a la cantidad de vida proveida. Este cantidad no debe ser negativa
	 * ni mayor a la vida maxima de la entidad
	 * @param vida Nueva cantidad de vida de la entidad
	 * @throws IllegalArgumentException Si la cantidad de vida nueva es negativa o mayor a la maxima de la entidad
	 */
	public void setVida(int vida) throws IllegalArgumentException{
		if(vida < 0 || vida > vidaMaxima)
			throw new IllegalArgumentException("La nuevo valor de vida proveido es invalido.");
		this.vida = vida;
	}


	/**
	 * Devuelve la vida actual de la entidad.
	 * @return Cantidad de vida de la entidad.
	 */
	public int getVida(){
		return vida;
	}


	/**
	 * Setea la vida de la entidad al maximo permitido.
	 */
	public void setVidaAlMaximo(){
		vida = vidaMaxima;
	}
	
	/**
	 * Resta a la vida actual de la entidad, la cantidad de vida recibida. Si al restar la vida,
	 * esta resulta ser menor que 0 entonces la vida se setea a 0, es decir, la vida resultante nunca
	 * puede ser negativa.
	 * @param vidaARestar Cantidad de vida que se desea restar
	 * @throws IllegalArgumentException Si la vida recibida es negativa
	 */
	public void restarVida(int vidaARestar) throws IllegalArgumentException{
		if(vidaARestar < 0){
			throw new IllegalArgumentException("La vida que se quiere restar no puede ser negativa.");
		}
		setVida(Math.max(0, getVida() - vidaARestar));
	}
	
}
