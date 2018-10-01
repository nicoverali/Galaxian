package edu.uns.galaxian.entidades.status;

import com.badlogic.gdx.math.Vector2;

public class StatusMutableVida implements StatusVida {

	private Vector2 posicion;
	private Vector2 velocidad;
	private float rotacion;
	private int vida;
	
	public StatusMutableVida()
	{
		posicion= Vector2.Zero;
		velocidad=new Vector2(0,0);
		rotacion=0;
		vida=0;
	}
	
	public StatusMutableVida(Vector2 p, float r, int vida)
	{
		posicion=p;
		velocidad= new Vector2(0,0);
		rotacion=r;
		this.vida=vida;
	}
	
	public Vector2 getPosicion() {
		return posicion.cpy();
	}

	public Vector2 getVelocidad() {
		// TODO Auto-generated method stub
		return velocidad.cpy();
	}

	public float getRotacion() {
		// TODO Auto-generated method stub
		return rotacion;
	}
	
	public void restarVida(int v)
	{
		if(vida>0)
		{
			vida= Math.max(vida-v,0);
		}
	}
	
	public int getVidaActual()
	{
		return vida;
	}
	
	
}
