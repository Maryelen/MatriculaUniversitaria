package Visao;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import Controle.ControlePrincipal;
import Controle.ControleUsuario;
import Entidade.Aluno;
import Entidade.Professor;

import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;

public class ConsultarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declarando variáveis e componentes
	private JScrollPane scrollPane;

	private JList<Object> listaObjetosEncontrados;

	private ArrayList<Object> objetosEncontrados;

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

		scrollPane = new JScrollPane((Component) null);

		objetosEncontrados = new ArrayList<>();

		lblConsultarUsuario = new JLabel("Consultar Usuário");
		lblNome = new JLabel("Nome:");
		lblResultado = new JLabel("Resultado:");
		lblMatricula = new JLabel("Matrícula:");

		txtNome = new JTextField();
		textMatricula = new JTextField();

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

		lblResultado.setBounds(51, 109, 95, 16);
		getContentPane().add(lblResultado);

		scrollPane.setBounds(158, 126, 198, 135);
		getContentPane().add(scrollPane);

		btnPesquisar.addActionListener(new ActionListener() {
			// Ação do botão pesquisar
			public void actionPerformed(ActionEvent arg0) {

				for (Professor professor : ControlePrincipal.listaProfessores) {

					controleUsuario.validaPesquisaProfessor(textMatricula, txtNome, objetosEncontrados, professor);
				}

				for (Aluno aluno : ControlePrincipal.listaAlunos) {
						
						controleUsuario.validaPesquisaAluno(textMatricula, txtNome, objetosEncontrados, aluno);
				}

				listaObjetosEncontrados = new JList<Object>(
						(ControlePrincipal.VetorObjetosEncontrados(objetosEncontrados)));
				listaObjetosEncontrados.setVisibleRowCount(5);
				listaObjetosEncontrados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				
				scrollPane.add(listaObjetosEncontrados);
				scrollPane.setViewportView(listaObjetosEncontrados);
			}

			
		});
	}
}
