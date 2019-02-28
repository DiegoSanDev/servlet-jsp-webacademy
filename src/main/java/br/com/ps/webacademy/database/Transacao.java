package br.com.ps.webacademy.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Transacao {

	public Transacao() {

	}

	public static synchronized void iniciar(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
	}

	public static synchronized void finalizar(Connection connection) throws SQLException {
		try {
			connection.commit();
		} finally {
			connection.setAutoCommit(true);
		}
	}

	public static synchronized void cancelar(Connection connection) throws SQLException {
		try {
			connection.rollback();
		} finally {
			connection.setAutoCommit(true);
		}
	}

}
