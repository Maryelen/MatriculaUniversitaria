package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Disciplina;

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
	
	public int getDisciplinaPeloCodigo(int codigoDisciplina) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT COUNT(ID_DISCIPLINA) FROM DISCIPLINA WHERE CODIGO_DISCIPLINA= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoDisciplina);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				return rs.getInt("COUNT");		
			}
			
			return 0;
			
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
	
	public int getDisciplinaPeloNome(String nomeDisciplina) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT COUNT(ID_DISCIPLINA) FROM DISCIPLINA WHERE NM_DISCIPLINA= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nomeDisciplina);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				return rs.getInt("COUNT");		
			}
			
			return 0;
			
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
	
	public ArrayList<Disciplina> listaDisciplinasPeloIdUsuario(int idUsuario, boolean jaCursadas) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM DISCIPLINA D "
						+ "JOIN CURSO_DISCIPLINA CD ON D.ID_DISCIPLINA = CD.ID_DISCIPLINA "
						+ "JOIN USUARIO_CURSO_DISCIPLINA UCD ON UCD.ID_CURSO_DISCIPLINA = CD.ID_CURSO_DISCIPLINA "
						+ "WHERE UCD.ID_USUARIO = ?";
			
			if(jaCursadas)
			{
				sql += " AND D.ANO <= EXTRACT(YEAR FROM current_date) "
						+ "AND (EXTRACT(MONTH FROM current_date) > 6 AND D.SEMESTRE = 1)";
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			System.out.println(ps.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				disciplina.setNome(rs.getString("NM_DISCIPLINA"));
				disciplina.setCodigo(rs.getInt("CODIGO_DISCIPLINA"));
				disciplina.setNumeroVagas(rs.getInt("NUMERO_VAGAS"));
				disciplina.setSemestre(rs.getInt("SEMESTRE"));
				disciplina.setAno(rs.getInt("ANO"));
				disciplina.setQtdVagasPreenchidas(rs.getInt("QTD_VAGAS_PREENCHIDAS"));
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
