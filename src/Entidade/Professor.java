/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.util.ArrayList;

/**
 *
 * @author Maryelen
 */
public class Professor {

	String nome;
	int matricula;
	ArrayList<Disciplina> ListaDisciplinas = new ArrayList<>();

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

	public ArrayList<Disciplina> getListaDisciplinas() {
		return ListaDisciplinas;
	}

	public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
		ListaDisciplinas = listaDisciplinas;
	}
}
