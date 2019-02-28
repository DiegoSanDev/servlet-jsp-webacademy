package br.com.ps.webacademy.database;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {

	T buscarPoId(int id);

	boolean inserir(T t) throws SQLException;

	boolean atualizar(T t) throws SQLException;

	boolean deletar(T t) throws SQLException;

	boolean deletarPoID(int id);

	List<T> todos();
}
