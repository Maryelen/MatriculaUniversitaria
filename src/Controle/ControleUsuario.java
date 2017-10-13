package Controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entidade.Aluno;
import Entidade.Constantes;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Professor;

public class ControleUsuario {

	public void CadastrarUsuario(JComboBox<String> cmbTipoUsuario, JList<Object> listaDisciplinas,
			JTextField txtMatricula, JTextField txtNomeUsuario) {

		String resumoDeValidacoes = "";

		// Valida se tem algo selecionado no combo de Tipo de Usuario
		if (cmbTipoUsuario.getSelectedIndex() <= 0) {
			resumoDeValidacoes += String.format("Campo %s Obrigatório!", cmbTipoUsuario.getName()) + "\n";
		}
		
		if (txtMatricula.getText().isEmpty()) {
			resumoDeValidacoes += String.format("Campo de Matrícula Obrigatório!") + "\n";
		}

		// Valida se tem mais de 5 disciplinas selecionadas
		if (listaDisciplinas.getSelectedValuesList().size() > 5) {

			resumoDeValidacoes += "Não é possível selecionar mais de 5 disciplinas! \n";

		}
		
		String resumoValidacaoMatriculaAluno = validarMatriculaAluno(txtMatricula);
		
		if(resumoValidacaoMatriculaAluno.isEmpty()){
			resumoDeValidacoes += validarMatriculaProfessor(txtMatricula);
		} else {
			resumoDeValidacoes += resumoValidacaoMatriculaAluno;
		}
		 
		if (!resumoDeValidacoes.isEmpty()) {
			JOptionPane.showMessageDialog(null, resumoDeValidacoes);

		} else {

			if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioAluno) {
				Aluno aluno = new Aluno();

				aluno.setNome(txtNomeUsuario.getText());
				aluno.setMatricula(Integer.parseInt(txtMatricula.getText()));

				aluno.setListaDisciplinas(getDisciplinasSelecionadas(listaDisciplinas.getSelectedValuesList()));
				ControlePrincipal.listaAlunos.add(aluno);

			} else if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioProfessor) {
				Professor professor = new Professor();
				professor.setNome(txtNomeUsuario.getText());
				professor.setMatricula(Integer.parseInt(txtMatricula.getText()));
				professor.setListaDisciplinas(getDisciplinasSelecionadas(listaDisciplinas.getSelectedValuesList()));

				ControlePrincipal.listaProfessores.add(professor);

			}
		}
	}
//usar esse método para validar cpf e rg (dados únicos)
	private String validarMatriculaAluno(JTextField txtMatricula) {
		for(Aluno aluno : ControlePrincipal.listaAlunos){
			
			if(String.valueOf(aluno.getMatricula()).equals(txtMatricula.getText())) {
				return "Matricula já existe para outro usuário! \n";
			}
		}
		return "";
	}
	
	private String validarMatriculaProfessor(JTextField txtMatricula) {
		for(Professor professor : ControlePrincipal.listaProfessores){
			
			if(String.valueOf(professor.getMatricula()).equals(txtMatricula.getText())) {
				return "Matricula já existe para outro usuário! \n";
			}
		}
		return "";
	}
	public ArrayList<Disciplina> getDisciplinasSelecionadas(List<Object> listaDisciplinasSelecionadas) {

		ArrayList<Disciplina> disciplinasSelecionadas = new ArrayList<>();
		for (Object disciplinaSelecionada : listaDisciplinasSelecionadas) {
			for (Disciplina disciplina : ControlePrincipal.listaDisciplinas) {

				if (disciplina.getNome().equals(disciplinaSelecionada)) {
					disciplinasSelecionadas.add(disciplina);
					break;
				}
			}
		}
		return disciplinasSelecionadas;
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

	public Vector<String> getCursos() {

		Vector<String> vector = new Vector<>();
		for (Curso curso : ControlePrincipal.listaDisciplinasCurso) {

			vector.add(curso.getNome());
		}

		return vector;
	}
}
