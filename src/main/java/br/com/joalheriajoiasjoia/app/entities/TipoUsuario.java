package br.com.joalheriajoiasjoia.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_usuario")
public class TipoUsuario {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_usuario", nullable = false)
	private long idTipoUsuario;

	@Column(name = "nome_tipo_usuario", nullable = false)
	private String nomeTipoUsuario;

	//Construtores
	public TipoUsuario() {

	}
	
	public TipoUsuario(long id, String nomeTipoUsuario) {
		this.idTipoUsuario = id;
		this.nomeTipoUsuario = nomeTipoUsuario;
	}

	//Getters e Setters
	public long getId() {
		return idTipoUsuario;
	}

	public void setId(long id) {
		this.idTipoUsuario = id;
	}

	public String getNomeTipoUsuario() {
		return nomeTipoUsuario;
	}

	public void setNomeTipoUsuario(String nomeTipoUsuario) {
		this.nomeTipoUsuario = nomeTipoUsuario;
	}
	
}