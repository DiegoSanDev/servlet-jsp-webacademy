package br.com.ps.webacademy.database;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {

	T buscarPoId(int id) throws SQLException;

	boolean inserir(T t) throws SQLException;

	boolean atualizar(T t) throws SQLException;

	boolean deletar(T t) throws SQLException;

	boolean deletarPoID(int id) throws SQLException;

	List<T> todos() throws SQLException;
}
