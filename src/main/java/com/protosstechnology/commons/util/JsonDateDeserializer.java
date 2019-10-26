package com.protosstechnology.commons.util;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class JsonDateDeserializer implements JsonDeserializer{

	@Override
	public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		return json == null ? null : new Date(json.getAsLong());
	}

}
