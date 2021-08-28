package com.example.eder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.eder.model.Client;
import com.example.eder.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> listar() {
		return clientRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client Add(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	
	@DeleteMapping
	public void Delete(@RequestBody Client client) {
		clientRepository.delete(client);
		
	}
	
	@PutMapping("/client")
	public Client Update(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
}
