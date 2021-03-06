package edu.uns.galaxian.observer.livedata;

import edu.uns.galaxian.observer.Observador;

import java.util.Collection;
import java.util.LinkedHashSet;

public class LiveData<T> {

    protected T valor;
    protected Collection<Observador<LiveData<T>>> observadores;
    protected Collection<Observador<LiveData<T>>> observadoresPendientes;
    protected Collection<Observador<LiveData<T>>> observadoresEliminados;

    public LiveData(T valor){
        this.valor = valor;
        observadores = new LinkedHashSet<>();
        observadoresPendientes = new LinkedHashSet<>();
        observadoresEliminados = new LinkedHashSet<>();
    }

    /**
     * Retorna el valor almacenado.
     * @return Valor almacenado
     */
    public T getValor() {
        return valor;
    }

    /**
     * Agrega un nuevo observador al estado del valor almacenado.
     * @param observador Nuevo observador
     */
    public void observar(Observador<LiveData<T>> observador){
        observadoresPendientes.add(observador);
    }

    /**
     * Remueve un observador del valor almacenado.
     * @param observador Observador a remover
     */
    public void removerObservador(Observador<LiveData<T>> observador){
        observadoresEliminados.remove(observador);
    }

    /**
     * Notifica a todos sus observadores que se produjo un cambio en el
     * valor almacenado.
     */
    public void notificarObservadores(){
    	for(Observador<LiveData<T>> observador : observadoresPendientes){
            observadores.add(observador);
        }
    	
    	for(Observador<LiveData<T>> observador : observadoresEliminados){
            observadores.remove(observador);
        }
    	
        for(Observador<LiveData<T>> observador : observadores){
            observador.notificar(this);
        }
    }
    
}