package edu.uns.galaxian.oleada;

public abstract class OleadaDecorator implements Oleada {

    private Oleada oleada;

    public OleadaDecorator(Oleada oleada){
        this.oleada = oleada;
    }

    public void iniciar() {
        oleada.iniciar();
    }

    public void actualizar(float delta){
        oleada.actualizar(delta);
    }

    public void finalizar() {
        oleada.finalizar();
    }
}