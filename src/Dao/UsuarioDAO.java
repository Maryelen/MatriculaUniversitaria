package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

import Entidade.Aluno;
import Entidade.Constantes;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Unidade;
import Entidade.Usuario;

public class UsuarioDAO {
	
	public int inserirUsuario(Usuario usuario) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DataBaseService.getConnection();
			ps = conn
					.prepareStatement("INSERT INTO USUARIO (NM_USUARIO, ID_TIPO_USUARIO) VALUES (?, ?) RETURNING ID_USUARIO");
			ps.setString(1, usuario.getNome());
//			ps.setInt(2, usuario.getMatricula());
			ps.setInt(2, usuario instanceof Aluno ? Constantes.idTipoUsuarioAluno : Constantes.idTipoUsuarioProfessor);
			
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
	
	public Usuario getUsuarioPeloId(int idUsuario) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();

			Usuario usuario = new Usuario();
			while (rs.next()) {
				usuario.setNome(rs.getString("NM_USUARIO"));
				usuario.setIdTipoUsuario(rs.getInt("ID_TIPO_USUARIO"));
				usuario.setMatricula(rs.getInt("NU_MATRICULA"));		
			}
			
			return usuario;
			
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
	
	public ArrayList<Usuario> pesquisaUsuario(int nuMatricula, String nome) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM USUARIO ";
			
			boolean filtrarPorMatricula = nuMatricula > 0;
			boolean filtrarPorNome = !nome.isEmpty();
			
			if(filtrarPorMatricula || !nome.isEmpty())
			{
				sql += " WHERE";
			}
			
			String filtro = "";
			
			if(filtrarPorMatricula)
			{
				filtro+= " NU_MATRICULA = ?";
			}
			
			if(filtrarPorNome)
			{
				if(!filtro.isEmpty())
				{
					filtro += " AND";
				}
				
				filtro+= " LOWER(NM_USUARIO) LIKE ?";
			}
			
			sql += filtro;
			
			ps = conn.prepareStatement(sql);
			int countParametros = 0;
			
			if(filtrarPorMatricula){
				countParametros ++;
			ps.setInt(countParametros, nuMatricula);
			}
			
			if(filtrarPorNome){
				
				countParametros ++;				
				ps.setString(countParametros, "%" + nome.toLowerCase() + "%");
			}
			
			System.out.println(ps.toString());
			
			rs = ps.executeQuery();

			ArrayList<Usuario> usuarioLista = new ArrayList<>();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
				usuario.setNome(rs.getString("NM_USUARIO"));
				usuario.setIdTipoUsuario(rs.getInt("ID_TIPO_USUARIO"));
				usuario.setMatricula(rs.getInt("NU_MATRICULA"));
				usuarioLista.add(usuario);
			}
			
			return usuarioLista;
			
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
	
	public ArrayList<Curso> listaCursosPeloIdUsuario(int idUsuario) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Curso> listaCursos = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT DISTINCT C.ID_CURSO, C.NOME_CURSO FROM CURSO C "
					+ "JOIN CURSO_DISCIPLINA CD ON C.ID_CURSO = CD.ID_CURSO "
					+ "JOIN USUARIO_CURSO_DISCIPLINA UCD ON CD.ID_CURSO_DISCIPLINA = UCD.ID_CURSO_DISCIPLINA "
					+ "WHERE UCD.ID_USUARIO = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(rs.getInt("ID_CURSO"));
				curso.setNome(rs.getString("NOME_CURSO"));
				
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
	
	public ArrayList<Disciplina> listaDisciplinaDoCursoPeloIdCurso(int idCurso) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM DISCIPLINA D "
					+ "JOIN CURSO_DISCIPLINA CD ON D.ID_DISCIPLINA = CD.ID_DISCIPLINA WHERE CD.ID_CURSO= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCurso);
			System.out.println(ps.toString());
			rs = ps.executeQuery();

			while (rs.next()) {
				Disciplina disciplina= new Disciplina();
				disciplina.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				disciplina.setNome(rs.getString("NM_DISCIPLINA"));
				disciplina.setCodigo(rs.getInt("CODIGO_DISCIPLINA"));
				disciplina.setNumeroVagas(rs.getInt("NUMERO_VAGAS"));
				disciplina.setSemestre(rs.getInt("SEMESTRE"));
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
