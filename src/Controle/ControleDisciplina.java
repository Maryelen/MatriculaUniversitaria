package Controle;

import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.DAOException;
import Dao.DisciplinaDAO;
import Entidade.Disciplina;

public class ControleDisciplina {

	public void cadastrarDisciplina(String ano, String nome, String codigo,
			String cargaHoraria, String numDeVagas, String semestre) {

		Calendar calendar = Calendar.getInstance();

		if (ano.isEmpty() || Integer.parseInt(ano) < calendar.get(Calendar.YEAR)) {
			JOptionPane.showMessageDialog(null,
					String.format("Ano inválido! Ano deve ser maior ou igual a ano %d.", calendar.get(Calendar.YEAR)));
		} else {

			Disciplina disciplina = new Disciplina();
			disciplina.setNome(nome);
			disciplina.setAno(Integer.parseInt(ano));
			disciplina.setCodigo(Integer.parseInt(codigo));
			disciplina.setCargaHoraria(Integer.parseInt(cargaHoraria));
			disciplina.setNumeroVagas(Integer.parseInt(numDeVagas));
			disciplina.setSemestre(Integer.parseInt(semestre));
			
			DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
			try {
				disciplinaDAO.inserirDisciplina(disciplina);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			ControlePrincipal.listaDisciplinas.add(disciplina);

		}
	}

}
