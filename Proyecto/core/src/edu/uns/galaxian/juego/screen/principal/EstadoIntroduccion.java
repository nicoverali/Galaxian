package edu.uns.galaxian.juego.screen.principal;

import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.animacion.animator.ValueAnimator;
import edu.uns.galaxian.animacion.animator.ciclos.CicloUnico;
import edu.uns.galaxian.animacion.animator.interpolaciones.BezierAnimator;
import edu.uns.galaxian.escenario.CampoEstrellas;

public class EstadoIntroduccion implements EstadoAnimacion {

    private static final float VELOCIDAD_FINAL = 400;
    private static final int DURACION = 3000;
    private ValueAnimator<Float> animator;
    private CampoEstrellas estrellas;
    private Principal principal;

    public EstadoIntroduccion(Principal principal){
        this.principal = principal;
        estrellas = principal.getEstrellas();
        animator = new BezierAnimator<>();
        animator.iniciarAnimacion(Principal.VELOCIDAD_INICIAL, VELOCIDAD_FINAL, DURACION, new CicloUnico());
    }

    public void accion(float delta) {
        if(animator.animacionFinalizada()){
            principal.setEstadoAnimacion(new EstadoPressAnyButton(principal));
        }
        else{
            estrellas.setVelocidad(animator.getValorActualFloat());
            estrellas.draw(delta);
        }
    }

}
