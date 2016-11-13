package br.com.erudio.patterns.adapter;

import br.com.erudio.patterns.adapter.implementation.JsonConverter;
import br.com.erudio.patterns.adapter.interfaces.AdvancedSchemaConverter;
import br.com.erudio.patterns.adapter.interfaces.Converter;
import br.com.erudio.patterns.adapter.pojo.User;

public class SchemaAdapter implements Converter {

	AdvancedSchemaConverter advancedSchemaConverter;

	public SchemaAdapter(String mediaType) {

		if (mediaType.equalsIgnoreCase("json")) {
			advancedSchemaConverter = new JsonConverter();
		}
	}

	public User convert(String mediaType, String fileName) {
		User user = new User();
		if (mediaType.equalsIgnoreCase("json")) {
			user = advancedSchemaConverter.convertJson(fileName);
		}
		return user;
	}
}
