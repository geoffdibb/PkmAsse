package com.BAE.service;


import org.springframework.http.ResponseEntity;


public interface PokemonService {
	 ResponseEntity<Object> getPokemon(String exchangeAccount);


}
