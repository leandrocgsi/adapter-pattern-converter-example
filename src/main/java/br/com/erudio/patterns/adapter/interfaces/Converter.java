package br.com.erudio.patterns.adapter.interfaces;

import br.com.erudio.patterns.adapter.pojo.User;

public interface Converter {
   public User convert(String schemaType, String data);
}
