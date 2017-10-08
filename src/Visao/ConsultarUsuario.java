package Visao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import Controle.ControlePrincipal;
import Entidade.Aluno;
import Entidade.Professor;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;

public class ConsultarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	
	private JLabel lblConsultarUsuario;
	private JLabel lblNome;
	private JLabel lblMatricula;
	private JLabel lblResultado;
	
	private JTextField txtNome;
	private JTextField textMatricula;
	
	private JButton btnPesquisar;
	private JButton btnVoltar;

	JList<Object> listaObjetosEncontrados;
	
	public ConsultarUsuario() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 376);
		getContentPane().setLayout(null);
		
		lblConsultarUsuario = new JLabel("Consultar Usuário");
		lblConsultarUsuario.setBounds(179, 13, 145, 16);
		getContentPane().add(lblConsultarUsuario);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(51, 45, 38, 16);
		getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(158, 42, 198, 22);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 291, 115, 25);
		getContentPane().add(btnVoltar);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(355, 291, 115, 25);
		getContentPane().add(btnPesquisar);
		
		lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(51, 80, 95, 16);
		getContentPane().add(lblMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(158, 77, 198, 22);
		getContentPane().add(textMatricula);
		textMatricula.setColumns(10);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(51, 109, 95, 16);
		getContentPane().add(lblResultado);
		
		scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(158, 126, 198, 135);
		getContentPane().add(scrollPane);
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Object> objetosEncontrados = new ArrayList<>();
				
				for(Professor professor : ControlePrincipal.listaProfessores ){
					if(Integer.parseInt(textMatricula.getText()) == professor.getMatricula()){
						objetosEncontrados.add(professor);
					}
				} 

				for(Aluno aluno : ControlePrincipal.listaAlunos){
					if(Integer.parseInt(textMatricula.getText()) == aluno.getMatricula()){
						objetosEncontrados.add(aluno);
					}
				}
				
				listaObjetosEncontrados = new JList<Object>((ControlePrincipal.VetorObjetosEncontrados(objetosEncontrados)));
				listaObjetosEncontrados.setVisibleRowCount(5);
				listaObjetosEncontrados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				scrollPane.add(listaObjetosEncontrados);
				scrollPane.setViewportView(listaObjetosEncontrados);
			}
		});
	}
}
