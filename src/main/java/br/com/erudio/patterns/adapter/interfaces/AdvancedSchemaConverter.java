package br.com.erudio.patterns.adapter.interfaces;

import br.com.erudio.patterns.adapter.pojo.User;

public interface AdvancedSchemaConverter {	
   public User convertJson(String data);
}
