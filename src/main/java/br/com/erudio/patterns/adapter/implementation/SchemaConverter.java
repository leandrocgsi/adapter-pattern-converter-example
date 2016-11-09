package br.com.erudio.patterns.adapter.implementation;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.erudio.patterns.adapter.SchemaAdapter;
import br.com.erudio.patterns.adapter.interfaces.Converter;
import br.com.erudio.patterns.adapter.pojo.User;

public class SchemaConverter implements Converter {
	   SchemaAdapter schemaAdapter; 

	   public User convert(String mediaType, String data) {		

		   User user = new User();
	      if(mediaType.equalsIgnoreCase("xml")){
	    	    XmlMapper xmlMapper = new XmlMapper();
	    	    try {
	    	    	user = xmlMapper.readValue(data, User.class);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	      } else if(mediaType.equalsIgnoreCase("json")){
	         schemaAdapter = new SchemaAdapter(mediaType);
	         user = schemaAdapter.convert(mediaType, data);
	      } else{
	         System.out.println("Invalid media. " + mediaType + " format not supported");
	      }
		return user;
	   }   
	}