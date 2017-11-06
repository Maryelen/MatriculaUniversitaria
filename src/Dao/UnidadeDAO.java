package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Curso;
import Entidade.Unidade;

public class UnidadeDAO {

	public ArrayList<Unidade> listaUnidades() throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Unidade> listaUnidades = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM UNIDADE";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Unidade unidade = new Unidade();
				unidade.setIdUnidade(rs.getInt("ID_UNIDADE"));
				unidade.setNome(rs.getString("NOME_UNIDADE"));
				listaUnidades.add(unidade);

			}
			
			return listaUnidades;
			
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
	
	public Unidade buscaUnidadePorId(int idUnidade) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<Unidade> listaUnidades = new ArrayList<>();
		ResultSet rs = null;

		try {
			conn = DataBaseService.getConnection();
			String sql = "SELECT * FROM UNIDADE WHERE ID_UNIDADE = ? LIMIT 1";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUnidade);
			rs = ps.executeQuery();

			while (rs.next()) {
				Unidade unidade = new Unidade();
				unidade.setIdUnidade(rs.getInt("ID_UNIDADE"));
				unidade.setNome(rs.getString("NOME_UNIDADE"));
				listaUnidades.add(unidade);

			}
			
			return listaUnidades.get(0);
			
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
