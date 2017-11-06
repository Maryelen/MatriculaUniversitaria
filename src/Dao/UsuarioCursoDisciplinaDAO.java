package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioCursoDisciplinaDAO {
	
	public void inserirRelacionamentoUsuarioDisciplinasCurso(int idUsuario, ArrayList<Integer> idsCursoDisciplina) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			
			for(int idCursoDisciplina : idsCursoDisciplina){
				conn = DataBaseService.getConnection();
				ps = conn
						.prepareStatement("INSERT INTO USUARIO_CURSO_DISCIPLINA (ID_USUARIO, ID_CURSO_DISCIPLINA) VALUES (?, ?)");
				ps.setInt(1, idUsuario);
				ps.setInt(2, idCursoDisciplina);
				
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
}
