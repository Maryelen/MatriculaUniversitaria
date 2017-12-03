package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Unidade;

public class CursoDAO {

	public int inserirCurso(Curso curso) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseService.getConnection();
			ps = conn.prepareStatement("INSERT INTO CURSO (NOME_CURSO, ID_UNIDADE) VALUES (?, ?) RETURNING ID_CURSO");
			ps.setString(1, curso.getNome());
			ps.setInt(2, curso.getUnidade().getIdUnidade());

			ps.execute();

			ResultSet ultimaAtualizacaoCurso = ps.getResultSet();

			if (ultimaAtualizacaoCurso.next()) {
				return ultimaAtualizacaoCurso.getInt(1);
			}

			return 0;

		} catch (SQLException e) {
			throw new DAOException("Ocorreu um erro no banco de dados ao cadastrar o nome do ALUNO" + e);
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
			String sql = "SELECT * FROM CURSO C JOIN UNIDADE U ON C.ID_UNIDADE = U.ID_UNIDADE ORDER BY C.NOME_CURSO ASC";
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
	
	public ArrayList<Curso> listaCursosPorNome(String nome) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Curso> listaCursos = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM CURSO C JOIN UNIDADE U ON C.ID_UNIDADE = U.ID_UNIDADE";
			
			boolean filtrarPorNome = !nome.isEmpty();
			
			if(!nome.isEmpty())
			{
				sql += " WHERE";
			}
			
			String filtro = "";
			
			if(filtrarPorNome)
			{
				if(!filtro.isEmpty())
				{
					filtro += " AND";
				}
				
				filtro+= " LOWER(C.NOME_CURSO) LIKE ?";
			}
			
			sql += filtro;
			
			sql += " ORDER BY C.NOME_CURSO ASC";
			
			ps = conn.prepareStatement(sql);
			
			int countParametros = 0;
			
			if(filtrarPorNome){
				
				countParametros ++;				
				ps.setString(countParametros, "%" + nome.toLowerCase() + "%");
			}
			
			System.out.println(ps.toString());
			
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
	
	public void excluirCursoPeloIdCurso(int idCurso) throws DAOException{
		
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseService.getConnection();
			ps = conn.prepareStatement("DELETE FROM USUARIO_CURSO_DISCIPLINA UCD "
					+ "USING CURSO_DISCIPLINA AS CD, CURSO AS C "
					+ "WHERE UCD.ID_CURSO_DISCIPLINA = CD.ID_CURSO_DISCIPLINA AND CD.ID_CURSO = C.ID_CURSO AND CD.ID_CURSO = ?" );
			ps.setInt(1, idCurso);
			ps.execute();
			ps.close();
			
			ps = conn.prepareStatement("DELETE FROM CURSO_DISCIPLINA CD WHERE CD.ID_CURSO = ?" );
			ps.setInt(1, idCurso);
			ps.execute();
			ps.close();
			
			ps = conn.prepareStatement("DELETE FROM CURSO WHERE ID_CURSO = ?");
			ps.setInt(1, idCurso);
			ps.execute();

		} catch (SQLException e) {
			throw new DAOException("Ocorreu um erro no banco de dados ao excluir o curso" + e);
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
	
	public void atualizarCurso(Curso curso, int idUnidade) throws DAOException{
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseService.getConnection();
			ps = conn.prepareStatement("UPDATE CURSO SET ID_UNIDADE = ? WHERE ID_CURSO = ?");
			ps.setInt(1, idUnidade);
			ps.setInt(2, curso.getIdCurso());
			
			System.out.println(ps.toString());
			
			ps.execute();

		} catch (SQLException e) {
			throw new DAOException("Ocorreu um erro no banco de dados ao excluir o curso" + e);
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
