package br.com.ps.webacademy.beans;

@SuppressWarnings("serial")
public class Curso extends BeanBase {

	private String nome;
	private String descricao;

	public Curso() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
