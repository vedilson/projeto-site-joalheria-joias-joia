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

import br.com.joalheriajoiasjoia.app.entities.Usuario;
import br.com.joalheriajoiasjoia.app.services.UsuarioService;

@RestController
@RequestMapping("/cadastrocliente")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public Usuario createCliente(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@GetMapping
	public List<Usuario> getAllUsuario() {
		return usuarioService.getAllUsuarios();
	}

	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return usuarioService.getUsuarioById(id);
	}

	@PutMapping
	public Usuario editUsuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable Long id) {
		usuarioService.deleteUsuario(id);
	}

}
