package edu.uns.galaxian.entidades.status;

import com.badlogic.gdx.math.Vector2;

public class StatusMutable implements Status {
	
	private Vector2 posicion;
	private Vector2 velocidad;
	private float rotacion;
	private float velocidadMax;
	
	public StatusMutable(){
		posicion= Vector2.Zero;
		velocidad= Vector2.Zero;
		rotacion=0;
		velocidadMax=0;
	}
	
	public StatusMutable( Vector2 pos, float v, float r, float vM){
		posicion= pos;
		velocidad= Vector2.Zero;
		rotacion=r;
		velocidadMax=vM;
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

	public float getVelocidadMax() {
		// TODO Auto-generated method stub
		return velocidadMax;
	}

	public void setPosicion(Vector2 p)
	{
		posicion=p;
	}
	
	public void setVelocidad(Vector2 v)
	{
		velocidad=v;
	}
	
	public void setVelocidadMax(float v)
	{
		velocidadMax=v;
	}
	
	public void setRotacion(float r)
	{
		rotacion=r;
	}
}
