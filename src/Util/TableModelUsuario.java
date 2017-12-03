package Util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidade.Curso;
import Entidade.Usuario;

public class TableModelUsuario extends AbstractTableModel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	List<Usuario> objectList;
	String headerList[] = new String[] {"Código", "Nome","Matricula"};

	public TableModelUsuario(List<Usuario> list) {
		objectList = list;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return objectList.size();
	}

	// this method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int column) {
		Usuario entity = null;
		entity = (Usuario) objectList.get(row);

		switch (column) {

		case 0:
			return String.valueOf(entity.getIdUsuario());
		case 1:
			return entity.getNome();
		case 2:
			return String.valueOf(entity.getMatricula());

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
