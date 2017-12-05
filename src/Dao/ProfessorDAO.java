package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Constantes;
import Entidade.Professor;
import Entidade.Usuario;

public class ProfessorDAO {
	
	public ArrayList<Usuario> pesquisaProfessor(int nuMatricula, String nome) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM USUARIO WHERE ID_TIPO_USUARIO = ? ";
			
			boolean filtrarPorMatricula = nuMatricula > 0;
			boolean filtrarPorNome = !nome.isEmpty();
			
			String filtro = "";
			
			if(filtrarPorMatricula)
			{
				filtro+= " AND NU_MATRICULA = ?";
			}
			
			if(filtrarPorNome)
			{		
				filtro+= " AND LOWER(NM_USUARIO) LIKE ?";
			}
			
			sql += filtro;
			
			ps = conn.prepareStatement(sql);
			int countParametros = 0;
			
			countParametros++;
			ps.setInt(1, Constantes.idTipoUsuarioProfessor);
			
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
}
