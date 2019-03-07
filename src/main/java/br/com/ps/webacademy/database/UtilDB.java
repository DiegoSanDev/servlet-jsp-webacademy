package br.com.ps.webacademy.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilDB {

	public static void fechar(PreparedStatement statement) throws SQLException {
		if (statement != null) {
			statement.close();
		}
	}

	public static void fechar(ResultSet result) throws SQLException {
		if (result != null) {
			result.close();
		}
	}

	public static void fechar(PreparedStatement statement, ResultSet result) throws SQLException {
		fechar(statement);
		fechar(result);
	}

}
