package edu.uns.galaxian.util.animator;

public class BezierAnimator<T extends Number> extends ValueAnimator<T>{
    protected long getValorActual() {
        long tiempoActual = getTiempoActual();
        double factorValor = Math.pow(tiempoActual, 2) * (3.0d - 2.0d * tiempoActual);
        return valorInicial.longValue() + (valorFinal.longValue() - valorInicial.longValue()) * (long) factorValor;
    }
}
