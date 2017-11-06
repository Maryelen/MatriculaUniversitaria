package Controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.CursoDAO;
import Dao.CursoDisciplinaDAO;
import Dao.DAOException;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Unidade;

public class ControleDeCurso {

	public void CadastrarCurso(JList<Disciplina> listaDisciplinasCurso, JTextField txtNome, Unidade unidade) {

		String resumoDeValidacoes = "";

		// Valida se extá informando o Nome do Curso
		if (txtNome.getText().isEmpty()) {
			resumoDeValidacoes += String.format("Campo Obrigatório!");
		}

		if (listaDisciplinasCurso.getSelectedValuesList() == null) {
			resumoDeValidacoes += "Selecione a menos uma Disciplina! \n";
		} else if (listaDisciplinasCurso.getSelectedValuesList().size() <= 0) {

			resumoDeValidacoes += "Selecione a menos uma Disciplina! \n";
		} else
		// Valida se tem mais de 5 disciplinas selecionadas
		if (listaDisciplinasCurso.getSelectedValuesList().size() > 5) {

			resumoDeValidacoes += "Não é possível selecionar mais de 5 disciplinas! \n";

		}

		if (!resumoDeValidacoes.isEmpty()) {
			JOptionPane.showMessageDialog(null, resumoDeValidacoes);

		} else {

			Curso curso = new Curso();
			curso.setNome(txtNome.getText());
			curso.setUnidade(unidade);
			curso.setListaDisciplinasCurso((ArrayList<Disciplina>) listaDisciplinasCurso.getSelectedValuesList());

			CursoDAO cursoDAO = new CursoDAO();
			CursoDisciplinaDAO cursoDisciplinaDAO = new CursoDisciplinaDAO();

			try {
				int idCurso = cursoDAO.inserirCurso(curso);
				curso.setIdCurso(idCurso);
				cursoDisciplinaDAO.inserirDisciplinasDoCurso(curso);

			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ControlePrincipal.listaDisciplinasCurso.add(curso);

		}
	}

	public static Vector<Disciplina> pegarDisciplinasPeloCurso(int idCurso) {

		if (idCurso > 0) {
			CursoDisciplinaDAO cursoDisciplinasDAO = new CursoDisciplinaDAO();

			try {
				return cursoDisciplinasDAO.listaDisciplinasDoCurso(idCurso);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

}
