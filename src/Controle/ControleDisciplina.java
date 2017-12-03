package Controle;

import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.DAOException;
import Dao.DisciplinaDAO;
import Entidade.Disciplina;

public class ControleDisciplina {

	public void cadastrarDisciplina(String ano, String nome, String codigo, String cargaHoraria, String numDeVagas,
			String semestre) {

		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

		Calendar calendar = Calendar.getInstance();

		String resumoDeValidacoes = "";

		if (nome.isEmpty()) {
			resumoDeValidacoes += String.format("Campo Nome Obrigatório! \n");
		}

		if (codigo.isEmpty()) {
			resumoDeValidacoes += String.format("Campo Código Obrigatório! \n");
		}

		try {
			if (!codigo.toString().isEmpty()) {

				int quantidadeEncontradaPeloCodigo = disciplinaDAO.getDisciplinaPeloCodigo(Integer.parseInt(codigo));

				if (quantidadeEncontradaPeloCodigo > 0) {
					resumoDeValidacoes += String.format("Já existe disciplina com este Código! \n");
				}
			}

			if (!nome.toString().isEmpty()) {
				int quantidadeEncontradaPeloNome = disciplinaDAO.getDisciplinaPeloNome(nome);

				if (quantidadeEncontradaPeloNome > 0) {
					resumoDeValidacoes += String.format("Já existe disciplina com este Nome! \n");
				}
			}

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ano.isEmpty() || Integer.parseInt(ano) < calendar.get(Calendar.YEAR)) {
			resumoDeValidacoes += String.format("Ano inválido! Ano deve ser maior ou igual a ano %d.",
					calendar.get(Calendar.YEAR));
		}

		if (!resumoDeValidacoes.isEmpty()) {
			JOptionPane.showMessageDialog(null, resumoDeValidacoes);
		} else {

			Disciplina disciplina = new Disciplina();
			disciplina.setNome(nome);
			disciplina.setAno(Integer.parseInt(ano));
			disciplina.setCodigo(Integer.parseInt(codigo));
			disciplina.setCargaHoraria(Integer.parseInt(cargaHoraria));
			disciplina.setNumeroVagas(Integer.parseInt(numDeVagas));
			disciplina.setSemestre(Integer.parseInt(semestre));

			try {
				disciplinaDAO.inserirDisciplina(disciplina);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ControlePrincipal.listaDisciplinas.add(disciplina);

			
			JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
		}
	}

}
