package rs.volleybox.common_lib.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonSerializationUtils {

	
	private static final ObjectMapper objectMapper  = new ObjectMapper().registerModule(new JavaTimeModule());

	
	private JsonSerializationUtils() {
	}

	
	public static <T> String serializeToJson(T source, TypeReference<T> targetType) throws JsonProcessingException {
		return objectMapper.writerFor(targetType).writeValueAsString(source);
	}

	
	public static <T> T deserializeFromJson(String source, TypeReference<T> targetType)
			throws IOException {
		return objectMapper.readValue(source, targetType);
	}
	
	
	public static <T> T convertValue(Object source,  TypeReference<T> targetType)
			throws IOException {
		return objectMapper.convertValue(source, targetType);
	}
}
