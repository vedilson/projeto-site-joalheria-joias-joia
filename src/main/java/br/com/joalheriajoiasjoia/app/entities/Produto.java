package br.com.joalheriajoiasjoia.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto", nullable = false)
	private long id;

	@Column(name = "nome_produto", nullable = false)
	private String nomeProduto;

	@Column(name = "descricao_produto", nullable = false)
	private String descricao;

	@Column(name = "preco_produto", nullable = false)
	private double preco;

	@Column(name = "img_produto", nullable = false)
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name = "categoria_produto", nullable = false)
	private CategoriaProduto categoriaProduto;
	
	@ManyToOne
	@JoinColumn(name = "tipo_produto", nullable = false)
	private TipoProduto tipoProduto;
	
	//Construtores
	public Produto() {
	}
	
	public Produto(long id, String nomeProduto, String descricao, double preco, String imgUrl,
			CategoriaProduto categoriaProduto, TipoProduto tipoProduto) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
		this.categoriaProduto = categoriaProduto;
		this.tipoProduto = tipoProduto;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
}
