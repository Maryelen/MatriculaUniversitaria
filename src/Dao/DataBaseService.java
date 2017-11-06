package Dao;

import java.sql.*;

public class DataBaseService {
	
	protected static void registreDriver() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			throw new DAOException(
					"Ocorreu um erro ao registrar o driver JDBC", e);
		}
	}

	public static Connection getConnection() throws DAOException {
		registreDriver();
		String urlJDBC = "jdbc:postgresql://localhost:5432/MATRICULA_UNIVERSITARIA";
		try {
			return DriverManager.getConnection(urlJDBC, "postgres", "postgres");
		} catch (Exception e) {
			throw new DAOException(
					"Ocorreu um erro ao realizar a conexão com o banco de dados",
					e);
		}
	}
}
