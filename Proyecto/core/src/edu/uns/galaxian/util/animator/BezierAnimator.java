package edu.uns.galaxian.util.animator;

public class BezierAnimator<T extends Number> extends ValueAnimator<T>{
    protected double getValorActual() {
        double tiempoActual = getTiempoActual();
        double factorValor = Math.pow(tiempoActual, 2) * (3.0d - 2.0d * tiempoActual);
        return valorInicial.doubleValue() + (valorFinal.doubleValue() - valorInicial.doubleValue()) * factorValor;
    }
}
