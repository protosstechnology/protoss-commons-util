package com.protosstechnology.commons.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.internal.Primitives;

import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONUtil {
	
	private JSONUtil() {
		super();
	}
	
	
	static JsonDeserializer<Date> deser = new JsonDateDeserializer();

	static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").registerTypeAdapter(Date.class, deser).create();


	public static Map mapFromJson(String json){
		return gson.fromJson(json,Map.class);
	}
	
	public static List listFromJson(String json){
		return gson.fromJson(json,List.class);
	}
	
	public static JSONSerializer getJSONSerializer(){
		return new JSONSerializer()
				.exclude("*.class")
				.transform(new DateTransformer("yyyy-MM-dd HH:mm:ss"), Date.class);
	}
	
	public static <T> T fromJsonPath(String json,Class<T> classOfT,String jsonPath ) {
		Map mainMap = mapFromJson(json);
		Object object = null;
		try {
			String[] jsonPathLot = jsonPath.split("\\.");
			for(String jsonSrc:jsonPathLot){
				object = mainMap.get(jsonSrc);
				if(object instanceof Map){
					mainMap = (Map) mainMap.get(jsonSrc);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	    return Primitives.wrap(classOfT).cast(object);
	  }
}
