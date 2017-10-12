package Controle;

import java.util.List;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entidade.Curso;

public class ControleDeCurso  {
	
	public void CadastrarCurso(JList<Object> listDisciplinasCurso,
			JTextField txtNome, JTextField txtUnidade) {
		
		String resumoDeValidacoes = "";

		// Valida se ext� informando o Nome do Curso
		if (txtNome.getText().isEmpty()) {
			resumoDeValidacoes += String.format("Campo Obrigat�rio!");
		}

		// Valida se tem mais de 5 disciplinas selecionadas
		if (listDisciplinasCurso.getSelectedValuesList().size() > 5) {

			resumoDeValidacoes += "N�o � poss�vel selecionar mais de 5 disciplinas! \n";

		}

		if (!resumoDeValidacoes.isEmpty()) {
			JOptionPane.showMessageDialog(null, resumoDeValidacoes);

		} else {
	
				Curso curso = new Curso();
				curso.setNome(txtNome.getText());
				curso.setUnidade(txtUnidade.getText());			
				
				ControlePrincipal.listaDisciplinasCurso.add(curso);		
			
			}
		}
}
