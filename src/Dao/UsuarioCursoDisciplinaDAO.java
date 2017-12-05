package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Constantes;
import Entidade.Disciplina;
import Entidade.Usuario;

public class UsuarioCursoDisciplinaDAO {

	public void inserirRelacionamentoUsuarioDisciplinasCurso(int idUsuario, ArrayList<Integer> idsCursoDisciplina,
			Usuario usuario) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
				conn = DataBaseService.getConnection();
			for (int idCursoDisciplina : idsCursoDisciplina) {
				
				ps = conn.prepareStatement(
						"INSERT INTO USUARIO_CURSO_DISCIPLINA (ID_USUARIO, ID_CURSO_DISCIPLINA) VALUES (?, ?)");
				ps.setInt(1, idUsuario);
				ps.setInt(2, idCursoDisciplina);

				ps.executeUpdate();

				ps.close();
			}
			
			if (usuario.getIdTipoUsuario() == Constantes.idTipoUsuarioAluno) {
				
				for (Disciplina disciplina : usuario.getListaDisciplinas()) {

					ps = conn.prepareStatement("UPDATE DISCIPLINA SET "
							+ "QTD_VAGAS_PREENCHIDAS = (SELECT QTD_VAGAS_PREENCHIDAS + 1 FROM DISCIPLINA  WHERE ID_DISCIPLINA = ?) "
							+ "WHERE ID_DISCIPLINA = ?");
					ps.setInt(1, disciplina.getIdDisciplina());
					ps.setInt(2, disciplina.getIdDisciplina());
					System.out.println(ps.toString());
					ps.executeUpdate();
					ps.close();
				}
			}

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
}
