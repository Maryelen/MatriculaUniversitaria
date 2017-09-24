package Entity;

import View.CadastroDeUsuario;
import View.TelaInicial;
import View.TelaInicialOriginal;

public class Principal {

	public void cadastrarAluno() {
		Aluno novoAluno = new Aluno();
	}

	public void cadastrarProfessor() {
		Professor novoProfessor = new Professor();
	}

	public static void main(String[] args) {
		TelaInicialOriginal telaInicial = new TelaInicialOriginal();
		telaInicial.setVisible(true);
		
		
		CadastroDeUsuario cadastroDeUsuario = new CadastroDeUsuario();
        cadastroDeUsuario.setVisible(true);
	}

}
