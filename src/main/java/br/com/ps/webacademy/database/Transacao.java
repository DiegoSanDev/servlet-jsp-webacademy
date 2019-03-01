package br.com.ps.webacademy.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Transacao {

	public Transacao() {

	}

	public static synchronized void iniciar(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
	}

	public static synchronized void finalizar(Connection connection) {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static synchronized void cancelar(Connection connection) {
		try {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
