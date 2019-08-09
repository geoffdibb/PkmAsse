package com.BAE.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

public interface PokemonService {
	 ResponseEntity<Object> getPokemon(String exchangeAccount);


}
