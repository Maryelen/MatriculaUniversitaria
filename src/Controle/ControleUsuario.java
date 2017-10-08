package Controle;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entidade.Aluno;
import Entidade.Constantes;
import Entidade.Disciplina;
import Entidade.Professor;

public class ControleUsuario {

	public void CadastrarUsuario(JComboBox<String> cmbTipoUsuario, JList<String> listaDisciplinas,
			JTextField txtMatricula, JTextField txtNomeUsuario) {
		
		String resumoDeValidacoes = "";

		// Valida se tem algo selecionado no combo de Tipo de Usuario
		if (cmbTipoUsuario.getSelectedIndex() <= 0) {
			resumoDeValidacoes += String.format("Campo %s Obrigatório!", cmbTipoUsuario.getName()) + "\n";
		}

		// Valida se tem mais de 5 disciplinas selecionadas
		if (listaDisciplinas.getSelectedValuesList().size() > 5) {

			resumoDeValidacoes += "Não é possível selecionar mais de 5 disciplinas! \n";

		}

		if (!resumoDeValidacoes.isEmpty()) {
			JOptionPane.showMessageDialog(null, resumoDeValidacoes);

		} else {

			if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioAluno) {
				Aluno aluno = new Aluno();

				// TODO: Terminar dados
				aluno.setNome(txtNomeUsuario.getText());
				aluno.setMatricula(Integer.parseInt(txtMatricula.getText()));
				
				aluno.setListaDisciplinas(getDisciplinasSelecionadas(listaDisciplinas.getSelectedValuesList()));
				ControlePrincipal.listaAlunos.add(aluno);

			} else if (cmbTipoUsuario.getSelectedIndex() == Constantes.idTipoUsuarioProfessor) {
				Professor professor = new Professor();
				//professor.setListaDisciplinas(listaDisciplinas);
				professor.setNome(txtNomeUsuario.getText());
				professor.setMatricula(Integer.parseInt(txtMatricula.getText()));
				
				
				professor.setListaDisciplinas(getDisciplinasSelecionadas(listaDisciplinas.getSelectedValuesList()));
				
				
				ControlePrincipal.listaProfessores.add(professor);

			}
		}
	}
	
	public ArrayList<Disciplina> getDisciplinasSelecionadas(List<String> listaDisciplinasSelecionadas){
	
		ArrayList<Disciplina> disciplinasSelecionadas = new ArrayList<>();
		for( String disciplinaSelecionada : listaDisciplinasSelecionadas ){
			for( Disciplina disciplina: ControlePrincipal.listaDisciplinas ){
				
				if(disciplina.getNome().equals(disciplinaSelecionada))
				{
					disciplinasSelecionadas.add(disciplina);
					break;
				}
			}
		}
		return disciplinasSelecionadas;
	}
}
