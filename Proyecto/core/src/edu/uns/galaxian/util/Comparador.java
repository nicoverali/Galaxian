package edu.uns.galaxian.util;

import edu.uns.galaxian.util.enums.Comparacion;

public class Comparador {
    /**
     * Realiza la comparacion deseada entre dos numeros a y b.
     * Se toma al valor a como referencia, es decir, si la comparacion
     * es MAYOR, devuelve verdadero si a es MAYOR a b.
     * @param a Valor a
     * @param b Valor b
     * @param comparacion Comparacion deseada
     * @return Verdadero si la comparacion es verdadera
     * @throws IllegalArgumentException Si la comparacion deseada no es valida
     */
    public static boolean compararNumero(double a, double b, Comparacion comparacion) throws IllegalArgumentException{
        switch (comparacion){
            case MAYOR: return a > b;
            case MAYORIGUAL: return  a >= b;
            case IGUAL: return  a == b;
            case DISTINTO: return a != b;
            case MENORIGUAL: return a <= b;
            case MENOR: return  a < b;
            default: throw new IllegalArgumentException("La comparacion propuesta no es valida.");
        }
    }
}
