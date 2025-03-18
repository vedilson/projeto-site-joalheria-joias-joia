package br.com.joalheriajoiasjoia.app.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;

	@Column(name = "nomeUsuario", nullable = false, length = 100)
	private String nomeUsuario;

	@Column(name = "cpf", nullable = false, length = 11, unique = true)
	private String cpf;

	@Column(name = "telefone", nullable = false, unique = false)
	private String telefone;

	@Column(name = "data_nascimento", unique = false)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private LocalDate dataNascimento;

	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;

	@Column(name = "senha", nullable = false, unique = true, length = 50)
	private String senha;

	// Construtores
	public Usuario() {

	}

	public Usuario(Long idUsuario, String nomeUsuario, String cpf, String telefone, LocalDate dataNascimento,
			String email, String senha) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}

	// Getters e setters
	public Long getIdCliente() {
		return idUsuario;
	}

	public void setIdCliente(Long idCliente) {
		this.idUsuario = idCliente;
	}

	public String getNomeCliente() {
		return nomeUsuario;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeUsuario = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
