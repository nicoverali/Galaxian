package edu.uns.galaxian.juego.screen.menuprincipal;

import edu.uns.galaxian.animacion.EstadoAnimacion;
import edu.uns.galaxian.animacion.animator.ValueAnimator;
import edu.uns.galaxian.animacion.animator.ciclos.CicloUnico;
import edu.uns.galaxian.animacion.animator.interpolaciones.BezierAnimator;
import edu.uns.galaxian.escenario.CampoEstrellas;

class EstadoIntroduccion implements EstadoAnimacion {

    private static final float VELOCIDAD_FINAL = 400;
    private static final int DURACION = 3000;
    private ValueAnimator<Float> animator;
    private CampoEstrellas estrellas;
    private MenuPrincipal menuPrincipal;

    public EstadoIntroduccion(MenuPrincipal menuPrincipal){
        this.menuPrincipal = menuPrincipal;
        estrellas = menuPrincipal.getEstrellas();
        animator = new BezierAnimator<>();
        animator.iniciarAnimacion(MenuPrincipal.VELOCIDAD_INICIAL, VELOCIDAD_FINAL, DURACION, new CicloUnico());
    }

    public void accion(float delta) {
        if(animator.animacionFinalizada()){
            menuPrincipal.setEstadoAnimacion(new EstadoPressAnyButton(menuPrincipal));
        }
        else{
            estrellas.setVelocidad(animator.getValorActualFloat());
            estrellas.draw(delta);
        }
    }

}