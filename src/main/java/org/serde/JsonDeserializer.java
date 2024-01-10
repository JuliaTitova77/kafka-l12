package org.serde;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;


import java.lang.reflect.Type;
import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {

    private final Gson gson;
    private Class<T> deserializedClass;


    public JsonDeserializer(Class<T> deserializedClass) {
        this.deserializedClass = deserializedClass;
        this.gson = new Gson();

    }

    @Override
    @SuppressWarnings("unchecked")
    public void configure(Map<String, ?> map, boolean b) {
        if(deserializedClass == null) {
            deserializedClass = (Class<T>) map.get("serializedClass");
        }
    }


    @Override
    public T deserialize(String s, byte[] bytes) {
         if(bytes == null){
             return null;
         }



         return gson.fromJson(new String(bytes),deserializedClass);

    }
}
