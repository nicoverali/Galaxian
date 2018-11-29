package edu.uns.galaxian.observer.livedata;

public class LiveDataMutable<T> extends LiveData<T> {

    public LiveDataMutable(T valor){
        super(valor);
    }

    public void setValor(T valor){
        this.valor = valor;
        notificarObservadores();
    }
}