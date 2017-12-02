package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Aluno;
import Entidade.Constantes;
import Entidade.Curso;
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

}
