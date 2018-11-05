package edu.uns.galaxian.util.io.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;


public class GSONClassSerializer<T> implements JsonSerializer<Class<T>> {

    private static final String CLASS_NAME = "className";

    public JsonElement serialize(Class<T> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject resultado = new JsonObject();
        resultado.addProperty(CLASS_NAME, src.getCanonicalName());
        return resultado;
    }
}
