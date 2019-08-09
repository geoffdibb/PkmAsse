package com.BAE.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

