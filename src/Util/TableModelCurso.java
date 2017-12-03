package Util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidade.Curso;
import Entidade.Usuario;

public class TableModelCurso extends AbstractTableModel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	List<Curso> objectList;
	String headerList[] = new String[] {"Código", "Nome", "Unidade"};

	public TableModelCurso(List<Curso> list) {
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
		Curso entity = null;
		entity = (Curso) objectList.get(row);

		switch (column) {

		case 0:
			return String.valueOf(entity.getIdCurso());
		case 1:
			return entity.getNome();
		case 2:
			return entity.getUnidade().getNome();

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
	
	   public void removeRow(int row) {
		   objectList.remove(row);
		   this.fireTableRowsDeleted(row, row);
	    }
}
