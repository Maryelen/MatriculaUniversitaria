package Controle;

import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Entidade.Disciplina;

public class ControleDisciplina {

	public void cadastrarDisciplina(JTextField txtAno, JTextField txtNome, JTextField txtCodigo,
			JTextField txtCargaHoraria, JTextField txtNumDeVagas, JTextField txtSemestre) {

		Calendar calendar = Calendar.getInstance();

		if (txtAno.getText().isEmpty() || Integer.parseInt(txtAno.getText()) < calendar.get(Calendar.YEAR)) {
			JOptionPane.showMessageDialog(null,
					String.format("Ano inválido! Ano deve ser maior ou igual a ano %d.", calendar.get(Calendar.YEAR)));
		} else {

			Disciplina disciplina = new Disciplina();
			disciplina.setNome(txtNome.getText());
			disciplina.setAno(Integer.parseInt(txtAno.getText()));
			disciplina.setCodigo(Integer.parseInt(txtCodigo.getText()));
			disciplina.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
			disciplina.setNumeroVagas(Integer.parseInt(txtNumDeVagas.getText()));
			disciplina.setSemestre(Integer.parseInt(txtSemestre.getText()));
			ControlePrincipal.listaDisciplinas.add(disciplina);

		}
	}

}
