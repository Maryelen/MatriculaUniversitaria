package Entidade;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private int matricula;
	private ArrayList<Disciplina> ListaDisciplinas = new ArrayList<>();
	private ArrayList<Curso> ListaCursos = new ArrayList<>();
	private int idTipoUsuario;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Disciplina getDisciplina() {
		return getDisciplina();
	}

	public ArrayList<Disciplina> getListaDisciplinas() {
		return ListaDisciplinas;
	}

	public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
		ListaDisciplinas = listaDisciplinas;
	}

	public ArrayList<Curso> getListaCursos() {
		return ListaCursos;
	}

	public void setListaCursos(ArrayList<Curso> listaCursos) {
		ListaCursos = listaCursos;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
}
