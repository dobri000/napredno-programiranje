package rs.volleybox.common_lib.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Utility class for JSON serialization and deserialization using Jackson library.
 * Provides methods to serialize objects to JSON strings and deserialize JSON strings
 * back to objects.
 * Also includes a method to convert values from one type to another using Jackson.
 *
 * Uses JavaTimeModule to handle Java 8 time types properly.
 *
 * Note: Make sure to include Jackson library in your project dependencies.
 *
 * @author HOME
 */
public class JsonSerializationUtils {

	private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	private JsonSerializationUtils() {
	}

	/**
	 * Serializes an object to a JSON string.
	 *
	 * @param source The object to serialize.
	 * @param targetType The type reference for the target type.
	 * @param <T> The type of the object.
	 * @return The JSON string representing the serialized object.
	 * @throws JsonProcessingException If an error occurs during serialization.
	 */
	public static <T> String serializeToJson(T source, TypeReference<T> targetType) throws JsonProcessingException {
		return objectMapper.writerFor(targetType).writeValueAsString(source);
	}

	/**
	 * Deserializes an object from a JSON string.
	 *
	 * @param source The JSON string to deserialize.
	 * @param targetType The type reference for the target type.
	 * @param <T> The type of the object.
	 * @return The deserialized object.
	 * @throws IOException If an error occurs during deserialization.
	 */
	public static <T> T deserializeFromJson(String source, TypeReference<T> targetType) throws IOException {
		return objectMapper.readValue(source, targetType);
	}

	/**
	 * Converts a value from one type to another using Jackson.
	 *
	 * @param source The value to convert.
	 * @param targetType The type reference for the target type.
	 * @param <T> The type of the target object.
	 * @return The converted value.
	 * @throws IOException If an error occurs during conversion.
	 */
	public static <T> T convertValue(Object source, TypeReference<T> targetType) throws IOException {
		return objectMapper.convertValue(source, targetType);
	}
}
