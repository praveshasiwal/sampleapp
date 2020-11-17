package com.example.sampleapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppUtils {

	public static <T> T copySourceToTarget(Object source, Class<T> clazz) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String content = objectMapper.writeValueAsString(source);
			return objectMapper.readValue(content, clazz);
		} catch (JsonProcessingException processingException) {
			log.error(processingException.getMessage(), processingException);
			throw new RuntimeException("Data Parsing Failed");
		}
	}
}
