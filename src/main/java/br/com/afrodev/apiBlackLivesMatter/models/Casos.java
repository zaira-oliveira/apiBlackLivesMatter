package br.com.afrodev.apiBlackLivesMatter.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity // Criação de Tabela
@Table(name = "TB_CasosBLM") // Dando nome à Tabela
public class Casos implements Serializable {

	private static final long serialVersionUID = 7818494152112744582L;

	@Id // Informar que este é o ID da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que os IDs são criados de forma automática*****
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	private int idade;
	private String cidade;
	private String mes;
	private int ano;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes.toUpperCase();
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}