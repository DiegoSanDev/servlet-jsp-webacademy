package br.com.ps.webacademy.service;

import java.util.List;

import br.com.ps.webacademy.exception.RegraNegocioException;

public interface IService<T> {

	boolean salvar(T t) throws RegraNegocioException;
	
	List<T> todos();

}
