package br.com.ps.webacademy.service;

import java.util.List;

import br.com.ps.webacademy.exception.RegraNegocioException;

public interface IService<T> {

	T buscarPorId(int id) throws RegraNegocioException;

	boolean salvar(T t) throws RegraNegocioException;

	List<T> todos();

	boolean excluirPoId(int id) throws RegraNegocioException;

}
