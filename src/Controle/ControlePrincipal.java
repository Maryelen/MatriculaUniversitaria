package Controle;

import java.util.ArrayList;
import java.util.Vector;

import Dao.CursoDAO;
import Dao.DAOException;
import Dao.DisciplinaDAO;
import Dao.UnidadeDAO;
import Dao.UsuarioDAO;
import Entidade.Aluno;
import Entidade.Constantes;
import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Professor;
import Entidade.Unidade;
import Entidade.Usuario;
import Visao.TelaInicial;

public class ControlePrincipal {

	public static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
	public static ArrayList<Aluno> listaAlunos = new ArrayList<>();
	public static ArrayList<Professor> listaProfessores = new ArrayList<>();
	public static ArrayList<Curso> listaCursos = new ArrayList<>();
	public static ArrayList<Unidade> listaUnidades = new ArrayList<>();
	private static UnidadeDAO unidadeDAO = new UnidadeDAO();
	private static CursoDAO cursoDAO = new CursoDAO();
	private static DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();

	private static ArrayList<Curso> getListaCursos() {
		try {
			return cursoDAO.listaCursos();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Disciplina> getListaDisciplinas() {
		try {

			return disciplinaDAO.listaDisciplinas();

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static ArrayList<Professor> getListaProfessores() {

		return listaProfessores;
	}

	public static void main(String[] args) {
		TelaInicial telaInicial = new TelaInicial();
		telaInicial.setVisible(true);

	}

	public static ArrayList<Unidade> getListaUnidades() {

		try {

			return unidadeDAO.listaUnidades();

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static Vector<Curso> VectorCursos() {

		Vector<Curso> cursos = new Vector<>();

		for (Curso curso : getListaCursos()) {
			cursos.add(curso);
		}

		return cursos;
	}

	public static Vector<Disciplina> VectorDisciplinas() {

		Vector<Disciplina> disciplinas = new Vector<>();

		for (Disciplina disciplina : getListaDisciplinas()) {
			disciplinas.add(disciplina);
		}

		return disciplinas;
	}

	public static Vector<Unidade> VectorUnidades() {

		Vector<Unidade> unidades = new Vector<>();

		for (Unidade unidade : getListaUnidades()) {
			unidades.add(unidade);
		}

		return unidades;
	}

	public static Object[] VetorObjetosEncontrados(ArrayList<Usuario> objetosEncontrados) {

		if (objetosEncontrados != null) {

			String dadosDosObjetosEncontrados[] = new String[objetosEncontrados.size()];

			int count = 0;
			for (Usuario usuario : objetosEncontrados) {
				
				String tipoUsuario = "";
				
				if(usuario.getIdTipoUsuario() == Constantes.idTipoUsuarioProfessor)
				{
					tipoUsuario = "Professor(a): ";
				}
				else
				{
					tipoUsuario = "Aluno(a): ";
				}
				
				
					dadosDosObjetosEncontrados[count] = (tipoUsuario + usuario.getNome()
							+ " - Matrícula: " + String.valueOf(usuario.getMatricula()));
					count++;
			}
			return dadosDosObjetosEncontrados;
		}

		return new String[0];
	}

	// public static String[] VetorCursos() {
	//
	// String names[] = new String[getListaCursos().size()];
	//
	// int count = 0;
	// for (Curso curso : getListaCursos()) {
	// names[count] = curso.getNome();
	// count++;
	// }
	//
	// return names;
	// }
}
