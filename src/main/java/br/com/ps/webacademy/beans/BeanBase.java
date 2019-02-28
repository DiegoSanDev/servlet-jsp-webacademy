package br.com.ps.webacademy.beans;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public abstract class BeanBase implements Serializable {

	private int id;
	private LocalDate dataCadastro;
	private LocalDate dataAlteracao;

	public BeanBase() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanBase other = (BeanBase) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
