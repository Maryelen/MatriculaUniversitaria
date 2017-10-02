package Entity;

import java.util.ArrayList;

import View.CadastroDeUsuario;
import View.TelaInicial;
import View.TelaInicialOriginal;

public class Principal {

	public static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>(); 
		
	private static ArrayList<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public static void main(String[] args) {
		TelaInicialOriginal telaInicial = new TelaInicialOriginal();
		telaInicial.setVisible(true);
		
	}
	
	public static String [] VetorDisciplinas(){
		
		String names[] = new String[getListaDisciplinas().size()];
		
		int count = 0;
		for(Disciplina disciplina : getListaDisciplinas()){
			names[count] = disciplina.getNome();
			count++;
		}
		
		return names;
	}

}
