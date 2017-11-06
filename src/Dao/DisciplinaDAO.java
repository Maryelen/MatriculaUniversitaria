package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Disciplina;
import Entidade.Unidade;

public class DisciplinaDAO {

	public void inserirDisciplina(Disciplina disciplina) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseService.getConnection();
			ps = conn
					.prepareStatement("INSERT INTO DISCIPLINA (NM_DISCIPLINA, CODIGO_DISCIPLINA, NUMERO_VAGAS, SEMESTRE, ANO) "
							+ "VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, disciplina.getNome());
			ps.setInt(2, disciplina.getCodigo());
			ps.setInt(3, disciplina.getNumeroVagas());
			ps.setInt(4, disciplina.getSemestre());
			ps.setInt(5, disciplina.getAno());
			
			ps.executeUpdate();
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
	
	public ArrayList<Disciplina> listaDisciplinas() throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM DISCIPLINA";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				disciplina.setNome(rs.getString("NM_DISCIPLINA"));
				disciplina.setCodigo(rs.getInt("CODIGO_DISCIPLINA"));
				disciplina.setNumeroVagas(rs.getInt("NUMERO_VAGAS"));
				disciplina.setAno(rs.getInt("ANO"));
				listaDisciplinas.add(disciplina);

			}
			
			return listaDisciplinas;
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao listar o conteúdo" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
