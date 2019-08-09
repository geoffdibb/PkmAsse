package com.BAE.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BAE.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

		@Autowired
		public PokemonController( PokemonService service) {
			this.service = service;
		}


		public PokemonService service;


		@GetMapping(value = "/getpokemon/{name}")
		public ResponseEntity<Object>  createPrizeG(@PathVariable("name") String name) {
		
			return service.getPokemon(name);
		}


		}

