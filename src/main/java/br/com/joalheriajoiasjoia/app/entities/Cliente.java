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
@Table(name = "tb_cliente")
public class Cliente {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente", nullable = false)
	private Long idCliente;
	
	@Column(name = "nomeCliente", nullable = false, length = 100)
	private String nomeCliente;
	
	@Column(name = "cpf", nullable = false, length = 11, unique = true)
	private String cpf;
	
	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;
	
	@Column(name = "telefone", nullable = false,  unique = false)
	private String telefone;
	
	@Column(name = "dt_nascimento", unique = false)
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private LocalDate dataNascimento;

	// Construtores
	public Cliente() {

	}

	public Cliente(Long idCliente, String nomeCliente, String cpf, String email, String telefone,
			LocalDate dataNascimento) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}
	
	//Getters e setters
	public Long getId_cliente () {
		return idCliente;
	}
	
	public void setId_cliente (Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNomeCliente () {
		return nomeCliente;
	}
	
	public void setNome_cliente (String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDt_Nascimento() {
		return dataNascimento;
	}

	public void setDt_Nascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
