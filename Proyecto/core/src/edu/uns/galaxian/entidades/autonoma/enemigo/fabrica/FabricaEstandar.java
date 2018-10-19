package edu.uns.galaxian.entidades.autonoma.enemigo.fabrica;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.controladores.Controlador;
import edu.uns.galaxian.entidades.autonoma.enemigo.Enemigo;
import edu.uns.galaxian.entidades.autonoma.enemigo.tipos.Armado;
import edu.uns.galaxian.entidades.autonoma.enemigo.tipos.ArmadoDebil;
import edu.uns.galaxian.entidades.autonoma.enemigo.tipos.Kamikaze;
import edu.uns.galaxian.entidades.autonoma.enemigo.tipos.KamikazeAleatorio;
import edu.uns.galaxian.entidades.autonoma.enemigo.tipos.KamikazeMixto;
import edu.uns.galaxian.entidades.status.GameObject;

public class FabricaEstandar extends FabricaEnemigos {

	public Enemigo getKamikaze(Vector2 posicion, Controlador controlador, GameObject jugador) {
		return new Kamikaze(posicion,60,200,20,controlador,jugador);
	}

	public Enemigo getKamikazeAleatorio(Vector2 posicion, Controlador controlador) {
		return new KamikazeAleatorio(posicion,80,200,20,controlador,null);
	}

	public Enemigo getKamikazeMixto(Vector2 posicion, Controlador controlador, GameObject jugador) {
		return new KamikazeMixto(posicion,70,200,20,controlador,jugador);
		}

	public Enemigo getArmado(Vector2 posicion, Controlador controlador, GameObject jugador) {
		return new Armado(posicion,100,180,30,controlador,jugador);
		}

	public Enemigo getArmadoDebil(Vector2 posicion, Controlador controlador, GameObject jugador) {
		return new ArmadoDebil(posicion,50,200,20,controlador,jugador);
		}
}