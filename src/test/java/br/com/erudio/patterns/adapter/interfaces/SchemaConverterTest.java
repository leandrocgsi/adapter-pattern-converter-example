package br.com.erudio.patterns.adapter.interfaces;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.erudio.patterns.adapter.implementation.SchemaConverter;
import br.com.erudio.patterns.adapter.pojo.User;

public class SchemaConverterTest {

	@Test
	public void testConverter() throws JsonGenerationException, JsonMappingException, IOException {
		SchemaConverter schemaConverter = new SchemaConverter();
		String data = "{\"age\":31,\"messages\":[\"Message 1\",\"Message 2\",\"Message 3\",\"Message 4\"],\"name\":\"Leandro Costa\"}";
		
		User user = schemaConverter.convert("json", data);
	    Assert.assertEquals(user.getAge(), 31);
	    Assert.assertEquals(user.getName(), "Leandro Costa");
	    Assert.assertEquals(user.getMessages().size(), 4);
	}
	
	@Test
	public void testConverterXML() throws JsonGenerationException, JsonMappingException, IOException {
		SchemaConverter schemaConverter = new SchemaConverter();
		String data = "<User xmlns=\"\"><name>Leandro Costa</name><age>31</age><messages><messages>Message 1</messages><messages>Message 2</messages><messages>Message 3</messages><messages>Message 4</messages></messages></User>";
		
		User user = schemaConverter.convert("xml", data);
	    Assert.assertEquals(user.getAge(), 31);
	    Assert.assertEquals(user.getName(), "Leandro Costa");
	    Assert.assertEquals(user.getMessages().size(), 4);
	}
	
	@Test
	public void testWrite() throws JsonGenerationException, JsonMappingException, IOException {
		SchemaConverter schemaConverter = new SchemaConverter();
		String data = "{\"age\":31,\"messages\":[\"Message 1\",\"Message 2\"],\"name\":\"Leandro Costa\"}";
		
		User user = schemaConverter.convert("json", data);
		
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.writeValue(new File("simple_bean.xml"), user);
		File file = new File("simple_bean.xml");
		assertNotNull(file);
	}

}
