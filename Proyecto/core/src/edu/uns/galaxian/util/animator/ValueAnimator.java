package edu.uns.galaxian.util.animator;

import com.badlogic.gdx.utils.TimeUtils;

public abstract class ValueAnimator<T extends Number> {

    protected T valorInicial;
    protected T valorFinal;
    protected long duracion;
    protected long tiempoInicial;

    /**
     * Inicia una nueva animacion con los valores dados
     * @param valorInicial Valor inicial de la animacion
     * @param valorFinal Valor deseado al finalizar la animacion
     * @param duracion Duracion de la animacion
     */
    public void iniciarAnimacion(T valorInicial, T valorFinal, long duracion){
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.duracion = duracion;
        tiempoInicial = TimeUtils.millis();
    }

    /**
     * Retorna el valor actual de la animacion en forma entera
     * de acuerdo al tiempo transcurrido y al tipo de animacion utilizada
     * @return Valor actual entero de la animacion
     */
    public int getValorActualInt(){
        return (int) this.getValorActual();
    }

    /**
     * Retorna el valor actual de la animacion en forma float
     * de acuerdo al tiempo transcurrido y al tipo de animacion utilizada
     * @return Valor actual float de la animacion
     */
    public float getValorActualFloat(){
        return (float) this.getValorActual();
    }

    /**
     * Retorna el valor actual de la animacion en forma double
     * de acuerdo al tiempo transcurrido y al tipo de animacion utilizada
     * @return Valor actual double de la animacion
     */
    public double getValorActualDouble(){
        return this.getValorActual();
    }

    /**
     * Retorna el valor actual de la animacion en forma long
     * de acuerdo al tiempo transcurrido y al tipo de animacion utilizada
     * @return Valor actual long de la animacion
     */
    public long getValorActualLong(){
        return (long) this.getValorActual();
    }

    /**
     * Retorna el valor actual de la animacion en formato long,
     * este metodo es utilizado por la clase para abstraer el calculo
     * del valor
     * @return Valor actual de la animacion
     */
    protected abstract double getValorActual();

    /**
     * Verifica si la animacion finalizo
     * @return Verdadero si la animacion finalizo, falso en caso contrario
     */
    public boolean animacionFinalizada(){
        return TimeUtils.timeSinceMillis(tiempoInicial) >= duracion;
    }

    /**
     * Retorna un valor entre 0 y 1
     * representando el tiempo actual,
     * de acuerdo al tiempo inicial de la animacion
     * y la duracion de la misma
     * @return Valor entre 0 y 1
     */
    protected double getTiempoActual(){
        double tiempoActual = ((double)TimeUtils.timeSinceMillis(tiempoInicial)) / (double)(tiempoInicial+duracion - tiempoInicial);
        return tiempoActual > 1 ? 1 : tiempoActual;
    }

}
