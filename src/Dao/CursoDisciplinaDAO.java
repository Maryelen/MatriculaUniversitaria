package Dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Unidade;

public class CursoDisciplinaDAO {

	public void inserirDisciplinasDoCurso(Curso curso) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			
			for(Disciplina disciplina: curso.getListaDisciplinasCurso()){
				
				conn = DataBaseService.getConnection();
				ps = conn
						.prepareStatement("INSERT INTO CURSO_DISCIPLINA (ID_CURSO, ID_DISCIPLINA) VALUES (?, ?)");
				ps.setInt(1, curso.getIdCurso());
				ps.setInt(2, disciplina.getIdDisciplina());
				
				ps.executeUpdate();
				
			}
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
	
	public Vector<Disciplina> listaDisciplinasDoCurso(int idCurso)  throws DAOException{
		Connection conn = null;
		PreparedStatement ps = null;
		Vector<Disciplina> listaDisciplinas = new Vector<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM DISCIPLINA D JOIN CURSO_DISCIPLINA CD ON D.ID_DISCIPLINA = CD.ID_DISCIPLINA WHERE CD.ID_CURSO = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCurso);
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
	
	public ArrayList<Integer> listaIdsDoRelacionamentoCursoDisciplina(int idCurso, String[] ids)  throws DAOException{
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Integer> listaIdsCursoDisciplina = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM CURSO_DISCIPLINA CD WHERE CD.ID_CURSO = ?"
					+ " AND CD.ID_DISCIPLINA = ANY (?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCurso);
			
			Array array = ps.getConnection().createArrayOf("INT", ids);
			ps.setArray(2, array);
			
//			int count = 2;
//			for(int id : ids){
//			ps.setInt(count ++, id);
//			}
			
			rs = ps.executeQuery();

			while (rs.next()) {
				listaIdsCursoDisciplina.add(rs.getInt("ID_CURSO_DISCIPLINA"));	
			}
			
			return listaIdsCursoDisciplina;
			
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
	
	public String[] listaIdsDoRelacionamentoCursoDisciplinaPelasDisciplinas(String[] ids)  throws DAOException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT ID_CURSO_DISCIPLINA FROM CURSO_DISCIPLINA CD WHERE CD.ID_DISCIPLINA = ANY (?)";
			ps = conn.prepareStatement(sql);
			
			Array array = ps.getConnection().createArrayOf("INT", ids);
			ps.setArray(1, array);
			
//			int count = 2;
//			for(int id : ids){
//			ps.setInt(count ++, id);
//			}
			System.out.println(ps.toString()); 
			rs = ps.executeQuery();

			ArrayList<String> listaIdsCursoDisciplina = new ArrayList<>();

			while (rs.next()) {
				listaIdsCursoDisciplina.add(String.valueOf(rs.getInt("ID_CURSO_DISCIPLINA")));	
			}
			
			String[] listaIds = new String[listaIdsCursoDisciplina.size()];
			
			int count = 0;
			for(String id : listaIdsCursoDisciplina)
			{
				listaIds[count] = listaIdsCursoDisciplina.get(count);
						count ++;
			}
			
			return listaIds;
			
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

	public int verificaSeExisteUsuarioVinculadoNaDisciplina(String[] idsCursoDisciplina) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Integer> listaIdsCursoDisciplina = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT DISTINCT ID_USUARIO FROM USUARIO_CURSO_DISCIPLINA CD WHERE CD.ID_CURSO_DISCIPLINA = ANY (?)";
			ps = conn.prepareStatement(sql);
			
			Array array = ps.getConnection().createArrayOf("INT", idsCursoDisciplina);
			ps.setArray(1, array);
			
//			int count = 2;
//			for(int id : ids){
//			ps.setInt(count ++, id);
//			}
			System.out.println(ps.toString()); 
			
			rs = ps.executeQuery();
			int count = 0;
			while(rs.next())
			{
				count ++;
			}
			
			return count;
			
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
