package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controle.ControleDeCurso;
import Entidade.Curso;
import Util.TableModelCurso;

public class ConsultarCurso extends JFrame {
	public ConsultarCurso() {
		getContentPane().setLayout(null);
		this.setSize(500, 376);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 482, 329);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNomeCurso = new JLabel("Nome Curso:");
		lblNomeCurso.setBounds(68, 30, 80, 16);
		panel.add(lblNomeCurso);

		JLabel lblConsultarCurso = new JLabel("Consultar Curso");
		lblConsultarCurso.setBounds(162, 0, 157, 16);
		panel.add(lblConsultarCurso);

		txtNomeCurso = new JTextField();
		txtNomeCurso.setBounds(160, 27, 252, 22);
		panel.add(txtNomeCurso);
		txtNomeCurso.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 71, 458, 190);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 291, 97, 25);
		panel.add(btnVoltar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(136, 291, 97, 25);
		panel.add(btnExcluir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(257, 291, 97, 25);
		panel.add(btnEditar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(373, 291, 97, 25);
		panel.add(btnPesquisar);

		ControleDeCurso controleCurso = new ControleDeCurso();

		btnPesquisar.addActionListener(new ActionListener() {
			// Ação do botão pesquisar
			public void actionPerformed(ActionEvent arg0) {

				objetosEncontrados = controleCurso.pesquisaDeCurso(txtNomeCurso.getText());

				TableModelCurso model = new TableModelCurso(objetosEncontrados);

				table.setModel(model);

			}
		});

		btnEditar.addActionListener(new ActionListener() {
			// Ação do botão pesquisar
			public void actionPerformed(ActionEvent arg0) {

				if (table.getSelectedRow() >= 0) {

					EditarCurso editarCurso = new EditarCurso(
							objetosEncontrados.get(table.convertRowIndexToModel(table.getSelectedRow())));
					editarCurso.setVisible(true);

				}
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			// Ação do botão pesquisar
			public void actionPerformed(ActionEvent arg0) {

				controleCurso.excluirCursoPeloIdCurso(
						objetosEncontrados.get(table.convertRowIndexToModel(table.getSelectedRow())).getIdCurso());
				int modelIndex = table.convertRowIndexToModel(table.getSelectedRow());
				TableModelCurso model = (TableModelCurso) table.getModel();
				model.removeRow(modelIndex);

			}
		});

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNomeCurso;
	public static JTable table;
	private JList<Object> listaObjetosEncontrados;
	private ArrayList<Curso> objetosEncontrados;
}
