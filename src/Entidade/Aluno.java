package Entidade;

import java.util.ArrayList;

public class Aluno {

	 private int idAluno;
	 
	public int getIdAluno() {
		return idAluno;
	}
	
	String nome;
	int matricula;
	ArrayList<Disciplina> ListaDisciplinas = new ArrayList<>();
	ArrayList<Curso> ListaCursos = new ArrayList<>();

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
}
