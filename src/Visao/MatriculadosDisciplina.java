package Visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controle.ControleDeCurso;
import Controle.ControlePrincipal;
import Controle.ControleUsuario;
import Entidade.Curso;
import Entidade.Disciplina;
import Util.KeySelectionRenderer;
import Util.TableModelCurso;
import Util.TableModelUsuario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class MatriculadosDisciplina extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public MatriculadosDisciplina()
	{


	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	this.setSize(500, 376);
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 482, 329);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(0, 42, 482, 287);
	panel.add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	
	JLabel lblDisciplina = new JLabel("Disciplina:");
	lblDisciplina.setBounds(87, 13, 72, 16);
	panel.add(lblDisciplina);
	
	JComboBox<Disciplina> cmbIdDisciplina = new JComboBox<Disciplina>();
	cmbIdDisciplina.setBounds(160, 10, 179, 22);
	panel.add(cmbIdDisciplina);

	for (Disciplina disciplina : ControlePrincipal.getListaDisciplinas()) {
		cmbIdDisciplina.addItem(disciplina);
	}

	KeySelectionRenderer renderer = new KeySelectionRenderer(cmbIdDisciplina) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public String getDisplayValue(Object value) {

			Disciplina disciplina = (Disciplina) value;
			return disciplina.getNome();

		}
	};
	
	cmbIdDisciplina.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// JComboBox<Curso> comboBox = (JComboBox<Curso>)e.getSource();

			if (cmbIdDisciplina.getSelectedItem() != null) {
				
				int idDisciplina = ((Disciplina) cmbIdDisciplina.getSelectedItem()).getIdDisciplina();
				
				ControleUsuario controleUsuario = new ControleUsuario();

				TableModelUsuario model = new TableModelUsuario(controleUsuario.pesquisaAlunosPorDisciplina(idDisciplina));
				
				table.setModel(model);
				
			}
		}
	});
	
}
}
