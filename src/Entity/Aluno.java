package Entity;

import java.util.ArrayList;

public class Aluno {
	
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

    public Disciplina getDisciplina() {
        return getDisciplina();
    }

//    public void setDisciplina(Disciplina disciplina) {
//        this.disciplina = disciplina;
//    }
    
   
}
