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
public class Curso {

	int idCurso;
	String nome;
	Unidade unidade;
	ArrayList<Disciplina> listaDisciplinasCurso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Disciplina> getListaDisciplinasCurso() {
		return listaDisciplinasCurso;
	}

	public void setListaDisciplinasCurso(ArrayList<Disciplina> listaDisciplinasCurso) {
		this.listaDisciplinasCurso = listaDisciplinasCurso;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public int idUnidade() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdCurso() {
		return idCurso;
	}

	
	
}
