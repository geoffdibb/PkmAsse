package com.BAE.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;



@Component
public class PokemonServiceIml implements PokemonService {
	private RestTemplate restTemplate;

	@Autowired
	public void AccountServiceImpl(  RestTemplate restTemplate ) {
		this.restTemplate = restTemplate;

	}

	@Override
	public ResponseEntity<Object> getPokemon(String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/"+name, HttpMethod.GET, entity, Object.class);

		}		

	

}
