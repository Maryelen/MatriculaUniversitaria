package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Controle.ControleUsuario;
import Entidade.Usuario;
import Util.TableModelUsuario;

public class ConsultarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declarando variáveis e componentes
	private JScrollPane scrollPane;

	private JList<Object> listaObjetosEncontrados;

	private ArrayList<Usuario> objetosEncontrados;

	private JLabel lblConsultarUsuario;
	private JLabel lblNome;
	private JLabel lblMatricula;
	private JLabel lblResultado;

	private JTextField txtNome;
	private JTextField textMatricula;

	private JButton btnPesquisar;
	private JButton btnVoltar;

	private ControleUsuario controleUsuario;

	// Instanciando variáveis e componentes
	public void IniciarControles() {

		objetosEncontrados = new ArrayList<>();

		lblConsultarUsuario = new JLabel("Consultar Usuário");
		lblNome = new JLabel("Nome:");
		lblResultado = new JLabel("Resultado:");
		lblMatricula = new JLabel("Matrícula:");

		txtNome = new JTextField();
		textMatricula = new JTextField();
		textMatricula.setText("0");

		btnVoltar = new JButton("Voltar");
		btnPesquisar = new JButton("Pesquisar");

	}

	public ConsultarUsuario() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);
		getContentPane().setLayout(null);

		controleUsuario = new ControleUsuario();

		IniciarControles();

		lblConsultarUsuario.setBounds(179, 13, 145, 16);
		getContentPane().add(lblConsultarUsuario);

		lblNome.setBounds(51, 45, 38, 16);
		getContentPane().add(lblNome);

		txtNome.setBounds(158, 42, 198, 22);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		btnVoltar.setBounds(12, 291, 115, 25);
		getContentPane().add(btnVoltar);

		btnPesquisar.setBounds(355, 291, 115, 25);
		getContentPane().add(btnPesquisar);

		lblMatricula.setBounds(51, 80, 95, 16);
		getContentPane().add(lblMatricula);

		textMatricula.setBounds(158, 77, 198, 22);
		getContentPane().add(textMatricula);
		textMatricula.setColumns(10);

		lblResultado.setBounds(12, 109, 95, 16);
		getContentPane().add(lblResultado);

		JTable table = new JTable();
		scrollPane = new JScrollPane(table);

		scrollPane.setBounds(12, 126, 458, 135);
		getContentPane().add(scrollPane);

		btnPesquisar.addActionListener(new ActionListener() {
			// Ação do botão pesquisar
			public void actionPerformed(ActionEvent arg0) {

				objetosEncontrados = controleUsuario.pesquisaDeUsuario(textMatricula, txtNome);

				TableModelUsuario model = new TableModelUsuario(objetosEncontrados);

				table.setModel(model);

			}
		});

		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				// TODO Auto-generated method stub
				super.mouseClicked(arg0);

				table.setColumnSelectionAllowed(false);
				table.setRowSelectionAllowed(true);

				Usuario usuario = objetosEncontrados.get(table.convertRowIndexToModel(table.getSelectedRow()));

				DetalhesUsuario detalhesUsuario = new DetalhesUsuario(usuario);
				detalhesUsuario.setVisible(true);

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
}
