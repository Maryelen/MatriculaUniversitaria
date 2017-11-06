package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidade.Aluno;

public class AlunoDAO {

	public int inserirAluno(Aluno aluno) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseService.getConnection();
			ps = conn
					.prepareStatement("INSERT INTO USUARIO (NM_USUARIO, NU_MATRICULA) VALUES (?, ?) RETURNING ID_USUARIO");
			ps.setString(1, aluno.getNome());
			ps.setInt(2, aluno.getMatricula());
			
			ps.execute();
			
			ResultSet ultimaAtualizacaoUsuario = ps.getResultSet();
			
			if(ultimaAtualizacaoUsuario.next()) {			
			return ultimaAtualizacaoUsuario.getInt(1);
			}
			
			return 0;
			
		} catch (SQLException e) {
			throw new DAOException(
					"Ocorreu um erro no banco de dados ao cadastrar o nome do ALUNO"
							+ e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
			}
		}

	}
}
