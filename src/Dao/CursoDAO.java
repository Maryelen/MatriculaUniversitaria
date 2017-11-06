package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Curso;
import Entidade.Unidade;

public class CursoDAO {

	public int inserirCurso(Curso curso) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseService.getConnection();
			ps = conn
					.prepareStatement("INSERT INTO CURSO (NOME_CURSO, ID_UNIDADE) VALUES (?, ?) RETURNING ID_CURSO");
			ps.setString(1, curso.getNome());
			ps.setInt(2, curso.getUnidade().getIdUnidade());
			
			ps.execute();
			
			ResultSet ultimaAtualizacaoCurso = ps.getResultSet();
			
			if(ultimaAtualizacaoCurso.next()) {			
			return ultimaAtualizacaoCurso.getInt(1);
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
	
	public ArrayList<Curso> listaCursos() throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Curso> listaCursos = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM CURSO C JOIN UNIDADE U ON C.ID_UNIDADE = U.ID_UNIDADE";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(rs.getInt("ID_CURSO"));
				curso.setNome(rs.getString("NOME_CURSO"));
				
				Unidade unidade = new Unidade();
				unidade.setIdUnidade(rs.getInt("ID_UNIDADE"));
				unidade.setNome(rs.getString("NOME_UNIDADE"));
				
				curso.setUnidade(unidade);
				
				listaCursos.add(curso);

			}
			
			return listaCursos;
			
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
