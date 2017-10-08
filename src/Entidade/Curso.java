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
    
    String nome;
    String unidade;
    Disciplina disciplina;
    ArrayList<Disciplina> listaDisciplinasCurso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Disciplina> getListaDisciplinasCurso() {
        return listaDisciplinasCurso;
    }

    public void setListaDisciplinasCurso(ArrayList<Disciplina> listaDisciplinasCurso) {
        this.listaDisciplinasCurso = listaDisciplinasCurso;
    }
    
    
}
