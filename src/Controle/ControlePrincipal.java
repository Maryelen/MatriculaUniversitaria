package Controle;

import java.util.ArrayList;

import Entidade.Aluno;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Professor;
import Visao.TelaInicial;

public class ControlePrincipal {

	public static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
	public static ArrayList<Aluno> listaAlunos = new ArrayList<>();
	public static ArrayList<Professor> listaProfessores = new ArrayList<>();
	public static ArrayList<Curso> listaDisciplinasCurso = new ArrayList<>();

	private static ArrayList<Curso> getListaDisciplinasCurso() {
		return listaDisciplinasCurso;
	}

	private static ArrayList<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	private static ArrayList<Professor> getListaProfessores() {
		return listaProfessores;
	}

	public static void main(String[] args) {
		TelaInicial telaInicial = new TelaInicial();
		telaInicial.setVisible(true);

	}

	public static String[] VetorDisciplinas() {

		String names[] = new String[getListaDisciplinas().size()];

		int count = 0;
		for (Disciplina disciplina : getListaDisciplinas()) {
			names[count] = disciplina.getNome();
			count++;
		}

		return names;
	}

	public static Object[] VetorObjetosEncontrados(ArrayList<Object> objetosEncontrados) {

		String dadosDosObjetosEncontrados[] = new String[objetosEncontrados.size()];

		int count = 0;
		for (Object object : objetosEncontrados) {
			if (object instanceof Professor) {
				dadosDosObjetosEncontrados[count] = ("Professor(a): " + ((Professor) object).getNome()
						+ " - Matrícula: " + String.valueOf(((Professor) object).getMatricula()));
				count++;
			} else {
				dadosDosObjetosEncontrados[count] = ("Aluno(a): " + ((Aluno) object).getNome() + " - Matrícula: "
						+ String.valueOf(((Aluno) object).getMatricula()));

				count++;
			}
		}

		return dadosDosObjetosEncontrados;
	}

	public static String[] VetorCursos() {

		String names[] = new String[getListaDisciplinasCurso().size()];

		int count = 0;
		for (Curso curso : getListaDisciplinasCurso()) {
			names[count] = curso.getNome();
			count++;
		}

		return names;
	}
}
