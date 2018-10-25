package edu.uns.galaxian.util.camino.simple;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.util.camino.CaminoSimple;
import edu.uns.galaxian.util.enums.Direccion;

import java.util.Random;

public class CaminoAleatorio  extends CaminoSimple {

    private static final int PASO_POR_DEFECTO = 20;

    public CaminoAleatorio(Vector2 posicionInicial, Direccion direccion, int ancho, int largo, int paso, boolean impedirRetroceso, int cantMaxParadas){
        super();
        agregarPrimerParada(posicionInicial);
        Random ran = new Random();
        int sentido = getSentidoDelPaso(direccion);
        float posicionVariante = getPosicionVariante(posicionInicial, direccion);
        float posicionFija = getPosicionFija(posicionInicial, direccion);
        float recorridoActual = 0;
        while(recorridoActual <= largo){
            float pasoActual;
            if(impedirRetroceso || (largo-recorridoActual)/paso >= cantMaxParadas){
                pasoActual = paso;
            }
            else{
                // Se toma una probabilidad en la cual el paso es negativo (Se vuelve para atras)
                pasoActual = paso * Math.signum(ran.nextInt(10)-2);
            }
            if(pasoActual == 0){
                pasoActual = paso;
            }
            float posRandom = ran.nextInt(ancho) + (posicionVariante - ancho/2);
            float posFijaAdicional= (recorridoActual+pasoActual)*sentido;
            if(recorridoActual+pasoActual < 0){
                posFijaAdicional = 0;
            }
            agregarUltimaParada(crearNuevaParada(posRandom, posicionFija+ posFijaAdicional, direccion));
            recorridoActual += pasoActual;
        }
    }

    public CaminoAleatorio(Vector2 posicionInicial, Direccion direccion, int ancho, int largo, int paso){
        this(posicionInicial, direccion, ancho, largo, paso, false, Integer.MAX_VALUE);
    }

    public CaminoAleatorio(Vector2 posicionInicial, Direccion direccion, int ancho, int largo){
        this(posicionInicial, direccion, ancho, largo, PASO_POR_DEFECTO, false, Integer.MAX_VALUE);
    }

    /**
     * Genera una nueva parada con la componente
     * variante y la componente fija recibida.
     * La direccion en la cual se genera el camino
     * determinara cual es la componente variante y cual la fija
     * @param posRandom Componente variante
     * @param posFija Componente fija
     * @param direccion Direccion en la cual se genera el camino
     * @return Nueva parada a partir de las componentes variante y fija
     */
    private Vector2 crearNuevaParada(float posRandom, float posFija, Direccion direccion){
        switch (direccion){
            case ARRIBA: return new Vector2(posRandom, posFija);
            case DERECHA: return new Vector2(posFija, posRandom);
            case ABAJO: return new Vector2(posRandom, posFija);
            case IZQUIERDA: return new Vector2(posFija, posRandom);
            default: return null;
        }
    }

    /**
     * Retorna la componente variante de la posicion
     * inicial, de acuerdo a la direccion en la cual se genera el
     * camino. La componente variante es aquella que se calcula
     * de manera aleatoria en cada nueva parada
     * @param posicionInicial Posicion inicial del camino
     * @param direccion Direccion en la cual se genera el camino
     * @return Componente variante de la posicion
     */
    private float getPosicionVariante(Vector2 posicionInicial, Direccion direccion){
        switch (direccion){
            case ARRIBA: return posicionInicial.x;
            case DERECHA: return posicionInicial.y;
            case ABAJO: return posicionInicial.x;
            case IZQUIERDA: return posicionInicial.y;
            default: return 0;
        }
    }

    /**
     * Retorna cual es la componente fija de la posicion
     * inicial, de acuerdo a la direccion en la cual se genera el
     * camino. La componente fija es aquella que solo varia por el paso
     * pero su valor no es aleatorio
     * @param posicionInicial Posicion inicial del camino
     * @param direccion Direccion en la cual se genera el camino
     * @return Componente fija de la posicion
     */
    private float getPosicionFija(Vector2 posicionInicial, Direccion direccion){
        switch (direccion){
            case ARRIBA: return posicionInicial.y;
            case DERECHA: return posicionInicial.x;
            case ABAJO: return posicionInicial.y;
            case IZQUIERDA: return posicionInicial.x;
            default: return 0;
        }
    }

    /**
     * Determina si el paso debe ser positivo o negativo
     * segun la direccion en la que se genera el camino
     * @param direccion Direccion en la que se genera el camino
     * @return Sentido del paso
     */
    private int getSentidoDelPaso(Direccion direccion){
        switch (direccion){
            case ARRIBA: return 1;
            case DERECHA: return 1;
            case ABAJO: return -1;
            case IZQUIERDA: return -1;
            default: return 1;
        }
    }

}
