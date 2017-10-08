package Controle;

import java.util.ArrayList;

import Entidade.Aluno;
import Entidade.Disciplina;
import Entidade.Professor;
import Visao.TelaInicial;

public class ControlePrincipal {

	public static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
	public static ArrayList<Aluno> listaAlunos = new ArrayList<>();
	public static ArrayList<Professor> listaProfessores = new ArrayList<>();
	
	private static ArrayList<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}
	
	private static ArrayList<Professor> getListaProfessores() {
		return listaProfessores;
	}

	public static void main(String[] args) {
		TelaInicial telaInicial = new TelaInicial();
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
public static String [] VetorObjetosEncontrados(ArrayList<Object> objetosEncontrados){
		
		String matriculasDosObjetosEncontrados[] = new String[objetosEncontrados.size()];
		
		int count = 0;
		for(Object object : objetosEncontrados){
			if(object instanceof Professor){
				matriculasDosObjetosEncontrados[count] =  String.valueOf(((Professor) object).getMatricula());
			count++;
			}
			else
			{
				matriculasDosObjetosEncontrados[count] =  String.valueOf(((Aluno) object).getMatricula());
				count++;
			}
		}
		
		return matriculasDosObjetosEncontrados;
	}
}
