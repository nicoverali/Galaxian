package edu.uns.galaxian.servicios;

public abstract class OleadaDecorator implements Oleada {

    protected Oleada oleada;

    public OleadaDecorator(Oleada oleada){
        this.oleada = oleada;
    }


    public void iniciar() {
        oleada.iniciar();
    }

    public void finalizar() {
        oleada.finalizar();
    }
}
