package com.ubs.assignment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class JsonObject {
    private Map<String,Object> data = new LinkedHashMap<String, Object>();
    public void put(String field,Object value){
        data.put(field,value);
    }
    public Object get(String field) {
        return  data.get(field);
    }
    public Map<String,Object> getValues(){
      return data;
    }
    @Override
    public String toString(){
        return getValues().toString();
    }
}
