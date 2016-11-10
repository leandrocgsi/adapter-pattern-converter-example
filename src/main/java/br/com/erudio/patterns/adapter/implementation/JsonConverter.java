package br.com.erudio.patterns.adapter.implementation;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.erudio.patterns.adapter.interfaces.AdvancedSchemaConverter;
import br.com.erudio.patterns.adapter.pojo.User;

public class JsonConverter implements AdvancedSchemaConverter{

	public User convertJson(String data) {
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		try {
			user = mapper.readValue(data, User.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}
