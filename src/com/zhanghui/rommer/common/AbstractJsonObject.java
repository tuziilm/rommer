package com.zhanghui.rommer.common;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Array;

public class AbstractJsonObject implements JsonSupport{
	private final static Logger log=LoggerFactory.getLogger(AbstractJsonObject.class);
    public  static <T> T valueOf(String json, Class<T> clz) throws JsonProcessingException, IOException{
        return mapper.readValue(json, clz);
    }

    public  static <T> T nullOnExceptionValueOf(String json, Class<T> clz){
        try {
            return mapper.readValue(json, clz);
        } catch (Exception e) {
            log.error("fail to value of json string", e);
        }
        return null;
    }

    @SuppressWarnings("deprecation")
	public  static <T> String toJson(T obj) throws IOException{
        mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
        return mapper.writeValueAsString(obj);
	}

    @SuppressWarnings("deprecation")
	public  static <T> String toJsonWithNoException(T obj){
        mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
        try {
            return mapper.writeValueAsString(obj);
        }catch (Exception e){
            log.error("fail to json", e);
        }
        return "{}";
	}

	@SuppressWarnings("deprecation")
	public String toJson() throws IOException {
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
		return mapper.writeValueAsString(this);
	}
	
	@Override
	public String toString() {
        return toJsonWithNoException(this);
	}
}
