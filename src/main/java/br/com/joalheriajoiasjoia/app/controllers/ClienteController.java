package br.com.joalheriajoiasjoia.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joalheriajoiasjoia.app.entities.Cliente;
import br.com.joalheriajoiasjoia.app.services.ClienteService;

@RestController
@RequestMapping("/cadastrocliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}

	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.getAllClientes();
	}

	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable Long id) {
		return clienteService.getClienteById(id);
	}

	@PutMapping
	public Cliente editCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteCliente(id);
	}

}
