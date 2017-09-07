/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Aluno;
import Entity.Professor;
import java.util.ArrayList;

/**
 *
 * @author Maryelen
 */
public class Secretaria {
    
    ArrayList<Professor> listaProfessor;
    ArrayList<Aluno> listaAluno;

    public ArrayList<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(ArrayList<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }

    public ArrayList<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(ArrayList<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }
    
    
    
    
}
