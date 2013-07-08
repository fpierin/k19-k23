package br.com.k19.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto implements Serializable {

	private static final long serialVersionUID = 7734137014982259468L;

	private String nome;
	private Double preco;
	private Long id;

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(final Double preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
