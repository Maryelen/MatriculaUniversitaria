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
import Dao.UsuarioCursoDisciplinaDAO;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Unidade;

public class ControleDeCurso {

	CursoDAO cursoDAO = new CursoDAO();

	public void CadastrarCurso(JList<Disciplina> listaDisciplinasCurso, JTextField txtNome, Unidade unidade) {

		String resumoDeValidacoes = "";

		// Valida se extá informando o Nome do Curso
		if (txtNome.getText().isEmpty()) {
			resumoDeValidacoes += String.format("Campo Nome Obrigatório! \n");
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

			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");

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

	public ArrayList<Curso> pesquisaDeCurso(String nome) {

		try {
			return cursoDAO.listaCursosPorNome(nome);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void excluirCursoPeloIdCurso(int idCurso) {

		try {

			cursoDAO.excluirCursoPeloIdCurso(idCurso);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void atualizarCurso(Curso curso, ArrayList<Disciplina> disciplinasPerderamSelecao, int idUnidade) {
		
		try {

			CursoDisciplinaDAO cursoDisciplinaDAO = new CursoDisciplinaDAO();

			String ids[] = new String[disciplinasPerderamSelecao.size()];
//			StringBuilder param = new StringBuilder();
			int count = 0;
			for (Disciplina disciplina : disciplinasPerderamSelecao) {

				ids[count] = Integer.toString(disciplina.getIdDisciplina());
//				param.append("?,");
				count++;
			}

			String idsCursoDisciplina[] = cursoDisciplinaDAO.listaIdsDoRelacionamentoCursoDisciplinaPelasDisciplinas(
//					param.deleteCharAt(param.length() - 1).toString(), 
					ids);
			
			int qtdUsuariosComDisciplina = cursoDisciplinaDAO.verificaSeExisteUsuarioVinculadoNaDisciplina(idsCursoDisciplina);
			if(qtdUsuariosComDisciplina > 0){
			
			JOptionPane.showMessageDialog(null, "Existem pelo menos " + qtdUsuariosComDisciplina + " vinculados a uma das disciplinas desvinculadas!");
			
			}else{
				cursoDAO.atualizarCurso(curso, idUnidade);
			}

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
