package edu.uns.galaxian.util.camino.simple;

import com.badlogic.gdx.math.Vector2;
import edu.uns.galaxian.util.camino.CaminoSimple;
import edu.uns.galaxian.util.enums.Direccion;

public class CaminoCircular extends CaminoSimple {

    private static final float AVANCE = 15;

    public CaminoCircular(Vector2 posicionInicial, float radio, Direccion ubicacionRespectoOrigen, boolean antihorario, float porcion){
        super();
        int sentido = antihorario ? 1 : -1;
        int porcionCreada = 0;
        float anguloInicial = getAnguloInicial(ubicacionRespectoOrigen);
        Vector2 origen = getOrigen(posicionInicial, ubicacionRespectoOrigen, radio);
        Vector2 nuevaParada;
        while(porcionCreada + AVANCE <= porcion && porcionCreada + AVANCE <= 360){
            float anguloFinal = (porcionCreada+AVANCE)*sentido + anguloInicial;
            nuevaParada = Vector2.X.cpy().setAngle(anguloFinal).setLength(radio).add(origen);
            porcionCreada += AVANCE;
            agregarUltimaParada(new Vector2(nuevaParada));
        }
        if(porcionCreada < 360 && porcionCreada != porcion){
            nuevaParada = Vector2.X.cpy().setAngle(porcion*sentido+anguloInicial).setLength(radio).add(origen);
            agregarUltimaParada(nuevaParada);
        }
        agregarPrimerParada(posicionInicial);
    }

    public CaminoCircular(Vector2 posicionInicial, float radio, Direccion ubicacionRespectoOrigen, float porcion){
        this(posicionInicial, radio, ubicacionRespectoOrigen, true, porcion);
    }

    public CaminoCircular(Vector2 posicionInicial, float radio, Direccion ubicacionRespectoOrigen){
        this(posicionInicial, radio, ubicacionRespectoOrigen, true, 360);
    }

    /**
     * A partir de una posicion inicial, la ubicacion respecto al
     * origen de la circuferencia y el radio de la circunferencia,
     * obtiene la posicion del origen de la misma.
     * @param posicionInicial Posicion inicial
     * @param ubicacionRespectoAlOrigen Ubicacion de la posicion incial respecto al origin
     * @param radio Radio de la circunferencia
     * @return Posicion del origen de la circunferencia
     */
    private Vector2 getOrigen(Vector2 posicionInicial, Direccion ubicacionRespectoAlOrigen, float radio){
        Vector2 origen = posicionInicial.cpy();
        switch (ubicacionRespectoAlOrigen){
            case ARRIBA: return origen.sub(0, radio);
            case DERECHA: return origen.sub(radio, 0);
            case ABAJO: return origen.add(0, radio);
            case IZQUIERDA: return origen.add(radio, 0);
            default: return null;
        }
    }

    private float getAnguloInicial(Direccion ubicacionRespectoAlOrigen){
        switch (ubicacionRespectoAlOrigen){
            case ARRIBA: return 90;
            case DERECHA: return 0;
            case ABAJO: return 270;
            case IZQUIERDA: return 180;
            default: return 0;
        }
    }
}