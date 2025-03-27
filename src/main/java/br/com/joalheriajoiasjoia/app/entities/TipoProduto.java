package br.com.joalheriajoiasjoia.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_produto")
public class TipoProduto {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_produto", nullable = false)
	private long id;

	@Column(name = "nome_tipo_produto", nullable = false)
	private String nomeProduto;

	@Column(name = "descricao_tipo_produto", nullable = false)
	private String descricao;
	
	//Copnstrutores
	public TipoProduto() {

	}

	public TipoProduto(long id, String nomeProduto, String descricao) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
	}
	
	//Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
