package Visao;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Controle.ControleDisciplina;
import Controle.ControleUsuario;
import Entidade.Disciplina;
import Entidade.Usuario;
import Util.TableModelDisciplina;
import Util.TableModelUsuario;

public class DisciplinasPorAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtNome;
	private JTextField txtMatricula;
	ControleUsuario controleUsuario = new ControleUsuario();
	ControleDisciplina controleDisciplina = new ControleDisciplina();
	private JTable table_1;
	ArrayList<Usuario> objetosEncontrados;

	public DisciplinasPorAluno() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setSize(608, 548);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 590, 451);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 261, 578, 200);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(94, 14, 198, 22);
		panel.add(txtNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 13, 38, 16);
		panel.add(lblNome);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(12, 48, 95, 16);
		panel.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setText("0");
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(94, 49, 198, 22);
		panel.add(txtMatricula);

		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(12, 97, 578, 135);
		panel.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		JLabel label_2 = new JLabel("Resultado:");
		label_2.setBounds(12, 80, 95, 16);
		panel.add(label_2);

		JLabel lblResultadoDisciplinas = new JLabel("Resultado Disciplinas:");
		lblResultadoDisciplinas.setBounds(12, 240, 180, 16);
		panel.add(lblResultadoDisciplinas);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(304, 48, 102, 25);
		panel.add(btnPesquisar);

		JCheckBox chkCursadas = new JCheckBox("J\u00E1 Cursadas");
		chkCursadas.setBounds(150, 236, 113, 25);
		panel.add(chkCursadas);

		btnPesquisar.addActionListener(new ActionListener() {
			// Ação do botão pesquisar
			public void actionPerformed(ActionEvent arg0) {

				objetosEncontrados = controleUsuario.pesquisaDeAluno(txtMatricula, txtNome);

				TableModelUsuario model = new TableModelUsuario(objetosEncontrados);

				table_1.setModel(model);

			}
		});

		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub
				super.mouseClicked(arg0);

				table.setColumnSelectionAllowed(false);
				table.setRowSelectionAllowed(true);

				Usuario usuario = objetosEncontrados.get(table_1.convertRowIndexToModel(table_1.getSelectedRow()));

				ArrayList<Disciplina> disciplinas = controleDisciplina
						.pegarDisciplinaPeloIdUsuario(usuario.getIdUsuario(), chkCursadas.isSelected());

				if (disciplinas != null) {

					TableModelDisciplina model = new TableModelDisciplina(disciplinas);

					table.setModel(model);
				}
			}
		});

		JButton button_1 = new JButton("Voltar");
		button_1.setBounds(10, 464, 115, 25);
		getContentPane().add(button_1);

	}
}
