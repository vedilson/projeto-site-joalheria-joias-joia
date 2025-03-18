package br.com.joalheriajoiasjoia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.Usuario;
import br.com.joalheriajoiasjoia.app.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository UsuarioRepository;

	public Usuario saveUsuario(Usuario usuario) {
		return UsuarioRepository.save(usuario);
	}

	public List<Usuario> getAllUsuarios() {
		return UsuarioRepository.findAll();
	}

	public Usuario getUsuarioById(Long id) {
		return UsuarioRepository.findById(id).orElse(null);
	}

	public void deleteUsuario(Long id) {
		UsuarioRepository.deleteById(id);
	}

}
