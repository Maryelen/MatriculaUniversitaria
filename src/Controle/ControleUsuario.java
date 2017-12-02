package Controle;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.org.apache.xerces.internal.impl.xs.models.CMBuilder;

import Dao.CursoDisciplinaDAO;
import Dao.DAOException;
import Dao.UsuarioCursoDisciplinaDAO;
import Dao.UsuarioDAO;
import Entidade.Aluno;
import Entidade.Constantes;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Professor;

public class ControleUsuario {

	public String CadastrarUsuario(JComboBox<String> cmbTipoUsuario, List<Disciplina> listaDisciplinas, String matricula,
			String nomeUsuario, Curso curso) {

		String resumoDeValidacoes = "";
		
		String nuMatricula = "";
		
		int idUsuario = 0;

		resumoDeValidacoes = resumoDeValidacoes(cmbTipoUsuario, listaDisciplinas, curso, resumoDeValidacoes);

		String resumoValidacaoMatriculaAluno = validarMatriculaAluno(matricula);

		if (resumoValidacaoMatriculaAluno.isEmpty()) {
			resumoDeValidacoes += validarMatriculaProfessor(matricula);
		} else {
			resumoDeValidacoes += resumoValidacaoMatriculaAluno;
		}

		if (!resumoDeValidacoes.isEmpty()) {
			JOptionPane.showMessageDialog(null, resumoDeValidacoes);

		} else {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioAluno) {
				Aluno aluno = new Aluno();

				aluno.setNome(nomeUsuario);
//				aluno.setMatricula(Integer.parseInt(matricula));
				ArrayList<Curso> listaCursos = new ArrayList<Curso>();
				listaCursos.add(curso);
				aluno.setListaCursos(listaCursos);
				aluno.setListaDisciplinas(getDisciplinasSelecionadas(listaDisciplinas));
				aluno.setIdTipoUsuario(Constantes.idTipoUsuarioAluno);

				try {

					idUsuario = usuarioDAO.inserirUsuario(aluno);
					CursoDisciplinaDAO cursoDisciplinaDAO = new CursoDisciplinaDAO();

					String ids[] = new String[aluno.getListaDisciplinas().size()];
//					StringBuilder param = new StringBuilder();
					int count = 0;
					for (Disciplina disciplina : aluno.getListaDisciplinas()) {

						ids[count] = Integer.toString(disciplina.getIdDisciplina());
//						param.append("?,");
						count++;
					}

					ArrayList<Integer> idsCursoDisciplina = cursoDisciplinaDAO.listaIdsDoRelacionamentoCursoDisciplina(
							curso.getIdCurso(), 
//							param.deleteCharAt(param.length() - 1).toString(), 
							ids);

					UsuarioCursoDisciplinaDAO usuarioCursoDisciplinaDAO = new UsuarioCursoDisciplinaDAO();
					usuarioCursoDisciplinaDAO.inserirRelacionamentoUsuarioDisciplinasCurso(idUsuario,
							idsCursoDisciplina);

				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ControlePrincipal.listaAlunos.add(aluno);

			} else if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioProfessor) {
				Professor professor = new Professor();
				professor.setNome(nomeUsuario);
				professor.setMatricula(Integer.parseInt(matricula));
				professor.setListaDisciplinas(getDisciplinasSelecionadas(listaDisciplinas));
				professor.setIdTipoUsuario(Constantes.idTipoUsuarioProfessor);

				try {

					idUsuario = usuarioDAO.inserirUsuario(professor);
					CursoDisciplinaDAO cursoDisciplinaDAO = new CursoDisciplinaDAO();

					String ids[] = new String[professor.getListaDisciplinas().size()];
//					StringBuilder param = new StringBuilder();
					int count = 0;
					for (Disciplina disciplina : professor.getListaDisciplinas()) {

						ids[count] = Integer.toString(disciplina.getIdDisciplina());
//						param.append("?,");
						count++;
					}

					ArrayList<Integer> idsCursoDisciplina = cursoDisciplinaDAO.listaIdsDoRelacionamentoCursoDisciplina(
							curso.getIdCurso(), 
//							param.deleteCharAt(param.length() - 1).toString(), 
							ids);

					UsuarioCursoDisciplinaDAO usuarioCursoDisciplinaDAO = new UsuarioCursoDisciplinaDAO();
					usuarioCursoDisciplinaDAO.inserirRelacionamentoUsuarioDisciplinasCurso(idUsuario,
							idsCursoDisciplina);

				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ControlePrincipal.listaProfessores.add(professor);	
			}
			
			JOptionPane.showMessageDialog(null,
					String.format("%s cadastrado com Sucesso!", cmbTipoUsuario.getSelectedItem().toString()));

			try {
				nuMatricula = String.valueOf(usuarioDAO.getUsuarioPeloId(idUsuario).getMatricula());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return nuMatricula;
		}
		return "(Gerado Automaticamente ao Salvar)";
	}

	private String resumoDeValidacoes(JComboBox<String> cmbTipoUsuario, List<Disciplina> listaDisciplinas, Curso curso,
			String resumoDeValidacoes) {
		// Valida se tem algo selecionado no combo de Tipo de Usuario
		if (cmbTipoUsuario.getSelectedIndex() <= 0) {
			resumoDeValidacoes += String.format("Campo %s Obrigatório!", cmbTipoUsuario.getName()) + "\n";
		}
//
//		if (matricula.isEmpty()) {
//			resumoDeValidacoes += String.format("Campo de Matrícula Obrigatório!") + "\n";
//		}

		if (curso.getIdCurso() <= 0) {
			resumoDeValidacoes += String.format("Campo Curso Obrigatório!") + "\n";
		}

		// Valida se tem mais de 5 disciplinas selecionadas
		if (listaDisciplinas.size() > 5) {

			resumoDeValidacoes += "Não é possível selecionar mais de 5 disciplinas! \n";
		}
		
		return resumoDeValidacoes;
	}

	// usar esse método para validar cpf e rg (dados únicos)
	private String validarMatriculaAluno(String matricula) {
		for (Aluno aluno : ControlePrincipal.listaAlunos) {

			if (String.valueOf(aluno.getMatricula()).equals(matricula)) {
				return "Matricula já existe para outro usuário! \n";
			}
		}
		return "";
	}

	private String validarMatriculaProfessor(String matricula) {
		for (Professor professor : ControlePrincipal.listaProfessores) {

			if (String.valueOf(professor.getMatricula()).equals(matricula)) {
				return "Matricula já existe para outro usuário! \n";
			}
		}
		return "";
	}

	public ArrayList<Disciplina> getDisciplinasSelecionadas(List<Disciplina> listaDisciplinasSelecionadas) {

		return (ArrayList<Disciplina>) listaDisciplinasSelecionadas;
	}

	public void validaPesquisaProfessor(JTextField textMatricula, JTextField txtNome,
			ArrayList<Object> objetosEncontrados, Professor professor) {

		boolean validarMatricula = !textMatricula.getText().isEmpty()
				&& Integer.parseInt(textMatricula.getText()) == professor.getMatricula();

		boolean validarNome = !txtNome.getText().isEmpty() && txtNome.getText().equals(professor.getNome());

		if (validarMatricula && validarNome) {

			objetosEncontrados.add(professor);

		} else if (textMatricula.getText().isEmpty() && validarNome) {

			objetosEncontrados.add(professor);

		} else if (txtNome.getText().isEmpty() && validarMatricula) {

			objetosEncontrados.add(professor);
		}
	}

	public void validaPesquisaAluno(JTextField textMatricula, JTextField txtNome, ArrayList<Object> objetosEncontrados,
			Aluno aluno) {

		boolean validarMatricula = !textMatricula.getText().isEmpty()
				&& Integer.parseInt(textMatricula.getText()) == aluno.getMatricula();

		boolean validarNome = !txtNome.getText().isEmpty() && txtNome.getText().equals(aluno.getNome());

		if (validarMatricula && validarNome) {

			objetosEncontrados.add(aluno);

		} else if (textMatricula.getText().isEmpty() && validarNome) {

			objetosEncontrados.add(aluno);

		} else if (txtNome.getText().isEmpty() && validarMatricula) {

			objetosEncontrados.add(aluno);
		}
	}
}
