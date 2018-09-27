package edu.uns.galaxian.util.io;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class GSONNonFieldTypeAdapter implements TypeAdapterFactory{

    private static final String CLASS_NAME = "className";

    private Class<?> targetClass;
    private Class<?>[] parametersTypes;
    private Object[] parameters;

    public GSONNonFieldTypeAdapter(Class<?> objClass, final Class<?>[] constructorParametersClasses, final Object[] parameters){
        this.parametersTypes = constructorParametersClasses;
        this.parameters = parameters;
        this.targetClass = objClass;
    }

    public GSONNonFieldTypeAdapter(Class<?> objClass){
        this.parametersTypes = new Class<?>[]{};
        this.parameters = new Object[]{};
        this.targetClass = objClass;
    }

    public GSONNonFieldTypeAdapter(){
        this(Object.class);
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type){

        if(!targetClass.isAssignableFrom(type.getRawType())){
            return null;
        }
        else{
            return new TypeAdapter<T>() {

                public void write(JsonWriter out, T value) throws IOException{
                    out.beginObject();
                    out.name(CLASS_NAME);
                    out.value(value.getClass().getCanonicalName());
                    out.endObject();
                }
    
                public T read(JsonReader in) throws IOException{
                    in.beginObject();
                    if(!in.hasNext() || !in.nextName().equals(CLASS_NAME)){
                        throw new IOException("The given JSON is not compatible with this TypeAdapter");
                    }
                    try{
                        String className = in.nextString();
                        Class<?> resultingClass = Class.forName(className);
                        T resultingObject = (T) resultingClass.getConstructor(parametersTypes).newInstance(parameters);
                        return resultingObject;
                    }catch(NoSuchMethodException |SecurityException e){
                        throw new IOException("A constructor with the given parameter types does not exists.", e);
                    }catch(IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        throw new IOException("Unable to instantiate class.", e);
                    }catch(ClassCastException | IllegalStateException | NullPointerException e){
                        throw new IOException("The given JSON does not contain a class serialization", e);
                    }catch(ClassNotFoundException e){
                        throw new IOException("The class store in the given JSON does not exist.", e);
                    }
                }
    
            };
        }

    }

}