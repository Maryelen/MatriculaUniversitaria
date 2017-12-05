package Util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidade.Curso;
import Entidade.Disciplina;
import Entidade.Usuario;

public class TableModelDisciplina extends AbstractTableModel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	List<Disciplina> objectList;
	String headerList[] = new String[] {"Código da Disciplina", "Nome", "Número de Vagas", "Semestre", "Ano", "Qtd. Vagas Preenchidas"};

	public TableModelDisciplina(List<Disciplina> list) {
		objectList = list;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return objectList.size();
	}

	// this method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int column) {
		Disciplina entity = null;
		entity = (Disciplina) objectList.get(row);

		switch (column) {

		case 0:
			return String.valueOf(entity.getCodigo());
		case 1:
			return entity.getNome();
		case 2:
			return String.valueOf(entity.getNumeroVagas());
		case 3:
			return String.valueOf(entity.getSemestre());
		case 4:
			return String.valueOf(entity.getAno());
		case 5:
			return String.valueOf(entity.getQtdVagasPreenchidas());

		default:

			return "";
		}
	}

	// This method will be used to display the name of columns
	public String getColumnName(int col) {
		return headerList[col];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
