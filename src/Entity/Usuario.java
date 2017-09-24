package Entity;

public class Usuario {
	
	String nome;	
    int matricula;
    Disciplina disciplina;

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
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public static enum OpcoesUsuario {    
        ALUNO(1), PROFESSOR(2);
        
        private final int valor;
        OpcoesUsuario(int valorOpcao){
            valor = valorOpcao;
        }
        public int getValor(){
            return valor;
        }
    }

}
