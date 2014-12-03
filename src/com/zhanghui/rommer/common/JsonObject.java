package com.zhanghui.rommer.common;

import java.util.LinkedHashMap;

public class JsonObject extends LinkedHashMap {
    public JsonObject(){
    }
    public JsonObject(int capacity){
        super(capacity);
    }
    public JsonObject add(String k, Object v){
        this.put(k,v);
        return this;
    }
}
